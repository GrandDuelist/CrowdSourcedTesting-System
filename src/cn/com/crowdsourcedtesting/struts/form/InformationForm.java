/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package cn.com.crowdsourcedtesting.struts.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 05-24-2014
 * 
 * XDoclet definition:
 * @struts.form name="informationForm"
 */
public class InformationForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** id property */
	private int id;

	/** page property */
	private int page;

	/** subType property */
	private String subType;
	private String publisherType;
	
	private Double credit;
	private String username;
	private String license;
	private Boolean status;
    private String company;
    private String Birthday;
	/*
	 * Generated Methods
	 */

	public Double getCredit() {
		return credit;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPublisherType() {
		return publisherType;
	}

	public void setPublisherType(String publisherType) {
		this.publisherType = publisherType;
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the id.
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/** 
	 * Set the id.
	 * @param id The id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
	 * Returns the page.
	 * @return int
	 */
	public int getPage() {
		return page;
	}

	/** 
	 * Set the page.
	 * @param page The page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/** 
	 * Returns the subType.
	 * @return String
	 */
	public String getSubType() {
		return subType;
	}

	/** 
	 * Set the subType.
	 * @param subType The subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}
}