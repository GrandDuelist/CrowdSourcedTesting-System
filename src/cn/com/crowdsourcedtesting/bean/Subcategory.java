package cn.com.crowdsourcedtesting.bean;

/**
 * Subcategory entity. @author MyEclipse Persistence Tools
 */

public class Subcategory implements java.io.Serializable {

	// Fields

	private Integer subcategoryId;
	private Category category;
	private String subcategoryName;
//	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subcategory() {
	}

	/** minimal constructor */
	public Subcategory(Category category, String subcategoryName) {
		this.category = category;
		this.subcategoryName = subcategoryName;
	}

	/** full constructor */
//	public Subcategory(Category category, String subcategoryName, Set products) {
//		this.category = category;
//		this.subcategoryName = subcategoryName;
//		this.products = products;
//	}

	// Property accessors

	public Integer getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSubcategoryName() {
		return this.subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

//	public Set getProducts() {
//		return this.products;
//	}
//
//	public void setProducts(Set products) {
//		this.products = products;
//	}

}