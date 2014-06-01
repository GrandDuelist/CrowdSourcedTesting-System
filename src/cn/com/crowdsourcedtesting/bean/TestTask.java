package cn.com.crowdsourcedtesting.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TestTask entity. @author MyEclipse Persistence Tools
 */

public class TestTask implements java.io.Serializable {

	// Fields

	private Integer taskId;
	private Product product;
	private Publisher publisher;
	private Date taskStartTime;
	private Date taskEndTime;
	private Integer taskType;
	private Administrator administrator;
	private String taskEnvironment;
	private Double perReward;
	private Double wholeCredit;
//	private Set bugReports = new HashSet(0);
	private Set taskComments = new HashSet(0);
	private Boolean isPassed ;

	// Constructors

	/** default constructor */
	public TestTask() {
	}

	/** minimal constructor */
	public TestTask(Product product, Publisher publisher, Integer taskType,
			Double perReward, Double wholeCredit) {
		this.product = product;
		this.publisher = publisher;
		this.taskType = taskType;
		this.perReward = perReward;
		this.wholeCredit = wholeCredit;
	}

	/** full constructor */
//	public TestTask(Product product, Publisher publisher, Date taskStartTime,
//			Date taskEndTime, Integer taskType, Administrator administrator,
//			String taskEnvironment, Double perReward, Double wholeCredit,
//			Set bugReports, Set taskComments) {
//		this.product = product;
//		this.publisher = publisher;
//		this.taskStartTime = taskStartTime;
//		this.taskEndTime = taskEndTime;
//		this.taskType = taskType;
//		this.administrator = administrator;
//		this.taskEnvironment = taskEnvironment;
//		this.perReward = perReward;
//		this.wholeCredit = wholeCredit;
//		this.bugReports = bugReports;
//		this.taskComments = taskComments;
//	}

	// Property accessors
	public Boolean getIsPassed() {
		return isPassed;
	}

	public void setIsPassed(Boolean isPassed) {
		this.isPassed = isPassed;
	}
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Date getTaskStartTime() {
		return this.taskStartTime;
	}

	public void setTaskStartTime(Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public Date getTaskEndTime() {
		return this.taskEndTime;
	}

	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public Integer getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public String getTaskEnvironment() {
		return this.taskEnvironment;
	}

	public void setTaskEnvironment(String taskEnvironment) {
		this.taskEnvironment = taskEnvironment;
	}

	public Double getPerReward() {
		return this.perReward;
	}

	public void setPerReward(Double perReward) {
		this.perReward = perReward;
	}

	public Double getWholeCredit() {
		return this.wholeCredit;
	}

	public void setWholeCredit(Double wholeCredit) {
		this.wholeCredit = wholeCredit;
	}

//	public Set getBugReports() {
//		return this.bugReports;
//	}
//
//	public void setBugReports(Set bugReports) {
//		this.bugReports = bugReports;
//	}
//
	public Set getTaskComments() {
		return this.taskComments;
	}

	public void setTaskComments(Set taskComments) {
		this.taskComments = taskComments;
	}

}