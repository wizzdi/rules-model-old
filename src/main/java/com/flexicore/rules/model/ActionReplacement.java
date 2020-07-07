package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

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
    private boolean fetchSource;

    public ActionReplacement() {
    }

    public ActionReplacement(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

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

    public boolean isFetchSource() {
        return fetchSource;
    }

    public <T extends ActionReplacement> T setFetchSource(boolean fetchSource) {
        this.fetchSource = fetchSource;
        return (T) this;
    }
}
