package cn.com.crowdtest.factory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.*;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;

public class DAOFactory {
	
	public static GiftDAO getGiftDAO(){
		return new GiftDAO();
	}
	
	public static TesterDAO getTesterDAO(){
		return new TesterDAO();
	}
	
	
	public static PublisherDAO getPublisherDAO()
	{
		return new PublisherDAO();
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
	
	public static QuestionDAO getQuestionDAO()
	{
		return new QuestionDAO();
	}
	
	public static RecruitmentDAO getRecruitmentDAO()
	{
		return new RecruitmentDAO();
	}
	
	public static QuestionnaireDAO getQuestionnaireDAO()
	{
		return new QuestionnaireDAO();
	}
	
	public static TestTaskDAO getTestTaskDAO()
	{
		return new TestTaskDAO();
	}

	
	
	public static void sessionSaveOrUpdate(Object q )
	{
		Session sess = HibernateSessionFactory.getSession();

		Transaction tran = null;

		try {

		    
			tran = sess.beginTransaction();
			sess.saveOrUpdate(q);
		} catch (RuntimeException e) {

			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}

		} finally {

			sess.close();
		}
	}

	public static ChangeGiftDAO getChangeGiftDAO() {
		// TODO Auto-generated method stub
		return new ChangeGiftDAO();
	}
	

}
