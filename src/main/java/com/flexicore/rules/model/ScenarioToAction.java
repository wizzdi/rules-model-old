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
public class ScenarioToAction extends Baseclass {
	private static ScenarioToAction s_Singleton=new ScenarioToAction();
	public  static ScenarioToAction s() {return s_Singleton;}


	@ManyToOne(targetEntity = Scenario.class)
	private Scenario scenario;

	@ManyToOne(targetEntity = ScenarioAction.class)
	private ScenarioAction scenarioAction;

	@ManyToOne(targetEntity = Scenario.class)

	public Scenario getScenario() {
		return scenario;
	}

	public <T extends ScenarioToAction> T setScenario(Scenario scenario) {
		this.scenario = scenario;
		return (T) this;
	}

	@ManyToOne(targetEntity = ScenarioAction.class)
	public ScenarioAction getScenarioAction() {
		return scenarioAction;
	}

	public <T extends ScenarioToAction> T setScenarioAction(ScenarioAction scenarioAction) {
		this.scenarioAction = scenarioAction;
		return (T) this;
	}
}
