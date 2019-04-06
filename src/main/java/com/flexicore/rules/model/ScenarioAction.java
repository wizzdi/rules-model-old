/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.dynamic.DynamicExecution;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class ScenarioAction extends DynamicExecution {
	private static ScenarioAction s_Singleton=new ScenarioAction();
	public  static ScenarioAction s() {return s_Singleton;}


	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class,mappedBy = "scenarioAction")
	private List<ScenarioToAction> scenarioToActions=new ArrayList<>();


	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class,mappedBy = "scenarioAction")
	public List<ScenarioToAction> getScenarioToActions() {
		return scenarioToActions;
	}

	public <T extends ScenarioAction> T setScenarioToActions(List<ScenarioToAction> scenarioToActions) {
		this.scenarioToActions = scenarioToActions;
		return (T) this;
	}
}
