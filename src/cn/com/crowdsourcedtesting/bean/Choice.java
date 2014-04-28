package cn.com.crowdsourcedtesting.bean;

/**
 * Choice entity. @author MyEclipse Persistence Tools
 */

public class Choice implements java.io.Serializable {

	// Fields

	private Integer choiceId;
	private Question question;
	private String choiceContent;
	private Integer selectCount;

	// Constructors

	/** default constructor */
	public Choice() {
	}

	/** full constructor */
	public Choice(Question question, String choiceContent, Integer selectCount) {
		this.question = question;
		this.choiceContent = choiceContent;
		this.selectCount = selectCount;
	}

	// Property accessors

	public Integer getChoiceId() {
		return this.choiceId;
	}

	public void setChoiceId(Integer choiceId) {
		this.choiceId = choiceId;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoiceContent() {
		return this.choiceContent;
	}

	public void setChoiceContent(String choiceContent) {
		this.choiceContent = choiceContent;
	}

	public Integer getSelectCount() {
		return this.selectCount;
	}

	public void setSelectCount(Integer selectCount) {
		this.selectCount = selectCount;
	}

}