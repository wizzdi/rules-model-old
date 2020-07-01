package com.flexicore.rules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GenericTriggerRequest extends ExecutionParametersHolder {
	@IdRefFieldInfo(refType = Baseclass.class)
	@OneToMany(targetEntity = GenericTriggerIdRef.class, mappedBy = "genericTriggerRequest", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE})
	private Set<GenericTriggerIdRef> baseclassIds = new HashSet<>();
	@JsonIgnore
	@Transient
	private List<Baseclass> baseclasses;
	@FieldInfo
	private String userData;

	@OneToMany(targetEntity = GenericTriggerIdRef.class, mappedBy = "genericTriggerRequest", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE})
	public Set<GenericTriggerIdRef> getBaseclassIds() {
		return baseclassIds;
	}

	public <T extends GenericTriggerRequest> T setBaseclassIds(
			Set<GenericTriggerIdRef> baseclassIds) {
		this.baseclassIds = baseclassIds;
		return (T) this;
	}

	public String getUserData() {
		return userData;
	}

	public <T extends GenericTriggerRequest> T setUserData(String userData) {
		this.userData = userData;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<Baseclass> getBaseclasses() {
		return baseclasses;
	}

	public <T extends GenericTriggerRequest> T setBaseclasses(
			List<Baseclass> baseclasses) {
		this.baseclasses = baseclasses;
		return (T) this;
	}

	@Override
	public void prepareForSave() {
		super.prepareForSave();
		for (GenericTriggerIdRef baseclassId : baseclassIds) {
			baseclassId.prepareForSave(this);
		}
	}
}
