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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ScenarioTrigger extends Baseclass {

	public ScenarioTrigger() {
	}

	public ScenarioTrigger(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}


	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime activeTill;
	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime validFrom;
	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime validTill;

	private ScenarioTriggerType triggerType;

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource evaluatingJSCode;
	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenarioTrigger")
	@JsonIgnore
	private List<ScenarioToTrigger> scenarioToTriggers=new ArrayList<>();

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getEvaluatingJSCode() {
		return evaluatingJSCode;
	}

	public <T extends ScenarioTrigger> T setEvaluatingJSCode(FileResource evaluatingJSCode) {
		this.evaluatingJSCode = evaluatingJSCode;
		return (T) this;
	}

	@ManyToOne(targetEntity = ScenarioTriggerType.class)
	public ScenarioTriggerType getTriggerType() {
		return triggerType;
	}

	public <T extends ScenarioTrigger> T setTriggerType(ScenarioTriggerType triggerType) {
		this.triggerType = triggerType;
		return (T) this;
	}

	public OffsetDateTime getValidFrom() {
		return validFrom;
	}

	public <T extends ScenarioTrigger> T setValidFrom(OffsetDateTime validFrom) {
		this.validFrom = validFrom;
		return (T) this;
	}

	public OffsetDateTime getValidTill() {
		return validTill;
	}

	public <T extends ScenarioTrigger> T setValidTill(OffsetDateTime validTill) {
		this.validTill = validTill;
		return (T) this;
	}

	public OffsetDateTime getActiveTill() {
		return activeTill;
	}

	public <T extends ScenarioTrigger> T setActiveTill(OffsetDateTime activeTill) {
		this.activeTill = activeTill;
		return (T) this;
	}

	@OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "scenarioTrigger")
	@JsonIgnore
	public List<ScenarioToTrigger> getScenarioToTriggers() {
		return scenarioToTriggers;
	}

	public <T extends ScenarioTrigger> T setScenarioToTriggers(List<ScenarioToTrigger> scenarioToTriggers) {
		this.scenarioToTriggers = scenarioToTriggers;
		return (T) this;
	}
}
