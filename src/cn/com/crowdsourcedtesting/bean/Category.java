package cn.com.crowdsourcedtesting.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String categoryName;
	private Boolean plateformType;
	private Set subcategories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String categoryName, Boolean plateformType) {
		this.categoryName = categoryName;
		this.plateformType = plateformType;
	}

	/** full constructor */
//	public Category(String categoryName, Boolean plateformType,
//			Set subcategories) {
//		this.categoryName = categoryName;
//		this.plateformType = plateformType;
//		this.subcategories = subcategories;
//	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getPlateformType() {
		return this.plateformType;
	}

	public void setPlateformType(Boolean plateformType) {
		this.plateformType = plateformType;
	}

	public Set getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(Set subcategories) {
		this.subcategories = subcategories;
	}

}