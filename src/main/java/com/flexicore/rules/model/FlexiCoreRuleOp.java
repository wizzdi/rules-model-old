/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleOp extends FlexiCoreRule {
	private static FlexiCoreRuleOp s_Singleton=new FlexiCoreRuleOp();
	public  static FlexiCoreRuleOp s() {return s_Singleton;}

	private RuleOpType ruleOpType;

	@OneToMany(targetEntity = FlexiCoreRule.class,mappedBy ="ruleSet" )
	@JsonIgnore
	private List<FlexiCoreRuleLink> andRules=new ArrayList<>();

	@OneToMany(targetEntity = FlexiCoreRule.class,mappedBy ="ruleSet" )
	@JsonIgnore
	public List<FlexiCoreRuleLink> getAndRules() {
		return andRules;
	}

	public <T extends FlexiCoreRuleOp> T setAndRules(List<FlexiCoreRuleLink> andRules) {
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
