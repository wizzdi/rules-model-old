/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.model.Baseclass;
import com.flexicore.model.KeyWord;
import com.flexicore.model.KeyWordToBaseclass;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class FlexiCoreRule extends Baseclass {
	private static FlexiCoreRule s_Singleton=new FlexiCoreRule();
	public  static FlexiCoreRule s() {return s_Singleton;}


	@OneToMany(targetEntity = RuleToExecutionParameter.class ,mappedBy = "flexiCoreRule")
	@JsonIgnore
	private List<RuleToExecutionParameter> ruleToExecutionParameters=new ArrayList<>();

	@OneToMany(targetEntity = RuleToExecutionParameter.class ,mappedBy = "flexiCoreRule")
	@JsonIgnore
	public List<RuleToExecutionParameter> getRuleToExecutionParameters() {
		return ruleToExecutionParameters;
	}

	public <T extends FlexiCoreRule> T setRuleToExecutionParameters(List<RuleToExecutionParameter> ruleToExecutionParameters) {
		this.ruleToExecutionParameters = ruleToExecutionParameters;
		return (T) this;
	}
}
