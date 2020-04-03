package com.flexicore.rules.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GenericTriggerIdRef {
    @Id
    private String filterId;
    @FieldInfo(displayName = "genericTriggerRequestId", description = "genericTriggerRequest id", mandatory = true)
    private String id;
    @ManyToOne(targetEntity = GenericTriggerRequest.class)
    @JsonIgnore
    private GenericTriggerRequest genericTriggerRequest;

    public GenericTriggerIdRef() {
    }

    public String getId() {
        return this.id;
    }

    public GenericTriggerIdRef setId(String id) {
        this.id = id;
        return this;
    }

    public GenericTriggerIdRef(String id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return this.filterId;
    }

    public GenericTriggerIdRef setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }


    public void prepareForSave(GenericTriggerRequest genericTriggerRequest) {
        this.filterId = Baseclass.getBase64ID();
        this.genericTriggerRequest = genericTriggerRequest;
    }

    @ManyToOne(targetEntity = GenericTriggerRequest.class)
    @JsonIgnore
    public GenericTriggerRequest getGenericTriggerRequest() {
        return genericTriggerRequest;
    }

    public <T extends GenericTriggerIdRef> T setGenericTriggerRequest(GenericTriggerRequest genericTriggerRequest) {
        this.genericTriggerRequest = genericTriggerRequest;
        return (T) this;
    }
}
