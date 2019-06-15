/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Schema(description = "Creates the required link between RuleOp and its optional children creating a hierarchy ")
@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleLink extends Baseclass {
	private static FlexiCoreRuleLink s_Singleton=new FlexiCoreRuleLink();
	public  static FlexiCoreRuleLink s() {return s_Singleton;}

	@Schema(description = "List of rules to evaluate")
	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule ruleToEval;
	@Schema(description = "The parent RuleOp connected, for example an AND RuleOp will evaluate all children and return true only of all its children rules are evaluated to true")
	@ManyToOne(targetEntity = FlexiCoreRuleOp.class)
	private FlexiCoreRuleOp ruleOp;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	public FlexiCoreRule getRuleToEval() {
		return ruleToEval;
	}

	public <T extends FlexiCoreRuleLink> T setRuleToEval(FlexiCoreRule ruleToEval) {
		this.ruleToEval = ruleToEval;
		return (T) this;
	}

	@ManyToOne(targetEntity = FlexiCoreRuleOp.class)
	public FlexiCoreRuleOp getRuleOp() {
		return ruleOp;
	}

	public <T extends FlexiCoreRuleLink> T setRuleOp(FlexiCoreRuleOp ruleOp) {
		this.ruleOp = ruleOp;
		return (T) this;
	}
}
