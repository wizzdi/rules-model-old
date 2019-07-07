/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Schema(name = "ScenarioTrigger",description = "A ScenarioTrigger triggers Scenario evaluation when triggered." +
		"Triggers can be created by name using the CRUD API and fired by several entities in the system including " +
		"Schedules, ScenarioActions(!!) and external events ")
@SuppressWarnings("serial")
@Entity
public class ScenarioTrigger extends Baseclass {
	private static ScenarioTrigger s_Singleton=new ScenarioTrigger();
	public  static ScenarioTrigger s() {return s_Singleton;}

	private String eventCanonicalClassName;

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenarioTrigger")
	private List<ScenarioToTrigger> scenarioToTriggers=new ArrayList<>();

	public String getEventCanonicalClassName() {
		return eventCanonicalClassName;
	}

	public <T extends ScenarioTrigger> T setEventCanonicalClassName(String eventCanonicalClassName) {
		this.eventCanonicalClassName = eventCanonicalClassName;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenarioTrigger")
	public List<ScenarioToTrigger> getScenarioToTriggers() {
		return scenarioToTriggers;
	}

	public <T extends ScenarioTrigger> T setScenarioToTriggers(List<ScenarioToTrigger> scenarioToTriggers) {
		this.scenarioToTriggers = scenarioToTriggers;
		return (T) this;
	}
}
