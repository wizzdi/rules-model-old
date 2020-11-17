package com.flexicore.rules.request;

import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.request.BaseclassNoSQLFilter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class ScenarioSavableEventFilter extends BaseclassNoSQLFilter {


    @OneToMany(targetEntity = ScenarioEventIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ListFieldInfo(displayName = "scenario event ids",description = "scenario event ids",listType = ScenarioEventIdFiltering.class)
    private Set<ScenarioEventIdFiltering> scenarioEventIds = new HashSet<>();

    @OneToMany(targetEntity = ScenarioEventIdFiltering.class, mappedBy = "filteringInformationHolder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Set<ScenarioEventIdFiltering> getScenarioEventIds() {
        return scenarioEventIds;
    }

    public <T extends ScenarioSavableEventFilter> T setScenarioEventIds(Set<ScenarioEventIdFiltering> scenarioEventIds) {
        this.scenarioEventIds = scenarioEventIds;
        return (T) this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if(scenarioEventIds !=null){
            for (ScenarioEventIdFiltering externalEquipmentId : scenarioEventIds) {
                externalEquipmentId.prepareForSave(this);
            }
        }
    }
}
