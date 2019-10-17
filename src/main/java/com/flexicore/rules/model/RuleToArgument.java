/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class RuleToArgument extends Baseclass {
	private static RuleToArgument s_Singleton=new RuleToArgument();
	public  static RuleToArgument s() {return s_Singleton;}
	@Schema(name="Ordinal",description = "The ordinal must be unique and must be known by the JS script evaluating the rule")
	private int ordinal;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule flexiCoreRule;
	@ManyToOne(targetEntity = FlexiCoreRuleArgument.class)
	private FlexiCoreRuleArgument flexiCoreRuleArgument;

	public RuleToArgument() {
	}

	public RuleToArgument(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@Schema(name="FlexiCoreRule",description = "The linked FlexiCoreRule, note that a FlexiCoreRule will always transfer to Javascript all the arguments it is linked with")
	@ManyToOne(targetEntity = FlexiCoreRule.class)
	public FlexiCoreRule getFlexiCoreRule() {
		return flexiCoreRule;
	}

	public <T extends RuleToArgument> T setFlexiCoreRule(FlexiCoreRule flexiCoreRule) {
		this.flexiCoreRule = flexiCoreRule;
		return (T) this;
	}
	@Schema(name="FlexiCoreRuleArgument",description = "The linked RuleArgument, note that a RuleArgument can be used with with other rules.")

	@ManyToOne(targetEntity = FlexiCoreRuleArgument.class)
	public FlexiCoreRuleArgument getFlexiCoreRuleArgument() {
		return flexiCoreRuleArgument;
	}

	public <T extends RuleToArgument> T setFlexiCoreRuleArgument(FlexiCoreRuleArgument flexiCoreRuleArgument) {
		this.flexiCoreRuleArgument = flexiCoreRuleArgument;
		return (T) this;
	}
	@Schema(name="Ordinal",description = "The ordinal must be unique and must be known by the JS script evaluating the rule")

	public int getOrdinal() {
		return ordinal;
	}

	public <T extends RuleToArgument> T setOrdinal(int ordinal) {
		this.ordinal = ordinal;
		return (T) this;
	}
}
