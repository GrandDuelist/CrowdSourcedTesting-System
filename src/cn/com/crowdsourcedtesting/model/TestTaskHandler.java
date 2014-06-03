package cn.com.crowdsourcedtesting.model;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.DAO.TesterDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.TaskComment;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;

public class TestTaskHandler  extends GeneralHandler{

	public void addNewComment(int taskId, String content, HttpServletRequest request) {
		TesterDAO pdao = new TesterDAO();
		TestTaskDAO tdao = new TestTaskDAO();
		TestTask task = tdao.findById(taskId);
		
		HttpSession httpsession  = request.getSession();
		Tester tester = (Tester)httpsession.getAttribute("Tester");
		
		Date time = new Date();
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction();
		TaskComment comment = new TaskComment(task, tester, content, time);
		session.save(comment);
		tst.commit();
		session.close();

		request.setAttribute("isLegal", "legal");
	}

	
	/**
	 * 第一个为Web任务测试的接口
	 */
	@Override
	public void setTargetListOne(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		page.setTotalRows(DAOFactory.getTestTaskDAO().getUncheckedWebTotalRows());
		List <TestTask> testTasks  = DAOFactory.getTestTaskDAO().findUncheckedWebByPage(page);
		HttpSession session  = request.getSession();
		session.setAttribute("currentPage", page);
		session.setAttribute("testTasks", testTasks);
		session.setAttribute("taskType","Web");
		
		
	}

	/**
	 * 第二个为Android任务的接口
	 */
	@Override
	public void setTargetListTwo(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		page.setTotalRows(DAOFactory.getTestTaskDAO().getUncheckedAndroidTotalRows());
		List <TestTask> testTasks  = DAOFactory.getTestTaskDAO().findUncheckedAndroidByPage(page);
		HttpSession session  = request.getSession();
		session.setAttribute("currentPage", page);
		session.setAttribute("testTasks", testTasks);
		session.setAttribute("taskType","Android");
	}
	
	

	/**
	 * 第三个为桌面任务的接口
	 */
	@Override
	public void setTargetListThree(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		page.setTotalRows(DAOFactory.getTestTaskDAO().getUncheckedDesktopTotalRows());
		List <TestTask> testTasks  = DAOFactory.getTestTaskDAO().findUncheckedDesktopByPage(page);
		HttpSession session  = request.getSession();
		session.setAttribute("currentPage", page);
		session.setAttribute("testTasks", testTasks);
		session.setAttribute("taskType","Desktop");
		
	}
	
	
/**
 * 进入细节处理的第一个i饿接口
 */
	@Override
	public void setTargetDetailOne(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		TestTask testTask = DAOFactory.getTestTaskDAO().findById(id);
		HttpSession session  = request.getSession();

		session.setAttribute("testTask", testTask);
		session.setAttribute("publisherType", "Web");
		
	}
/**
 * 进入细节处理的第二个接口
 */
	@Override
	public void setTargetDetailTwo(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		TestTask testTask = DAOFactory.getTestTaskDAO().findById(id);
		HttpSession session  = request.getSession();

		session.setAttribute("testTask", testTask);
		session.setAttribute("publisherType", "Android");
		
	}

	/**
	 * 进入细节处理的第三个接口
	 */
	@Override
	public void setTargetDetailThree(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		TestTask testTask = DAOFactory.getTestTaskDAO().findById(id);
		HttpSession session  = request.getSession();

		session.setAttribute("testTask", testTask);
		session.setAttribute("publisherType", "Desktop");
		
		
	}

}
