package cn.com.crowdtest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.PublisherDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Choice;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Question;
import cn.com.crowdsourcedtesting.bean.Questionnaire;

public class StaticTest {
	public static void main(String[] argv) {

		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			PublisherDAO publisherDAO = new PublisherDAO();
			Publisher publisher = publisherDAO.findById(8);
			System.out.println(publisher.getPublisherLogEmail() + " "
					+ publisher.getPublisherName());
			Questionnaire questionnaire = new Questionnaire(publisher, "测试问卷",
					0.0, 0);
			session.save(questionnaire);

			Question question = new Question(questionnaire, false, "测试问题", 0);
			session.save(question);
			Choice choice = new Choice(question, "测试回答1", 0);
			session.save(choice);
			choice = new Choice(question, "测试回答2", 0);
			session.save(choice);
			choice = new Choice(question, "测试回答3", 0);
			session.save(choice);
			choice = new Choice(question, "测试回答4", 0);
			session.save(choice);

			tx.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

}
