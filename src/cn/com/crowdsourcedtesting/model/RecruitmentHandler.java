package cn.com.crowdsourcedtesting.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.AdministratorDAO;
import cn.com.crowdsourcedtesting.DAO.PublisherDAO;
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
		if(recruitments != null && recruitments.size()>0)
		{
			request.setAttribute("hirelist", recruitments);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	public void selectRecentRecruitments(Page page, HttpServletRequest request){
		List<Recruitment> recruitments = new ArrayList();
		RecruitmentDAO dao = new RecruitmentDAO();

		recruitments = dao.findByPage(page);
		if(recruitments != null && recruitments.size()>0)
		{
			request.setAttribute("hirelist", recruitments);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	public void selectRecruitment(int id, HttpServletRequest request){
		RecruitmentDAO dao = new RecruitmentDAO();
		Recruitment recruitment = dao.findById(id);
		if(recruitment != null)
		{
			request.setAttribute("hireitem", recruitment);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	public void selectPage(Page page, HttpServletRequest request){
		List<Recruitment> recruitments = new ArrayList();
		RecruitmentDAO dao = new RecruitmentDAO();

		recruitments = dao.findByPage(page);
		if(recruitments != null && recruitments.size()>0)
		{
			request.setAttribute("hirelist", recruitments);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	
	//后台调用
	public void addNewRecruitment(String title, int online, Date startdate, Date enddate, String place, String brief, String content, String company, int publisherId, HttpServletRequest request){
		RecruitmentDAO dao = new RecruitmentDAO();
		PublisherDAO pdao = new PublisherDAO();
		AdministratorDAO adao = new AdministratorDAO();
		boolean flag = true;
		if(online != 1)
			flag = false;
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction(); 
		Recruitment newrecruitment = new Recruitment(title,startdate,enddate,flag,content,brief,company,place,false,pdao.findById(8),null);
		session.save(newrecruitment);
		tst.commit();
		session.close();
		
		request.setAttribute("isLegal", "legal");
	}
	
	public void reviceRecruitment(int id, String title, String place, String brief, String content, String company, HttpServletRequest request){
		RecruitmentDAO rdao = new RecruitmentDAO();
		Recruitment oldrecruitment = rdao.findById(id);
		oldrecruitment.setActivityName(title);
		oldrecruitment.setBrief(brief);
		oldrecruitment.setPlace(place);
		oldrecruitment.setCompany(company);
		oldrecruitment.setContent(content);
				
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction(); 		
		session.saveOrUpdate(oldrecruitment);
		tst.commit();
		session.close();
		
		request.setAttribute("isLegal", "legal");
	}
	
}
