package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ActionReplacement extends Baseclass {

    private String executionTargetPath;
    private String eventSourcePath;
    @ManyToOne(targetEntity = ScenarioTrigger.class)
    private ScenarioTrigger scenarioTrigger;
    @ManyToOne(targetEntity = ScenarioToAction.class)
    private ScenarioToAction scenarioToAction;

    public String getExecutionTargetPath() {
        return executionTargetPath;
    }

    public <T extends ActionReplacement> T setExecutionTargetPath(String executionTargetPath) {
        this.executionTargetPath = executionTargetPath;
        return (T) this;
    }

    public String getEventSourcePath() {
        return eventSourcePath;
    }

    public <T extends ActionReplacement> T setEventSourcePath(String eventSourcePath) {
        this.eventSourcePath = eventSourcePath;
        return (T) this;
    }

    @ManyToOne(targetEntity = ScenarioTrigger.class)
    public ScenarioTrigger getScenarioTrigger() {
        return scenarioTrigger;
    }

    public <T extends ActionReplacement> T setScenarioTrigger(ScenarioTrigger scenarioTrigger) {
        this.scenarioTrigger = scenarioTrigger;
        return (T) this;
    }

    @ManyToOne(targetEntity = ScenarioToAction.class)
    public ScenarioToAction getScenarioToAction() {
        return scenarioToAction;
    }

    public <T extends ActionReplacement> T setScenarioToAction(ScenarioToAction scenarioToAction) {
        this.scenarioToAction = scenarioToAction;
        return (T) this;
    }
}