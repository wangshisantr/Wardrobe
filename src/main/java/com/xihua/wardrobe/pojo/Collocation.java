package com.xihua.wardrobe.pojo;

import java.util.Date;

public class Collocation {
	private Long id;

	private String title;

	private String image;

	private Date date;

	private Date creatDate;

	private String dressDateString;

	private String creatDateString;

	private String openId;

	private Long userId;

	public String getDressDateString() {
		return dressDateString;
	}

	public void setDressDateString(String dressDateString) {
		this.dressDateString = dressDateString;
	}

	public String getCreatDateString() {
		return creatDateString;
	}

	public void setCreatDateString(String creatDateString) {
		this.creatDateString = creatDateString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}