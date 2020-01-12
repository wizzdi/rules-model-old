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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Schema(name="Scenario", description = "Scenario is the parent Class for rules evaluation" +
		"It is connected to triggers (multiple of) and to actions, when a scenario is evaluated to true, actions are fired."+
		" A Scenario can be created with name and description and later updated to include a RuleID, The Rule is either a single rule evaluated by a Javascript expression or " +
		"one of NOT,AND,OR that can be the root for a more complex expression")
@Entity
public class Scenario extends Baseclass {
	private static Scenario s_Singleton=new Scenario();
	public  static Scenario s() {return s_Singleton;}
	@Lob
	private String scenarioHint;

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource actionManagerScript;
	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule flexiCoreRule;
	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenario")
	private List<ScenarioToTrigger> scenarioToTriggers=new ArrayList<>();

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class,mappedBy = "scenario")
	private List<ScenarioToAction> scenarioToActions=new ArrayList<>();

	public Scenario() {
	}

	public Scenario(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@Schema(name="FlexiCoreRule ",description = "A single FlexiCoreRule or RuleOp (which extends FlexiCoreRule anyway) that is evaluated ")

	public FlexiCoreRule getFlexiCoreRule() {
		return flexiCoreRule;
	}

	public <T extends Scenario> T setFlexiCoreRule(FlexiCoreRule flexiCoreRule) {
		this.flexiCoreRule = flexiCoreRule;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenario")
	public List<ScenarioToTrigger> getScenarioToTriggers() {
		return scenarioToTriggers;
	}

	public <T extends Scenario> T setScenarioToTriggers(List<ScenarioToTrigger> scenarioToTriggers) {
		this.scenarioToTriggers = scenarioToTriggers;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class,mappedBy = "scenario")
	public List<ScenarioToAction> getScenarioToActions() {
		return scenarioToActions;
	}

	public <T extends Scenario> T setScenarioToActions(List<ScenarioToAction> scenarioToActions) {
		this.scenarioToActions = scenarioToActions;
		return (T) this;
	}

	@Lob
	public String getScenarioHint() {
		return scenarioHint;
	}

	public <T extends Scenario> T setScenarioHint(String scenarioHint) {
		this.scenarioHint = scenarioHint;
		return (T) this;
	}

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getActionManagerScript() {
		return actionManagerScript;
	}

	public <T extends Scenario> T setActionManagerScript(FileResource actionManagerScript) {
		this.actionManagerScript = actionManagerScript;
		return (T) this;
	}
}
