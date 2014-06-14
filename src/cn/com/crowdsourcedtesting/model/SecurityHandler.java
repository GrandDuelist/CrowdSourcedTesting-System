package cn.com.crowdsourcedtesting.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sun.jmx.snmp.tasks.Task;

import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.JoinQuestionnaire;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Questionnaire;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.AdminLoginForm;
import cn.com.crowdsourcedtesting.struts.form.ChangeInformationForm;
import cn.com.crowdsourcedtesting.struts.form.FindPasswordForm;
import cn.com.crowdsourcedtesting.struts.form.LoginForm;
import cn.com.crowdsourcedtesting.struts.form.PublisherLoginForm;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;

public class SecurityHandler extends GeneralHandler {

	// 测试用户的登�
	public Tester handleTesterLogin(LoginForm form)
	{
		Tester tester=DAOFactory.getTesterDAO().isTester(form.getUsername(), form.getPassword());

		return tester;
		
	}
	
	// 发布者的登录
		public Publisher handlePublisherLogin(PublisherLoginForm form)
		{
			Publisher publisher=DAOFactory.getPublisherDAO().isPublisher(form.getUsername(), form.getPassword());

			
			return publisher;
			
			
		}
		
     //管理员的登录
		public Administrator handleAdministratorLogin(AdminLoginForm form)
		{
			Administrator administrator = DAOFactory.getAdministratorDAO().isAdministrator(form.getUsername(), form.getPassword());
			return administrator;
		}
		
		public void handleTesterFindPassword(FindPasswordForm form) {
			
			Tester tester = new Tester();
			
			List<Tester> testers = DAOFactory.getTesterDAO().findByTesterEmail(form.getEmail());
			Iterator<Tester> iterator = testers.iterator();
			
			if(iterator.hasNext())
			{
				Tester tester_use = iterator.next();
				tester.setTesterId(tester_use.getTesterId());
				tester.setTesterEmail(form.getEmail());
				tester.setTesterPassword(form.getPassword());
				tester.setTesterName(tester_use.getTesterName());
				tester.setTesterCredit(tester_use.getTesterCredit());
				
				Session session = HibernateSessionFactory.getSession();
				
				Transaction transaction = null;
				try {
					transaction = session.beginTransaction();
					session.saveOrUpdate(tester);
					transaction.commit();
				} catch (Exception e) {
					// TODO: handle exception
					if (transaction != null) {
						transaction.rollback();
					}
				} finally{
					session.close();
				}
				
			}			
			
		}
		
		public void handleTesterChangeInformation(ChangeInformationForm form,HttpServletRequest request) {
			Tester tester = new Tester();
			
			List<Tester> testers = DAOFactory.getTesterDAO().findByTesterEmail(form.getEmail());
			Iterator<Tester> iterator = testers.iterator();
			
			if(iterator.hasNext())
			{
				Tester tester_use = iterator.next();
				tester.setTesterId(tester_use.getTesterId());
				tester.setTesterEmail(form.getEmail());
				if(form.getPassword() != null)
				{
					tester.setTesterPassword(form.getPassword());
				}
				else {
					tester.setTesterPassword(tester_use.getTesterPassword());
				}
				if(form.getName() != null)
				{
					tester.setTesterName(form.getName());
				}
				else {
					tester.setTesterName(tester_use.getTesterName());
				}
				tester.setTesterCredit(tester_use.getTesterCredit());
				
				Session session = HibernateSessionFactory.getSession();
				
				Transaction transaction = null;
				try {
					transaction = session.beginTransaction();
					session.saveOrUpdate(tester);
					transaction.commit();
				} catch (Exception e) {
					// TODO: handle exception
					if (transaction != null) {
						transaction.rollback();
					}
				} finally{
					session.close();
				}
				HttpSession session2 = request.getSession();
				session2.setAttribute("Tester", tester);
			}
			
		}

		
	//第一个列表接口： 得到企业注册用户
		@Override
		public void setTargetListOne(Page page, HttpServletRequest request) {
			// TODO Auto-generated method stub
			
			
			page.setTotalRows(DAOFactory.getPublisherDAO().getUncheckedCompanyTotalRows());
			List <Publisher> registers  = DAOFactory.getPublisherDAO().findUncheckedCompanyByPage(page);
			HttpSession session  = request.getSession();
			session.setAttribute("currentPage", page);
			session.setAttribute("registers", registers);
			session.setAttribute("publisherType", "Company");
			
			
		}
  //第二个个列表接口,得到个人注册用户
		@Override
		public void setTargetListTwo(Page page, HttpServletRequest request) {
			// TODO Auto-generated method stub
			
			page.setTotalRows(DAOFactory.getPublisherDAO().getUncheckedPersonTotalRows());
			List <Publisher> registers  = DAOFactory.getPublisherDAO().findUncheckedPersonByPage(page);
			HttpSession session  = request.getSession();
			session.setAttribute("currentPage", page);
			session.setAttribute("registers", registers);
			session.setAttribute("publisherType", "Person");
			
		}

		@Override
		public void setTargetListThree(Page page, HttpServletRequest request) {
			// TODO Auto-generated method stub
			
		}

		
		//DetailHandle的处理接�
		@Override
		public void setTargetDetailOne(int id, HttpServletRequest request) {
			// TODO Auto-generated method stub
			Publisher publisher = DAOFactory.getPublisherDAO().findById(id);
			HttpSession session  = request.getSession();

			session.setAttribute("publisher", publisher);
			session.setAttribute("publisherType", "Company");
			
		}
		//DetailHandle的处理接�
		@Override
		public void setTargetDetailTwo(int id, HttpServletRequest request) {
			// TODO Auto-generated method stub
			Publisher publisher = DAOFactory.getPublisherDAO().findById(id);
			HttpSession session  = request.getSession();

			session.setAttribute("publisher", publisher);
			session.setAttribute("publisherType", "Person");
			
		}

		@Override
		public void setTargetDetailThree(int id, HttpServletRequest request) {
			// TODO Auto-generated method stub
	
			
		}
		
		
	public void findAllTask(Tester tester) {
			
			List <Task> tasks= new ArrayList<Task>();
	
			
		}
		
		public void findAllQuestionnair(Tester tester,HttpServletRequest request){
			
			HttpSession session = request.getSession();
			
			List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
			List<JoinQuestionnaire> joinQuestionnaires = new ArrayList<JoinQuestionnaire>();
			joinQuestionnaires.addAll(DAOFactory.getTesterDAO().findById(tester.getTesterId()).getJoinQuestionnaires());
			Iterator iterator= joinQuestionnaires.iterator();
			
			
			while (iterator.hasNext()) {
				JoinQuestionnaire joinQuestionnaire = (JoinQuestionnaire)iterator.next();
				questionnaires.add(joinQuestionnaire.getQuestionnaire());	
			}
			
			session.setAttribute("Questionnaires", questionnaires);
			
		}
}