package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class JSFunctionParameter extends Baseclass {

    @ManyToOne(targetEntity = JSFunction.class)
    private JSFunction jsFunction;
    private int ordinal;
    private String type;

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

    public String getType() {
        return type;
    }

    public <T extends JSFunctionParameter> T setType(String type) {
        this.type = type;
        return (T) this;
    }
}
