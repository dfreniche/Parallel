package org.cccb.parallel.model;

import java.util.List;

public class POI {
	private long id;
	private String name;
	private String adrress;
	private String description;
	private double latitude;
	private double longitude;
	private List<String> tags;
	private List<String> photoURLs;
	private List<String> videoURLs;
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
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getIntLatitude() {
		return (int)(this.getLatitude()*1E6);
	}
	public int getIntLongitude() {
		return (int)(this.getLongitude()*1E6);
	}
	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<String> getPhotoURLs() {
		return photoURLs;
	}
	public void setPhotoURLs(List<String> photoURLs) {
		this.photoURLs = photoURLs;
	}
	public List<String> getVideoURLs() {
		return videoURLs;
	}
	public void setVideoURLs(List<String> videoURLs) {
		this.videoURLs = videoURLs;
	}
	
	
	
}
