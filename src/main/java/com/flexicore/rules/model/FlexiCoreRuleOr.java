/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class FlexiCoreRuleOr extends FlexiCoreRuleOp {
	private static FlexiCoreRuleOr s_Singleton=new FlexiCoreRuleOr();
	public  static FlexiCoreRuleOr s() {return s_Singleton;}


}
