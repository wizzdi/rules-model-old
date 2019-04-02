/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleArgument extends Baseclass {
	private static FlexiCoreRuleArgument s_Singleton=new FlexiCoreRuleArgument();
	public  static FlexiCoreRuleArgument s() {return s_Singleton;}

	private String methodName;
	private String invokerName;

	@ManyToOne(targetEntity = ExecutionParametersHolder.class)
	private ExecutionParametersHolder executionParametersHolder;

	public String getMethodName() {
		return methodName;
	}

	public <T extends FlexiCoreRuleArgument> T setMethodName(String methodName) {
		this.methodName = methodName;
		return (T) this;
	}

	public String getInvokerName() {
		return invokerName;
	}

	public <T extends FlexiCoreRuleArgument> T setInvokerName(String invokerName) {
		this.invokerName = invokerName;
		return (T) this;
	}

	@ManyToOne(targetEntity = ExecutionParametersHolder.class)
	public ExecutionParametersHolder getExecutionParametersHolder() {
		return executionParametersHolder;
	}

	public <T extends FlexiCoreRuleArgument> T setExecutionParametersHolder(ExecutionParametersHolder executionParametersHolder) {
		this.executionParametersHolder = executionParametersHolder;
		return (T) this;
	}
}
