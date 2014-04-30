package cn.com.crowdtest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Tester;

public class StaticTest {
	public static void main(String[] argv) {

		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Tester tester = new Tester();
			tester.setTesterEmail("Shawn103@qq.com");
			tester.setTesterPassword("123456");
			tester.setTesterName("Shawn103");
			session.save(tester);
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
