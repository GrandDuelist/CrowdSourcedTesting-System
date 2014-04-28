package cn.com.crowdsourcedtesting.bean;

import java.util.Date;


/**
 * BugReport entity. @author MyEclipse Persistence Tools
 */

public class BugReport implements java.io.Serializable {

	// Fields

	private Integer reportId;
	private TestTask testTask;
	private Tester tester;
	private String reportTitle;
	private Boolean reportType;
	private Date submitTime;
	private String picture;
	private String operation;
	private Byte bugLevel;
	private String operationResult;
	private Boolean isSelected;

	// Constructors

	/** default constructor */
	public BugReport() {
	}

	/** minimal constructor */
	public BugReport(TestTask testTask, Tester tester, String reportTitle,
			Boolean reportType, Date submitTime, String operation,
			Boolean isSelected) {
		this.testTask = testTask;
		this.tester = tester;
		this.reportTitle = reportTitle;
		this.reportType = reportType;
		this.submitTime = submitTime;
		this.operation = operation;
		this.isSelected = isSelected;
	}

	/** full constructor */
	public BugReport(TestTask testTask, Tester tester, String reportTitle,
			Boolean reportType, Date submitTime, String picture,
			String operation, Byte bugLevel, String operationResult,
			Boolean isSelected) {
		this.testTask = testTask;
		this.tester = tester;
		this.reportTitle = reportTitle;
		this.reportType = reportType;
		this.submitTime = submitTime;
		this.picture = picture;
		this.operation = operation;
		this.bugLevel = bugLevel;
		this.operationResult = operationResult;
		this.isSelected = isSelected;
	}

	// Property accessors

	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public TestTask getTestTask() {
		return this.testTask;
	}

	public void setTestTask(TestTask testTask) {
		this.testTask = testTask;
	}

	public Tester getTester() {
		return this.tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	public String getReportTitle() {
		return this.reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Boolean getReportType() {
		return this.reportType;
	}

	public void setReportType(Boolean reportType) {
		this.reportType = reportType;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Byte getBugLevel() {
		return this.bugLevel;
	}

	public void setBugLevel(Byte bugLevel) {
		this.bugLevel = bugLevel;
	}

	public String getOperationResult() {
		return this.operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	public Boolean getIsSelected() {
		return this.isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

}