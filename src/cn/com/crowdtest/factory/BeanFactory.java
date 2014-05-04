package cn.com.crowdtest.factory;

import cn.com.crowdsourcedtesting.DAO.AdministratorDAO;
import cn.com.crowdsourcedtesting.DAO.BugReportDAO;
import cn.com.crowdsourcedtesting.DAO.CategoryDAO;
import cn.com.crowdsourcedtesting.DAO.ChoiceDAO;
import cn.com.crowdsourcedtesting.DAO.GiftDAO;
import cn.com.crowdsourcedtesting.DAO.JoinQuestionnaireDAO;
import cn.com.crowdsourcedtesting.DAO.ProductDAO;
import cn.com.crowdsourcedtesting.DAO.PublisherDAO;
import cn.com.crowdsourcedtesting.DAO.QuestionDAO;
import cn.com.crowdsourcedtesting.DAO.QuestionnaireDAO;
import cn.com.crowdsourcedtesting.DAO.RecruitmentDAO;
import cn.com.crowdsourcedtesting.DAO.TesterDAO;
import cn.com.crowdsourcedtesting.bean.*;

public class BeanFactory {
	

	public static Gift getGift(){
		return new Gift();
	}
	
	public static Tester getTester(){
		return new Tester();
	}
	
	
	public static Publisher getPublisher()
	{
		return new Publisher();
	}
	
	public static Administrator getAdministrator()
	{
		return new Administrator();
	}
	
	public static BugReport getBugReport()
	{
		return new BugReport();
	}
	
	public static Product getProduct()
	{
		return new Product();
	}
	public static Choice getChoice()
	{
		return new Choice();
	}
	
	public static Category getCategory()
	{
		 return new Category();
	}
	
	public static JoinQuestionnaire getJoinQuestionnaire()
	{
		return new JoinQuestionnaire();
	}
	
	public static Question getQuestion()
	{
		return new Question();
	}
	
	public static Recruitment getRecruitment()
	{
		return new Recruitment();
	}
	
	public static Questionnaire getQuestionnaire()
	{
		return new Questionnaire();
	}
	

}
