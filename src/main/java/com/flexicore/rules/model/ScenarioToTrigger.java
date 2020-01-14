/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Schema(name = "ScenarioToTrigger",description = "Links a Scenario to a ScenarioTrigger, these are connected M2M")
@SuppressWarnings("serial")
@Entity
public class ScenarioToTrigger extends Baseclass {
	private static ScenarioToTrigger s_Singleton=new ScenarioToTrigger();
	public  static ScenarioToTrigger s() {return s_Singleton;}


	@ManyToOne(targetEntity = Scenario.class)
	private Scenario scenario;

	@ManyToOne(targetEntity = TriggerManager.class)
	private TriggerManager triggerManager;





	private boolean enabled;

	@ManyToOne(targetEntity = ScenarioTrigger.class)
	private ScenarioTrigger scenarioTrigger;

	public ScenarioToTrigger() {
	}

	public ScenarioToTrigger(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@ManyToOne(targetEntity = Scenario.class)
	@Schema(name = "Scenario",description = "The connected Scenario by this link")
	public Scenario getScenario() {
		return scenario;
	}

	public <T extends ScenarioToTrigger> T setScenario(Scenario scenario) {
		this.scenario = scenario;
		return (T) this;
	}

	@Schema(name = "ScenarioTrigger",description = "The connected ScenarioTrigger by this link")

	@ManyToOne(targetEntity = ScenarioTrigger.class)
	public ScenarioTrigger getScenarioTrigger() {
		return scenarioTrigger;
	}

	public <T extends ScenarioToTrigger> T setScenarioTrigger(ScenarioTrigger scenarioTrigger) {
		this.scenarioTrigger = scenarioTrigger;
		return (T) this;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public <T extends ScenarioToTrigger> T setEnabled(boolean enabled) {
		this.enabled = enabled;
		return (T) this;
	}

	@ManyToOne(targetEntity = TriggerManager.class)
	public TriggerManager getTriggerManager() {
		return triggerManager;
	}

	public <T extends ScenarioToTrigger> T setTriggerManager(TriggerManager triggerManager) {
		this.triggerManager = triggerManager;
		return (T) this;
	}
}
