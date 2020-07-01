/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ScenarioToDataSource extends Baseclass {
	@ManyToOne(targetEntity = Scenario.class)
	private Scenario scenario;
	private boolean enabled;

	@ManyToOne(targetEntity = DataSource.class)
	private DataSource dataSource;

	public ScenarioToDataSource() {
	}

	public ScenarioToDataSource(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@ManyToOne(targetEntity = Scenario.class)
	@Schema(name = "Connected Scenario", description = "The referred to Scenario")
	public Scenario getScenario() {
		return scenario;
	}

	public <T extends ScenarioToDataSource> T setScenario(Scenario scenario) {
		this.scenario = scenario;
		return (T) this;
	}

	@Schema(name = "Connected DataSource", description = "A single DataSource referred to by this ling")
	@ManyToOne(targetEntity = DataSource.class)
	public DataSource getDataSource() {
		return dataSource;
	}

	public <T extends ScenarioToDataSource> T setDataSource(
			DataSource dataSource) {
		this.dataSource = dataSource;
		return (T) this;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public <T extends ScenarioToDataSource> T setEnabled(boolean enabled) {
		this.enabled = enabled;
		return (T) this;
	}
}
