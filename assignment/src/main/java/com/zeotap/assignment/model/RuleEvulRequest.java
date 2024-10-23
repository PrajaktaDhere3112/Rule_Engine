package com.zeotap.assignment.model;

import java.util.List;
import java.util.Map;

public class RuleEvulRequest {
    private List<String> rules;
    private Map<String, Object> data;

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
