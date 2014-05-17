package cn.com.crowdsourcedtesting.bean;

import java.util.Date;

/**
 * Recruitment entity. @author MyEclipse Persistence Tools
 */

public class Recruitment implements java.io.Serializable {

	// Fields

	private Integer activityId;
	private String activityName;
	private Date timeStart;
	private Date timeEnd;
	private Boolean online;
	private String content;
	private String brief;
	private String company;
	private String place;
	private Boolean recruitmentType;
	private Publisher publisher;
	private Administrator checkAdministrator;

	// Constructors

	/** default constructor */
	public Recruitment() {
	}

	/** minimal constructor */
	public Recruitment(String activityName, Boolean online,
			Boolean recruitmentType, Publisher publisher) {
		this.activityName = activityName;
		this.online = online;
		this.recruitmentType = recruitmentType;
		this.publisher = publisher;
	}

	/** full constructor */
	public Recruitment(String activityName, Date timeStart, Date timeEnd,
			Boolean online, String content, String brief, String company,
			String place, Boolean recruitmentType, Publisher publisher,
			Administrator checkAdministrator) {
		this.activityName = activityName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.online = online;
		this.content = content;
		this.brief = brief;
		this.company = company;
		this.place = place;
		this.recruitmentType = recruitmentType;
		this.publisher = publisher;
		this.checkAdministrator = checkAdministrator;
	}

	// Property accessors

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Boolean getOnline() {
		return this.online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Boolean getRecruitmentType() {
		return this.recruitmentType;
	}

	public void setRecruitmentType(Boolean recruitmentType) {
		this.recruitmentType = recruitmentType;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Administrator getCheckAdministrator() {
		return checkAdministrator;
	}

	public void setCheckAdministrator(Administrator checkAdministrator) {
		this.checkAdministrator = checkAdministrator;
	}

}