package com.flexicore.rules.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ScenarioCreateEvent extends ExecutionParametersHolder {


    @Transient
    private Map<String, Object> more = new HashMap<>();
    @FieldInfo
    private String name;

    public String getName() {
        return name;
    }

    public <T extends ScenarioCreateEvent> T setName(String name) {
        this.name = name;
        return (T) this;
    }

    @JsonAnyGetter
    public Map<String, Object> get() {
        return more;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        more.put(key, value);
    }
}
