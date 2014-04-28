package cn.com.crowdsourcedtesting.bean;

import java.util.Date;

/**
 * Recruiment entity. @author MyEclipse Persistence Tools
 */

public class Recruiment implements java.io.Serializable {

	// Fields

	private Integer activityId;
	private Administrator administrator;
	private Publisher publisher;
	private String activityName;
	private Date timeStart;
	private Date timeEnd;
	private Boolean online;
	private String content;
	private String brief;
	private String company;
	private String place;
	private Boolean recruimentType;

	// Constructors

	/** default constructor */
	public Recruiment() {
	}

	/** minimal constructor */
	public Recruiment(Publisher publisher, String activityName, Boolean online,
			Boolean recruimentType) {
		this.publisher = publisher;
		this.activityName = activityName;
		this.online = online;
		this.recruimentType = recruimentType;
	}

	/** full constructor */
	public Recruiment(Administrator administrator, Publisher publisher,
			String activityName, Date timeStart, Date timeEnd, Boolean online,
			String content, String brief, String company, String place,
			Boolean recruimentType) {
		this.administrator = administrator;
		this.publisher = publisher;
		this.activityName = activityName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.online = online;
		this.content = content;
		this.brief = brief;
		this.company = company;
		this.place = place;
		this.recruimentType = recruimentType;
	}

	// Property accessors

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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

	public Boolean getRecruimentType() {
		return this.recruimentType;
	}

	public void setRecruimentType(Boolean recruimentType) {
		this.recruimentType = recruimentType;
	}

}