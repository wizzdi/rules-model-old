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

@Entity
public class TriggerManager extends Baseclass {



    @JsonIgnore
    @OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "triggerManager")
    private List<ScenarioToTrigger> scenarioToTriggers=new ArrayList<>();

    @ManyToOne(targetEntity = FileResource.class)
    private FileResource triggerManagerScript;

    public TriggerManager() {
    }

    public TriggerManager(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @ManyToOne(targetEntity = FileResource.class)
    public FileResource getTriggerManagerScript() {
        return triggerManagerScript;
    }

    public <T extends TriggerManager> T setTriggerManagerScript(FileResource triggerManagerScript) {
        this.triggerManagerScript = triggerManagerScript;
        return (T) this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = ScenarioToTrigger.class,mappedBy = "triggerManager")
    public List<ScenarioToTrigger> getScenarioToTriggers() {
        return scenarioToTriggers;
    }

    public <T extends TriggerManager> T setScenarioToTriggers(List<ScenarioToTrigger> scenarioToTriggers) {
        this.scenarioToTriggers = scenarioToTriggers;
        return (T) this;
    }
}
