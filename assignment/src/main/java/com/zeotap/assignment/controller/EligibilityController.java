package com.zeotap.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zeotap.assignment.model.*;
import com.zeotap.assignment.model.RuleEvulRequest; // Make sure to import this model
import com.zeotap.assignment.service.RuleEngine;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class EligibilityController {

    @Autowired
    private RuleEngine ruleEngine;

    // Create Rule API
    @PostMapping("/create")
    public Node createRule(@RequestBody Map<String, String> request) {
        String ruleString = request.get("ruleString");
        return ruleEngine.create_rule(ruleString);
    }

    // Combine Rules API
    @PostMapping("/combine")
    public Node combineRules(@RequestBody Map<String, List<String>> request) {
        List<String> rules = request.get("rules");
        return ruleEngine.combineRules(rules.toArray(new String[0]));
    }

    // Evaluate Rule API
    @PostMapping("/evaluate")
    public String evaluateRule(@RequestBody RuleEvulRequest request) {
        List<String> rules = request.getRules();
        Map<String, Object> data = request.getData();

        // Ensure rules and data are not null
        if (rules == null || data == null) {
            throw new IllegalArgumentException("Rules and data cannot be null.");
        }

        // Delegate rule evaluation to the service
        return ruleEngine.evaluateRules(rules, data);
    }
}
