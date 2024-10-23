package com.zeotap.assignment.model;



public class Node {
    private String type; // "operator" or "operand"
    private String value;
    private Node left;
    private Node right;

    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Node(String type, String value, Node left, Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // Getters and Setters
    public String getType() { return type; }
    public String getValue() { return value; }
    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }
    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }
}
