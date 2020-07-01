/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.dynamic.DynamicExecution;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class ScenarioAction extends Baseclass {

	@ManyToOne(targetEntity = DynamicExecution.class)
	private DynamicExecution dynamicExecution;

	public ScenarioAction() {
	}

	public ScenarioAction(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class, mappedBy = "scenarioAction")
	private List<ScenarioToAction> scenarioToActions = new ArrayList<>();

	@Schema(name = "Scenarios", description = "A list of ScenarioToAction instances of all Scenarios connected to this ScenarioAction")
	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class, mappedBy = "scenarioAction")
	public List<ScenarioToAction> getScenarioToActions() {
		return scenarioToActions;
	}

	public <T extends ScenarioAction> T setScenarioToActions(
			List<ScenarioToAction> scenarioToActions) {
		this.scenarioToActions = scenarioToActions;
		return (T) this;
	}

	@ManyToOne(targetEntity = DynamicExecution.class)
	public DynamicExecution getDynamicExecution() {
		return dynamicExecution;
	}

	public <T extends ScenarioAction> T setDynamicExecution(
			DynamicExecution dynamicExecution) {
		this.dynamicExecution = dynamicExecution;
		return (T) this;
	}
}
