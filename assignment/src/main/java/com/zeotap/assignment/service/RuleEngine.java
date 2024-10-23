package com.zeotap.assignment.service;

import com.zeotap.assignment.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RuleEngine {

    // Create rule (convert rule string to AST)
    public Node create_rule(String ruleString) {
        // Simple parsing logic for demonstration purposes
        String[] parts = ruleString.split(" ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid rule format.");
        }

        Node leftOperand = new Node("operand", parts[0]);
        String operator = parts[1];
        Node rightOperand = new Node("operand", parts[2]);

        return new Node("operator", operator, leftOperand, rightOperand);
    }

    // Combine rules into a single AST
    public Node combineRules(String[] rules) {
        if (rules.length == 0) return null;

        Node root = new Node("operator", "OR"); // Root operator is OR
        Node previous = create_rule(rules[0]);

        for (int i = 1; i < rules.length; i++) {
            Node current = create_rule(rules[i]);
            Node newRoot = new Node("operator", "OR"); // Create new OR node
            newRoot.setLeft(previous);
            newRoot.setRight(current);
            previous = newRoot; // Update previous to new combined root
        }

        return previous; // Return the combined root node
    }

    // Evaluate the rules against the data
    public String evaluateRules(List<String> rules, Map<String, Object> data) {
        // Check for null or empty rules
        if (rules == null || rules.isEmpty()) {
            throw new IllegalArgumentException("Rules list cannot be null or empty.");
        }

        // Check for null data
        if (data == null) {
            throw new IllegalArgumentException("Data map cannot be null.");
        }

        for (String rule : rules) {
            // Check if the rule itself is not null or empty
            if (rule == null || rule.trim().isEmpty()) {
                continue; // Skip invalid rules
            }

            if (evaluateCondition(rule, data)) {
                return "Not Eligible"; // If any rule matches, user is not eligible
            }
        }
        return "Eligible"; // If no rules matched, user is eligible
    }

    // Private method to evaluate individual conditions
    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        // Basic parsing for conditions like "age > 30", "age < 25", or "department = 'Sales'"
        if (condition.contains(">")) {
            String[] parts = condition.split(">");
            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            return (int) data.get(key) > value;
        } else if (condition.contains("<")) {
            String[] parts = condition.split("<");
            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            return (int) data.get(key) < value;
        } else if (condition.contains("=")) {
            String[] parts = condition.split("=");
            String key = parts[0].trim();
            String value = parts[1].trim().replace("'", "");
            return data.get(key).equals(value);
        } else if (condition.contains("!=")) {
            String[] parts = condition.split("!=");
            String key = parts[0].trim();
            String value = parts[1].trim().replace("'", "");
            return !data.get(key).equals(value);
        }
        return false; // Invalid condition format
    }
}
