/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.rules.model;

import com.flexicore.model.Baseclass;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Schema(name = "ScenarioToAction link", description = "Many to Many links between Scenarios and ScenarioActions, note that the same action can be reused in many Scenarios")
@Entity
public class ScenarioToAction extends Baseclass {
    private static ScenarioToAction s_Singleton = new ScenarioToAction();

    public static ScenarioToAction s() {
        return s_Singleton;
    }


    @ManyToOne(targetEntity = Scenario.class)
    private Scenario scenario;
    private boolean enabled;

    @ManyToOne(targetEntity = ScenarioAction.class)
    private ScenarioAction scenarioAction;

    @ManyToOne(targetEntity = Scenario.class)
    @Schema(name = "Connected Scenario", description = "The referred to Scenario")
    public Scenario getScenario() {
        return scenario;
    }

    public <T extends ScenarioToAction> T setScenario(Scenario scenario) {
        this.scenario = scenario;
        return (T) this;
    }

    @Schema(name = "Connected ScenarioAction", description = "A single ScenarioAction referred to by this ling")
    @ManyToOne(targetEntity = ScenarioAction.class)
    public ScenarioAction getScenarioAction() {
        return scenarioAction;
    }

    public <T extends ScenarioToAction> T setScenarioAction(ScenarioAction scenarioAction) {
        this.scenarioAction = scenarioAction;
        return (T) this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public <T extends ScenarioToAction> T setEnabled(boolean enabled) {
        this.enabled = enabled;
        return (T) this;
    }
}
