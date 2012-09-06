package org.cccb.parallel.model;

import java.util.List;

public class Route {
	private long id;
	private String name;
	private String description;
	private List<POI>routePOIs;
	private long timeNeeded;
	private List<String>tags;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<POI> getRoutePOIs() {
		return routePOIs;
	}
	public void setRoutePOIs(List<POI> routePOIs) {
		this.routePOIs = routePOIs;
	}
	public long getTimeNeeded() {
		return timeNeeded;
	}
	public void setTimeNeeded(long timeNeeded) {
		this.timeNeeded = timeNeeded;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
