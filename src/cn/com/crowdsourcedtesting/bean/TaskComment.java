package cn.com.crowdsourcedtesting.bean;

import java.util.Date;


/**
 * TaskComment entity. @author MyEclipse Persistence Tools
 */

public class TaskComment  implements java.io.Serializable {


    // Fields    

     private Integer commentId;
     private TestTask testTask;
     private Tester tester;
     private String commentContent;
     private Date commentTime;


    // Constructors

    /** default constructor */
    public TaskComment() {
    }

    
    /** full constructor */
    public TaskComment(TestTask testTask, Tester tester, String commentContent, Date commentTime) {
        this.testTask = testTask;
        this.tester = tester;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

   
    // Property accessors

    public Integer getCommentId() {
        return this.commentId;
    }
    
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public String getCommentContent() {
        return this.commentContent;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return this.commentTime;
    }
    
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
   








}