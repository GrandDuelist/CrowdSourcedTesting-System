package cn.com.crowdsourcedtesting.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer productId;
	private String productName;
	private Subcategory subcategory;
	private Date releaseTime;
	private String version;
	private Boolean status;
	private String description;
	private String loginXmlFile;
	private String icon;
	private String apkAddress;
	private String webLink;
	private String desktopAddress;
//	private Set testTasks = new HashSet(0);
	// Constructors

	/** default constructor */
	public Product() {
	}


	/** minimal constructor */
	public Product(Subcategory subcategory, String productName,
			Date releaseTime, String version, Boolean status,
			String description, String icon) {
		this.subcategory = subcategory;
		this.productName = productName;
		this.releaseTime = releaseTime;
		this.version = version;
		this.status = status;
		this.description = description;
		this.icon = icon;
	}

	/** full constructor */
//	public Product(Subcategory subcategory, String productName,
//			Date releaseTime, String version, Boolean status,
//			String description, String loginXmlFile, String icon,
//			String apkAddress, String webLink, String desktopAddress,
//			Set testTasks) {
//		this.subcategory = subcategory;
//		this.productName = productName;
//		this.releaseTime = releaseTime;
//		this.version = version;
//		this.status = status;
//		this.description = description;
//		this.loginXmlFile = loginXmlFile;
//		this.icon = icon;
//		this.apkAddress = apkAddress;
//		this.webLink = webLink;
//		this.desktopAddress = desktopAddress;
//		this.testTasks = testTasks;
//	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Date getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoginXmlFile() {
		return this.loginXmlFile;
	}

	public void setLoginXmlFile(String loginXmlFile) {
		this.loginXmlFile = loginXmlFile;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getApkAddress() {
		return this.apkAddress;
	}

	public void setApkAddress(String apkAddress) {
		this.apkAddress = apkAddress;
	}

	public String getWebLink() {
		return this.webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getDesktopAddress() {
		return this.desktopAddress;
	}

	public void setDesktopAddress(String desktopAddress) {
		this.desktopAddress = desktopAddress;
	}

//	public Set getTestTasks() {
//		return this.testTasks;
//	}
//
//	public void setTestTasks(Set testTasks) {
//		this.testTasks = testTasks;
//	}

}