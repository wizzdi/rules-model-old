/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.FlexiCoreServerToBaseclass;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class RuleToExecutionParameter {
	private static RuleToExecutionParameter s_Singleton=new RuleToExecutionParameter();
	public  static RuleToExecutionParameter s() {return s_Singleton;}

	private int ordinal;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule flexiCoreRule;
	@ManyToOne(targetEntity = ExecutionParametersHolder.class)

	private ExecutionParametersHolder executionParametersHolder;

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	public FlexiCoreRule getFlexiCoreRule() {
		return flexiCoreRule;
	}

	public <T extends RuleToExecutionParameter> T setFlexiCoreRule(FlexiCoreRule flexiCoreRule) {
		this.flexiCoreRule = flexiCoreRule;
		return (T) this;
	}

	@ManyToOne(targetEntity = ExecutionParametersHolder.class)
	public ExecutionParametersHolder getExecutionParametersHolder() {
		return executionParametersHolder;
	}

	public <T extends RuleToExecutionParameter> T setExecutionParametersHolder(ExecutionParametersHolder executionParametersHolder) {
		this.executionParametersHolder = executionParametersHolder;
		return (T) this;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public <T extends RuleToExecutionParameter> T setOrdinal(int ordinal) {
		this.ordinal = ordinal;
		return (T) this;
	}
}
