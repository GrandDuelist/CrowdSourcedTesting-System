package cn.com.crowdsourcedtesting.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	private Integer administratorId;
	private String administratorName;
	private String administratorEmail;
	private String administratorPassword;
	private Boolean administratorAuthority;
	private String administratorOccupation;
	private Set recruitments = new HashSet(0);
	private Set publishers = new HashSet(0);
	private Set questionnaires = new HashSet(0);

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(String administratorName, String administratorEmail,
			String administratorPassword, Boolean administratorAuthority,
			String administratorOccupation) {
		this.administratorName = administratorName;
		this.administratorEmail = administratorEmail;
		this.administratorPassword = administratorPassword;
		this.administratorAuthority = administratorAuthority;
		this.administratorOccupation = administratorOccupation;
	}

	/** full constructor */
	public Administrator(String administratorName, String administratorEmail,
			String administratorPassword, Boolean administratorAuthority,
			String administratorOccupation, Set recruitments, Set publishers,
			Set questionnaires) {
		this.administratorName = administratorName;
		this.administratorEmail = administratorEmail;
		this.administratorPassword = administratorPassword;
		this.administratorAuthority = administratorAuthority;
		this.administratorOccupation = administratorOccupation;
		this.recruitments = recruitments;
		this.publishers = publishers;
		this.questionnaires = questionnaires;
	}

	// Property accessors

	public Integer getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public String getAdministratorName() {
		return this.administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAdministratorEmail() {
		return this.administratorEmail;
	}

	public void setAdministratorEmail(String administratorEmail) {
		this.administratorEmail = administratorEmail;
	}

	public String getAdministratorPassword() {
		return this.administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

	public Boolean getAdministratorAuthority() {
		return this.administratorAuthority;
	}

	public void setAdministratorAuthority(Boolean administratorAuthority) {
		this.administratorAuthority = administratorAuthority;
	}

	public String getAdministratorOccupation() {
		return this.administratorOccupation;
	}

	public void setAdministratorOccupation(String administratorOccupation) {
		this.administratorOccupation = administratorOccupation;
	}

	public Set getRecruitments() {
		return this.recruitments;
	}

	public void setRecruitments(Set recruitments) {
		this.recruitments = recruitments;
	}

	public Set getPublishers() {
		return this.publishers;
	}

	public void setPublishers(Set publishers) {
		this.publishers = publishers;
	}

	public Set getQuestionnaires() {
		return this.questionnaires;
	}

	public void setQuestionnaires(Set questionnaires) {
		this.questionnaires = questionnaires;
	}

}