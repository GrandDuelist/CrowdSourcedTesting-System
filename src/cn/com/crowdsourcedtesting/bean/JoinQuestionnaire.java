package cn.com.crowdsourcedtesting.bean;

import java.util.Date;


/**
 * JoinQuestionnaire entity. @author MyEclipse Persistence Tools
 */

public class JoinQuestionnaire implements java.io.Serializable {

	// Fields

	private Integer joinId;
	private Questionnaire questionnaire;
	private Tester tester;
	private Date joinTime;

	// Constructors

	/** default constructor */
	public JoinQuestionnaire() {
	}

	/** full constructor */
	public JoinQuestionnaire(Questionnaire questionnaire, Tester tester,
			Date joinTime) {
		this.questionnaire = questionnaire;
		this.tester = tester;
		this.joinTime = joinTime;
	}

	// Property accessors

	public Integer getJoinId() {
		return this.joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Tester getTester() {
		return this.tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

}