package cn.com.crowdtest.factory;

import cn.com.crowdsourcedtesting.DAO.*;

public class DAOFactory {
	
	public static GiftDAO getGiftDAO(){
		return new GiftDAO();
	}
	
	public static AdministratorDAO getAdministratorDAO()
	{
		return new AdministratorDAO();
	}
	
	public static BugReportDAO getBugReportDAO()
	{
		return new BugReportDAO();
	}

}
