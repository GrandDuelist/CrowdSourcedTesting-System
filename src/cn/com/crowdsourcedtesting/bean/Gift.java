package cn.com.crowdsourcedtesting.bean;

/**
 * Gift entity. @author MyEclipse Persistence Tools
 */

public class Gift implements java.io.Serializable {

	// Fields

	private Integer giftId;
	private Integer giftAmount;
	private Double giftCredit;
	private String giftName;
	private String giftPhoto;
//	private Set changeGifts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Gift() {
	}

	/** minimal constructor */
	public Gift(Integer giftAmount, Double giftCredit, String giftName,
			String giftPhoto) {
		this.giftAmount = giftAmount;
		this.giftCredit = giftCredit;
		this.giftName = giftName;
		this.giftPhoto = giftPhoto;
	}

	/** full constructor */
//	public Gift(Integer giftAmount, Double giftCredit, String giftName,
//			String giftPhoto, Set changeGifts) {
//		this.giftAmount = giftAmount;
//		this.giftCredit = giftCredit;
//		this.giftName = giftName;
//		this.giftPhoto = giftPhoto;
//		this.changeGifts = changeGifts;
//	}

	// Property accessors

	public Integer getGiftId() {
		return this.giftId;
	}

	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}

	public Integer getGiftAmount() {
		return this.giftAmount;
	}

	public void setGiftAmount(Integer giftAmount) {
		this.giftAmount = giftAmount;
	}

	public Double getGiftCredit() {
		return this.giftCredit;
	}

	public void setGiftCredit(Double giftCredit) {
		this.giftCredit = giftCredit;
	}

	public String getGiftName() {
		return this.giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public String getGiftPhoto() {
		return this.giftPhoto;
	}

	public void setGiftPhoto(String giftPhoto) {
		this.giftPhoto = giftPhoto;
	}

//	public Set getChangeGifts() {
//		return this.changeGifts;
//	}
//
//	public void setChangeGifts(Set changeGifts) {
//		this.changeGifts = changeGifts;
//	}

}