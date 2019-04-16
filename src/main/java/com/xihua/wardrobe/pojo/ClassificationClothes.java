package com.xihua.wardrobe.pojo;

import java.io.Serializable;

public class ClassificationClothes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer count;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClassificationClothes() {
		super();
	}

	public ClassificationClothes(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}

	public ClassificationClothes(String name, Integer count, Integer id) {
		super();
		this.name = name;
		this.count = count;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
