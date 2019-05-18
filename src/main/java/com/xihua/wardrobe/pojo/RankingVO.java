package com.xihua.wardrobe.pojo;

import java.util.Date;

public class RankingVO {
	
    private Long id;

    private String title;

    private String image;

    private String avatarUrl;

    private Date creatDate;

    private String openId;

    private String userName;

    private Long likeCount;

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
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAvartarUrl() {
		return avatarUrl;
	}

	public void setAvartarUrl(String avartarUrl) {
		this.avatarUrl = avartarUrl;
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
		this.openId = openId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
    
    
}
