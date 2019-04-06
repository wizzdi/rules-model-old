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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class Scenario extends Baseclass {
	private static Scenario s_Singleton=new Scenario();
	public  static Scenario s() {return s_Singleton;}

	@ManyToOne(targetEntity = FlexiCoreRule.class)
	private FlexiCoreRule flexiCoreRule;
	@JsonIgnore
	@OneToMany(targetEntity = ScenarioTrigger.class,mappedBy = "scenario")
	private List<ScenarioToTrigger> scenarioToTriggers=new ArrayList<>();

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class,mappedBy = "scenario")
	private List<ScenarioToAction> scenarioToActions=new ArrayList<>();


	public FlexiCoreRule getFlexiCoreRule() {
		return flexiCoreRule;
	}

	public <T extends Scenario> T setFlexiCoreRule(FlexiCoreRule flexiCoreRule) {
		this.flexiCoreRule = flexiCoreRule;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioTrigger.class,mappedBy = "scenario")
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
}
