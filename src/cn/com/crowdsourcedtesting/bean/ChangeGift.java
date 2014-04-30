package cn.com.crowdsourcedtesting.bean;

import java.util.Date;


/**
 * ChangeGift entity. @author MyEclipse Persistence Tools
 */

public class ChangeGift  implements java.io.Serializable {


    // Fields    

     private Integer changeId;
     private Gift gift;
     private Tester tester;
     private Double credit;
     private Date changeDate;
     private String sendAddress;


    // Constructors

    /** default constructor */
    public ChangeGift() {
    }

    
    /** full constructor */
    public ChangeGift(Gift gift, Tester tester, Double credit, Date changeDate, String sendAddress) {
        this.gift = gift;
        this.tester = tester;
        this.credit = credit;
        this.changeDate = changeDate;
        this.sendAddress = sendAddress;
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
   








}