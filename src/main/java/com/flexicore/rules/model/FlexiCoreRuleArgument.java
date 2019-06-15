/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.dynamic.DynamicExecution;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
@Schema(description = "An Argument to a Script based Rule, see DynamicExecution it extends")
@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleArgument extends DynamicExecution {
	private static FlexiCoreRuleArgument s_Singleton=new FlexiCoreRuleArgument();
	public  static FlexiCoreRuleArgument s() {return s_Singleton;}




}
