package cn.com.crowdsourcedtesting.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private Integer questionId;
	private Questionnaire questionnaire;
	private Boolean questionType;
	private String questionContent;
	private Integer questionCount;
	private Set choices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(Questionnaire questionnaire, Boolean questionType,
			String questionContent, Integer questionCount) {
		this.questionnaire = questionnaire;
		this.questionType = questionType;
		this.questionContent = questionContent;
		this.questionCount = questionCount;
	}

	/** full constructor */
	public Question(Questionnaire questionnaire, Boolean questionType,
			String questionContent, Integer questionCount, Set choices) {
		this.questionnaire = questionnaire;
		this.questionType = questionType;
		this.questionContent = questionContent;
		this.questionCount = questionCount;
		this.choices = choices;
	}

	// Property accessors

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Boolean getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(Boolean questionType) {
		this.questionType = questionType;
	}

	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Integer getQuestionCount() {
		return this.questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public Set getChoices() {
		return this.choices;
	}

	public void setChoices(Set choices) {
		this.choices = choices;
	}

}