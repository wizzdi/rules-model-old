/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class RuleToArgument extends Baseclass {
	private static RuleToArgument s_Singleton=new RuleToArgument();
	public  static RuleToArgument s() {return s_Singleton;}

	private int ordinal;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule flexiCoreRule;
	@ManyToOne(targetEntity = FlexiCoreRuleArgument.class)

	private FlexiCoreRuleArgument flexiCoreRuleArgument;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	public FlexiCoreRule getFlexiCoreRule() {
		return flexiCoreRule;
	}

	public <T extends RuleToArgument> T setFlexiCoreRule(FlexiCoreRule flexiCoreRule) {
		this.flexiCoreRule = flexiCoreRule;
		return (T) this;
	}

	@ManyToOne(targetEntity = FlexiCoreRuleArgument.class)
	public FlexiCoreRuleArgument getFlexiCoreRuleArgument() {
		return flexiCoreRuleArgument;
	}

	public <T extends RuleToArgument> T setFlexiCoreRuleArgument(FlexiCoreRuleArgument flexiCoreRuleArgument) {
		this.flexiCoreRuleArgument = flexiCoreRuleArgument;
		return (T) this;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public <T extends RuleToArgument> T setOrdinal(int ordinal) {
		this.ordinal = ordinal;
		return (T) this;
	}
}
