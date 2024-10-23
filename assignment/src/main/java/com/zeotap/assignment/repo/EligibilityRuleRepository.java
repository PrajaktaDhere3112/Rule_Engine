package com.zeotap.assignment.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zeotap.assignment.model.EligibilityRule;

public interface EligibilityRuleRepository extends JpaRepository<EligibilityRule, Long> {
}

