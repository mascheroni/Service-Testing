package com.almundo.automation.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Choice {
	@SerializedName("id")
	private String id;

	private List<Leg> leg;

	public List<Leg> getLeg() {
		return leg;
	}

	public void setLeg(List<Leg> leg) {
		this.leg = leg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
