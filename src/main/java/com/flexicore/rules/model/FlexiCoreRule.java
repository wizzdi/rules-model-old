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
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Schema(description = "Describes a single rule, a rule is either NOT,AND,OR or it is a Javascript file.")
@Entity
public class FlexiCoreRule extends Baseclass {
	private static FlexiCoreRule s_Singleton=new FlexiCoreRule();
	public  static FlexiCoreRule s() {return s_Singleton;}

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource evaluationScript;

	@Schema(description = "Arguments to the Java script rules, see RuleToArgument")
	@OneToMany(targetEntity = RuleToArgument.class ,mappedBy = "flexiCoreRule")
	@JsonIgnore
	private List<RuleToArgument> ruleToExecutionParameters=new ArrayList<>();

	public FlexiCoreRule() {
	}

	public FlexiCoreRule(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@Schema(description = "Arguments to the Java script rules, see RuleToArgument")
	@OneToMany(targetEntity = RuleToArgument.class ,mappedBy = "flexiCoreRule")
	@JsonIgnore
	public List<RuleToArgument> getRuleToExecutionParameters() {
		return ruleToExecutionParameters;
	}

	public <T extends FlexiCoreRule> T setRuleToExecutionParameters(List<RuleToArgument> ruleToExecutionParameters) {
		this.ruleToExecutionParameters = ruleToExecutionParameters;
		return (T) this;
	}
	@Schema(description = "A file resource pointing at a Legal JavaScript file.")
	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getEvaluationScript() {
		return evaluationScript;
	}

	public <T extends FlexiCoreRule> T setEvaluationScript(FileResource evaluationScript) {
		this.evaluationScript = evaluationScript;
		return (T) this;
	}
}
