package cn.com.crowdsourcedtesting.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Questionnaire implements java.io.Serializable {

	// Fields

	private Integer questionnaireId;
	private Administrator administrator;
	private Publisher publisher;
	private String title;
	private Double credit;
	private Integer questionnaireCount;
	private Set questions = new HashSet(0);
	private Set joinQuestionnaires = new HashSet(0);

	// Constructors

	/** default constructor */
	public Questionnaire() {
	}

	/** minimal constructor */
	public Questionnaire(Publisher publisher, String title, Double credit,
			Integer questionnaireCount) {
		this.publisher = publisher;
		this.title = title;
		this.credit = credit;
		this.questionnaireCount = questionnaireCount;
	}

	/** full constructor */
	public Questionnaire(Administrator administrator, Publisher publisher,
			String title, Double credit, Integer questionnaireCount,
			Set questions, Set joinQuestionnaires) {
		this.administrator = administrator;
		this.publisher = publisher;
		this.title = title;
		this.credit = credit;
		this.questionnaireCount = questionnaireCount;
		this.questions = questions;
		this.joinQuestionnaires = joinQuestionnaires;
	}

	// Property accessors

	public Integer getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Integer getQuestionnaireCount() {
		return this.questionnaireCount;
	}

	public void setQuestionnaireCount(Integer questionnaireCount) {
		this.questionnaireCount = questionnaireCount;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	public Set getJoinQuestionnaires() {
		return this.joinQuestionnaires;
	}

	public void setJoinQuestionnaires(Set joinQuestionnaires) {
		this.joinQuestionnaires = joinQuestionnaires;
	}

}