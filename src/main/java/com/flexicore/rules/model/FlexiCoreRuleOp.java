/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "A RuleOP provides a convenient way to create multi rules expressions, as it extends FlexiCore Rule, it can be used as such")
@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleOp extends FlexiCoreRule {
	private static FlexiCoreRuleOp s_Singleton = new FlexiCoreRuleOp();
	public static FlexiCoreRuleOp s() {
		return s_Singleton;
	}
	@Schema(description = "The type of this RuleOPType, this is NOT, AND, OR")
	private RuleOpType ruleOpType;

	@OneToMany(targetEntity = FlexiCoreRuleLink.class, mappedBy = "ruleToEval")
	@JsonIgnore
	private List<FlexiCoreRuleLink> andRules = new ArrayList<>();

	public FlexiCoreRuleOp() {
	}

	public FlexiCoreRuleOp(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = FlexiCoreRuleLink.class, mappedBy = "ruleToEval")
	@JsonIgnore
	public List<FlexiCoreRuleLink> getAndRules() {
		return andRules;
	}

	public <T extends FlexiCoreRuleOp> T setAndRules(
			List<FlexiCoreRuleLink> andRules) {
		this.andRules = andRules;
		return (T) this;
	}

	public RuleOpType getRuleOpType() {
		return ruleOpType;
	}

	public <T extends FlexiCoreRuleOp> T setRuleOpType(RuleOpType ruleOpType) {
		this.ruleOpType = ruleOpType;
		return (T) this;
	}
}
