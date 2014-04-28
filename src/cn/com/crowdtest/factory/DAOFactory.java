package cn.com.crowdtest.factory;

import cn.com.crowdsourcedtesting.DAO.*;

public class DAOFactory {
	
	public static JoinQuestionnairDAO getJoinQuestionnairDAO(){
		return new JoinQuestionnairDAO();
	}
	
	public static AdministratorDAO getAdministratorDAO()
	{
		return new AdministratorDAO();
	}
	
	public static BugReportDAO getBugReportDAO()
	{
		return new BugReportDAO();
	}
	
	public static ProductDAO getProductDAO()
	{
		return new ProductDAO();
	}
	public static ChoiceDAO getChoiceDAO()
	{
		return new ChoiceDAO();
	}
	
	public static CategoryDAO getCategoryDAO()
	{
		 return new CategoryDAO();
	}
	
	public static JoinQuestionnaireDAO getJoinQuestionnaireDAO()
	{
		return new JoinQuestionnaireDAO();
	}
	
	public static ChoiceDAO getChoiceDAO()
	{
		return new ChoiceDAO();
	}

}
