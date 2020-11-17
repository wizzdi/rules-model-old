package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class JSFunctionParameter extends Baseclass {

    @ManyToOne(targetEntity = JSFunction.class)
    private JSFunction jsFunction;
    private int ordinal;
    private String parameterType;

    public JSFunctionParameter() {
    }

    public JSFunctionParameter(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    public JSFunction getJsFunction() {
        return jsFunction;
    }

    public <T extends JSFunctionParameter> T setJsFunction(JSFunction jsFunction) {
        this.jsFunction = jsFunction;
        return (T) this;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public <T extends JSFunctionParameter> T setOrdinal(int ordinal) {
        this.ordinal = ordinal;
        return (T) this;
    }

    public String getParameterType() {
        return parameterType;
    }

    public <T extends JSFunctionParameter> T setParameterType(String parameterType) {
        this.parameterType = parameterType;
        return (T) this;
    }
}
