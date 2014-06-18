package cn.com.crowdsourcedtesting.model;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;


import cn.com.crowdsourcedtesting.modelhelper.MethodNumber;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.other.page.Page;


/**
 * 此handler里面包含一些常用的页面处理方法
 * 其他handler直接调用这里面的功用模块
 * @author 方志晗
 *
 */
public abstract class GeneralHandler {
	
	
	//ListHandle的接口
	abstract public void  setTargetListOne(Page page, HttpServletRequest request);
	abstract public void  setTargetListTwo(Page page, HttpServletRequest request);
	abstract public void  setTargetListThree(Page page, HttpServletRequest request);
	
	//DetailHandle的接口
	abstract public void  setTargetDetailOne(int id,HttpServletRequest request);
	abstract public void  setTargetDetailTwo(int id,HttpServletRequest request);
	abstract public void  setTargetDetailThree(int id,HttpServletRequest request);
	
	  /**
     * @author 方志晗 
     * 发送邮件
     */
    
    public void sendEmail(String emailAddress,String mailContent,String subject)
	{
		findAuthenticator authenticator = new findAuthenticator("lin1014582610@163.com","zhaoyunting36057");
		
		Properties pros = new Properties();
		pros.put("mail.smtp,host","smtp.163.com");
		pros.put("mail.smtp.port", "25");
		pros.put("mail.transport.protocol", "smtp");
		pros.put("mail.smtp.auth", "true");
		
		Session sendMailSession = Session.getDefaultInstance(pros,authenticator);
		
		try {
			Message mailMessage = new MimeMessage(sendMailSession);
			Address fromAddress = new InternetAddress("lin1014582610@163.com");
			mailMessage.setFrom(fromAddress);
			Address toAddress = new InternetAddress(emailAddress);
			mailMessage.setRecipient(Message.RecipientType.TO, toAddress);
			mailMessage.setSubject(subject);
			mailMessage.setSentDate(new Date());
			Multipart mainpart = new MimeMultipart();
			BodyPart htmlBodyPart  = new MimeBodyPart();
			htmlBodyPart.setContent(mailContent,"text/html;charset=utf-8");
			mainpart.addBodyPart(htmlBodyPart);
			mailMessage.setContent(mainpart);
			
			Transport transport = sendMailSession.getTransport("smtp");
			transport.connect("smtp.163.com","lin1014582610@163.com","zhaoyunting36057");
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	//通用的列表处理
	public void ListHandle(PageIdForm form,
			HttpServletRequest request, MethodNumber method)
	{
		String subType = null; //子类型 
		Page  page = new Page();
		if(form!=null)
		{
			
			subType=form.getSubType();
		}
		
		int currentPage = 1;
		//根据不同的类型来
		
		//类型为空
		if(subType ==null)
		{
			currentPage = 1;
			
		}else if("pageNum".equals(subType))
		{
			System.out.println(form.getPage());
			if(form.getPage().equals("0")){form.setPage("1");}
			currentPage  = Integer.parseInt(form.getPage());
		}else if("previousPage".equals(subType))
		{
			currentPage = Integer.parseInt(form.getPage())-1;
		}else if("nextPage".equals(subType))
		{
			currentPage = Integer.parseInt(form.getPage())+1;
		}
		
		page.setCurrentPage(currentPage);
		
		
		//不同的方法调用不同的接口
		switch(method){
		case MethodOne:setTargetListOne(page,request);break;
		case MethodTwo:setTargetListTwo(page,request);break;
		case MethodThree:setTargetListThree(page,request);break;
		}
		
		
	}
	
	
	
	/**
	 * 查看具体的问卷
	 * @param pageIDForm
	 * @param request
	 */

	public void detailHandle(PageIdForm pageIDForm,
			HttpServletRequest request, MethodNumber method) {
		// TODO Auto-generated method stub
		
		if(pageIDForm!=null&&pageIDForm.getId()!=null&&!pageIDForm.getId().equals(""))
		{
		int id  = Integer.parseInt(pageIDForm.getId());
		
		//不同的方法调用不同的接口
		switch(method){
		case MethodOne:setTargetDetailOne(id,request);break;
		case MethodTwo:setTargetDetailTwo(id,request);break;
		case MethodThree:setTargetDetailThree(id,request);break;
		
		}
		
		
		
		}
		
	}
	

	
	

}

class findAuthenticator extends Authenticator{  
    String userName=null;  
    String password=null;  
       
    public findAuthenticator(){  
    }  
    public findAuthenticator(String username, String password) {   
        this.userName = username;   
        this.password = password;   
    }   
    @Override
	protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(userName, password);  
    }  
    
 
}  
