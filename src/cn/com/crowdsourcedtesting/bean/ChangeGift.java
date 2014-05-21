package cn.com.crowdsourcedtesting.bean;

import java.util.Date;

/**
 * ChangeGift entity. @author MyEclipse Persistence Tools
 */

public class ChangeGift implements java.io.Serializable {

	// Fields

	private Integer changeId;
	private Gift gift;
	private Tester tester;
	private Double credit;
	private Date changeDate;
	private String sendAddress;
	private String receiver;
	private String zipcode;
	private String mobile;

	// Constructors

	/** default constructor */
	public ChangeGift() {
	}

	/** minimal constructor */
	public ChangeGift(Gift gift, Tester tester, Double credit, Date changeDate,
			String sendAddress, String receiver, String mobile) {
		this.gift = gift;
		this.tester = tester;
		this.credit = credit;
		this.changeDate = changeDate;
		this.sendAddress = sendAddress;
		this.receiver = receiver;
		this.mobile = mobile;
	}

	/** full constructor */
	public ChangeGift(Gift gift, Tester tester, Double credit, Date changeDate,
			String sendAddress, String receiver, String zipcode, String mobile) {
		this.gift = gift;
		this.tester = tester;
		this.credit = credit;
		this.changeDate = changeDate;
		this.sendAddress = sendAddress;
		this.receiver = receiver;
		this.zipcode = zipcode;
		this.mobile = mobile;
	}

	// Property accessors

	public Integer getChangeId() {
		return this.changeId;
	}

	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

	public Gift getGift() {
		return this.gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Tester getTester() {
		return this.tester;
	}

	public void setTester(Tester tester) {
		this.tester = tester;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getSendAddress() {
		return this.sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}