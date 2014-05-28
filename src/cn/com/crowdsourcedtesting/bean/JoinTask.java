package cn.com.crowdsourcedtesting.bean;

// default package

import java.util.Date;

/**
 * JoinTask entity. @author MyEclipse Persistence Tools
 */

public class JoinTask implements java.io.Serializable {

	// Fields

	private Integer joinTaskId;
	private TestTask testTask;
	private Tester tester;
	private Date joinDate;

	// Constructors

	/** default constructor */
	public JoinTask() {
	}

	/** full constructor */
	public JoinTask(TestTask testTask, Tester tester, Date joinDate) {
		this.testTask = testTask;
		this.tester = tester;
		this.joinDate = joinDate;
	}
	
	/** minimal constructor */
	public JoinTask(TestTask testTask, Tester tester) {
		this.testTask = testTask;
		this.tester = tester;
	}

	// Property accessors

	public Integer getJoinTaskId() {
		return this.joinTaskId;
	}

	public void setJoinTaskId(Integer joinTaskId) {
		this.joinTaskId = joinTaskId;
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

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}