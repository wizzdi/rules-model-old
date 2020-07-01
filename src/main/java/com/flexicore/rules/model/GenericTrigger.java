/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class GenericTrigger extends ScenarioTrigger {
	private static GenericTrigger s_Singleton = new GenericTrigger();
	public static GenericTrigger s() {
		return s_Singleton;
	}

	public GenericTrigger() {
	}

	public GenericTrigger(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

}
