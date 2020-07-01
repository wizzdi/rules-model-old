/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ScenarioTriggerType extends Baseclass {

	private String eventCanonicalName;

	public ScenarioTriggerType() {
	}

	public ScenarioTriggerType(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public String getEventCanonicalName() {
		return eventCanonicalName;
	}

	public <T extends ScenarioTriggerType> T setEventCanonicalName(String eventCanonicalName) {
		this.eventCanonicalName = eventCanonicalName;
		return (T) this;
	}
}
