package com.bean;

//∑Áœ’bean
public class Risk {
	private int id;
	private String name;
	private int possibility;
	private int influenceDegree;
	private int triggerOrThreshold;
	private int committer_id;
	private int tracker_id;
	private int state;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPossibility() {
		return possibility;
	}
	public void setPossibility(int possibility) {
		this.possibility = possibility;
	}
	public int getInfluenceDegree() {
		return influenceDegree;
	}
	public void setInfluenceDegree(int influenceDegree) {
		this.influenceDegree = influenceDegree;
	}
	public int getTriggerOrThreshold() {
		return triggerOrThreshold;
	}
	public void setTriggerOrThreshold(int triggerOrThreshold) {
		this.triggerOrThreshold = triggerOrThreshold;
	}
	public int getCommitter_id() {
		return committer_id;
	}
	public void setCommitter_id(int committer_id) {
		this.committer_id = committer_id;
	}
	public int getTracker_id() {
		return tracker_id;
	}
	public void setTracker_id(int tracker_id) {
		this.tracker_id = tracker_id;
	}
	
	

}
