package cn.com.crowdsourcedtesting.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import cn.com.crowdsourcedtesting.DAO.RecruitmentDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Recruitment;
import cn.com.other.page.Page;

public class RecruitmentHandler {

	//前端调用
	public void selectAllRecruitments(Page page, HttpServletRequest request){
		List<Recruitment> recruitments = new ArrayList();
		RecruitmentDAO dao = new RecruitmentDAO();

		recruitments = dao.findByPage(page);
		request.setAttribute("hirelist", recruitments);
		request.setAttribute("page", page);
		request.setAttribute("isLegal", "legal");
		
	}
	
	public void selectRecruitment(int id, HttpServletRequest request){
		RecruitmentDAO dao = new RecruitmentDAO();
		request.setAttribute("hireitem", dao.findById(id));
		request.setAttribute("isLegal", "legal");
	}
	
	public void selectPage(Page page, HttpServletRequest request){
		List<Recruitment> recruitments = new ArrayList();
		RecruitmentDAO dao = new RecruitmentDAO();

		recruitments = dao.findByPage(page);
		request.setAttribute("hirelist", recruitments);
		request.setAttribute("page", page);
	}
	
	
	//后台调用
	public void addNewRecruitment(String title, int online, Date startdate, Date enddate, String place, String brief, String content, String company, int publisherId, HttpServletRequest request){
		RecruitmentDAO dao = new RecruitmentDAO();
		boolean flag = true;
		if(online != 1)
			flag = false;
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction(); 
		Recruitment newrecruitment = new Recruitment(title, startdate, enddate, flag, content, brief, company, place, false, publisherId, null);
		session.save(newrecruitment);
		tst.commit();
		session.close();
		
		request.setAttribute("isLegal", "legal");
	}
	
	//public void 
	
}
