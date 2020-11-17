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

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")

@Entity
public class JSFunction extends Baseclass {

	@ManyToOne(targetEntity = FileResource.class)
	private FileResource evaluatingJSCode;
	private String methodName;
	private String returnType;
	@JsonIgnore
	@OneToMany(targetEntity = JSFunctionParameter.class,mappedBy = "jsFunction")
	private List<JSFunctionParameter> parameters=new ArrayList<>();

	public JSFunction() {
	}

	public JSFunction(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}


	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getEvaluatingJSCode() {
		return evaluatingJSCode;
	}

	public <T extends JSFunction> T setEvaluatingJSCode(FileResource evaluatingJSCode) {
		this.evaluatingJSCode = evaluatingJSCode;
		return (T) this;
	}

	public String getMethodName() {
		return methodName;
	}

	public <T extends JSFunction> T setMethodName(String methodName) {
		this.methodName = methodName;
		return (T) this;
	}

	public String getReturnType() {
		return returnType;
	}

	public <T extends JSFunction> T setReturnType(String returnType) {
		this.returnType = returnType;
		return (T) this;
	}

	@JsonIgnore
	@OneToMany(targetEntity = JSFunctionParameter.class,mappedBy = "jsFunction")
	public List<JSFunctionParameter> getParameters() {
		return parameters;
	}

	public <T extends JSFunction> T setParameters(List<JSFunctionParameter> parameters) {
		this.parameters = parameters;
		return (T) this;
	}
}
