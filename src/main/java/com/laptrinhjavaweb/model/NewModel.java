package com.laptrinhjavaweb.model;

public class NewModel extends AbstractModel<NewModel> {
	private String title;
	private String thambnail;
	private String shortDecription;
	private String content;
	private long categoryId;	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThambnail() {
		return thambnail;
	}
	public void setThumbnail(String thambnail) {
		this.thambnail = thambnail;
	}
	public String getShortDecription() {
		return shortDecription;
	}
	public void setShortDecription(String shortDecription) {
		this.shortDecription = shortDecription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
