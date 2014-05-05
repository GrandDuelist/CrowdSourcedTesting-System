package cn.com.crowdsourcedtesting.model;

import oracle.net.aso.i;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.RegistrationPublisherForm;
import cn.com.crowdsourcedtesting.struts.form.RegistrationTesterForm;
import cn.com.crowdtest.factory.DAOFactory;

public class RegistrationHandler {
	
	//测试用户注册
	public void handleRegistrationTester(RegistrationTesterForm form) {
		
		Tester tester = new Tester();
		
		tester.setTesterName(form.getName());
		tester.setTesterEmail(form.getEmail());
		tester.setTesterPassword(form.getPassword());
		tester.setTesterGender(form.getGender());
		tester.setTesterMobile(form.getMobile());
		tester.setTesterBirthday(form.getBirthday());
		tester.setTesterPhoto(form.getPhoto());
		tester.setTesterCredit(form.getCredit());
		
		DAOFactory.getTesterDAO().save(tester);
				
	}
	
	//测试发布者注册
	public void handleRegistrationPublisher(RegistrationPublisherForm form) {
		Publisher publisher = new Publisher();
		
		publisher.setPublisherName(form.getName());
		publisher.setPublisherLogEmail(form.getLogEmail());
		publisher.setPublisherPassword(form.getPassword());
		publisher.setPublisherCredit(form.getCredit());
		publisher.setPublisherAuthority(form.getAuthority());
		publisher.setPublisherType(false);
		publisher.setPublisherConnectEmail(form.getConnectEmail());
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			DAOFactory.getPublisherDAO().save(publisher);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.close();
		}
	
	}
}
