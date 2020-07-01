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

@Entity
public class Scenario extends Baseclass {

	@Lob
	private String scenarioHint;

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class, mappedBy = "scenario")
	private List<ScenarioToTrigger> scenarioToTriggers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class, mappedBy = "scenario")
	private List<ScenarioToAction> scenarioToActions = new ArrayList<>();
	@ManyToOne(targetEntity = FileResource.class)
	private FileResource logFileResource;
	@ManyToOne(targetEntity = FileResource.class)
	private FileResource evaluatingJSCode;

	public Scenario() {
	}

	public Scenario(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}


	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToTrigger.class, mappedBy = "scenario")
	public List<ScenarioToTrigger> getScenarioToTriggers() {
		return scenarioToTriggers;
	}

	public <T extends Scenario> T setScenarioToTriggers(
			List<ScenarioToTrigger> scenarioToTriggers) {
		this.scenarioToTriggers = scenarioToTriggers;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = ScenarioToAction.class, mappedBy = "scenario")
	public List<ScenarioToAction> getScenarioToActions() {
		return scenarioToActions;
	}

	public <T extends Scenario> T setScenarioToActions(
			List<ScenarioToAction> scenarioToActions) {
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
	public FileResource getLogFileResource() {
		return logFileResource;
	}

	public <T extends Scenario> T setLogFileResource(
			FileResource logFileResource) {
		this.logFileResource = logFileResource;
		return (T) this;
	}

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getEvaluatingJSCode() {
		return evaluatingJSCode;
	}

	public <T extends Scenario> T setEvaluatingJSCode(FileResource evaluatingJSCode) {
		this.evaluatingJSCode = evaluatingJSCode;
		return (T) this;
	}
}
