package cn.com.crowdtest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.DAO.TesterDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.JoinTask;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.crowdsourcedtesting.bean.Tester;

public class StaticTest {

	public static void main(String[] argv) {

		Session session = HibernateSessionFactory.getSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			TesterDAO testerDAO = new TesterDAO();
			Tester tester = testerDAO.findById(2);
			TestTaskDAO testTaskDAO = new TestTaskDAO();
			TestTask testTask = testTaskDAO.findById(28);
			JoinTask joinTask = new JoinTask(testTask, tester);
			session.save(joinTask);
			tran.commit();

		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		}

	}
}
