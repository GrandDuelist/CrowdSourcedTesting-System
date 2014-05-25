package cn.com.crowdsourcedtesting.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * Tester entity. @author MyEclipse Persistence Tools
 */

public class Tester implements java.io.Serializable {

	// Fields

	private Integer testerId;
	private String testerName;
	private String testerEmail;
	private String testerPassword;
	private Boolean testerGender;
	private String testerMobile;
	private Date testerBirthday;
	private String testerPhoto;
	private Double testerCredit;
	private Set taskComments = new HashSet(0);
	private Set bugReports = new HashSet(0);
	private Set joinQuestionnaires = new HashSet(0);
	private Set changeGifts = new HashSet(0);
	private Boolean hasAuthority;

	// Constructors

	public Boolean getHasAuthority() {
		return hasAuthority;
	}

	public void setHasAuthority(Boolean hasAuthority) {
		this.hasAuthority = hasAuthority;
	}

	/** default constructor */
	public Tester() {
	}

	/** minimal constructor */
	public Tester(String testerName, String testerEmail, String testerPassword,
			Double testerCredit) {
		this.testerName = testerName;
		this.testerEmail = testerEmail;
		this.testerPassword = testerPassword;
		this.testerCredit = testerCredit;
	}

	/** full constructor */
	public Tester(String testerName, String testerEmail, String testerPassword,
			Boolean testerGender, String testerMobile, Date testerBirthday,
			String testerPhoto, Double testerCredit, Set taskComments,
			Set bugReports, Set joinQuestionnaires, Set changeGifts) {
		this.testerName = testerName;
		this.testerEmail = testerEmail;
		this.testerPassword = testerPassword;
		this.testerGender = testerGender;
		this.testerMobile = testerMobile;
		this.testerBirthday = testerBirthday;
		this.testerPhoto = testerPhoto;
		this.testerCredit = testerCredit;
		this.taskComments = taskComments;
		this.bugReports = bugReports;
		this.joinQuestionnaires = joinQuestionnaires;
		this.changeGifts = changeGifts;
	}

	// Property accessors

	public Integer getTesterId() {
		return this.testerId;
	}

	public void setTesterId(Integer testerId) {
		this.testerId = testerId;
	}

	public String getTesterName() {
		return this.testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getTesterEmail() {
		return this.testerEmail;
	}

	public void setTesterEmail(String testerEmail) {
		this.testerEmail = testerEmail;
	}

	public String getTesterPassword() {
		return this.testerPassword;
	}

	public void setTesterPassword(String testerPassword) {
		this.testerPassword = testerPassword;
	}

	public Boolean getTesterGender() {
		return this.testerGender;
	}

	public void setTesterGender(Boolean testerGender) {
		this.testerGender = testerGender;
	}

	public String getTesterMobile() {
		return this.testerMobile;
	}

	public void setTesterMobile(String testerMobile) {
		this.testerMobile = testerMobile;
	}

	public Date getTesterBirthday() {
		return this.testerBirthday;
	}

	public void setTesterBirthday(Date testerBirthday) {
		this.testerBirthday = testerBirthday;
	}

	public String getTesterPhoto() {
		return this.testerPhoto;
	}

	public void setTesterPhoto(String testerPhoto) {
		this.testerPhoto = testerPhoto;
	}

	public Double getTesterCredit() {
		return this.testerCredit;
	}

	public void setTesterCredit(Double testerCredit) {
		this.testerCredit = testerCredit;
	}

	public Set getTaskComments() {
		return this.taskComments;
	}

	public void setTaskComments(Set taskComments) {
		this.taskComments = taskComments;
	}

	public Set getBugReports() {
		return this.bugReports;
	}

	public void setBugReports(Set bugReports) {
		this.bugReports = bugReports;
	}

	public Set getJoinQuestionnaires() {
		return this.joinQuestionnaires;
	}

	public void setJoinQuestionnaires(Set joinQuestionnaires) {
		this.joinQuestionnaires = joinQuestionnaires;
	}

	public Set getChangeGifts() {
		return this.changeGifts;
	}

	public void setChangeGifts(Set changeGifts) {
		this.changeGifts = changeGifts;
	}
	
	
	

}