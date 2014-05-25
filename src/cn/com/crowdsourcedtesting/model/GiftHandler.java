package cn.com.crowdsourcedtesting.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.DAO.GiftDAO;
import cn.com.crowdsourcedtesting.DAO.TesterDAO;
import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.ChangeGift;
import cn.com.crowdsourcedtesting.bean.Gift;
import cn.com.crowdsourcedtesting.bean.JoinQuestionnaire;
import cn.com.crowdsourcedtesting.bean.Recruitment;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.modelhelper.MethodNumber;
import cn.com.crowdsourcedtesting.struts.form.GiftForm;
import cn.com.crowdsourcedtesting.struts.form.InformationForm;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;

public class GiftHandler extends GeneralHandler {

	public void selectGift(HttpServletRequest request, int id){
		GiftDAO dao = new GiftDAO();
		request.setAttribute("giftitem", dao.findById(id));
		request.setAttribute("isLegal", "legal");
	}
	
	@SuppressWarnings("unchecked")
	public void selectPage(String gifttype, String searchgift, HttpServletRequest request, int pagenow){
		List<Gift> gifts = new ArrayList();
		GiftDAO dao = new GiftDAO();
		Page page = new Page();
		//一页16个礼品
		if(gifttype.equals("all"))
		{
			page.setCurrentPage(pagenow);
			page.setPerRows(16);
			page.setTotalRows(dao.getTotalRows());

			gifts = dao.findByPage(page);
			if(gifts != null && gifts.size()>0)
			{
				request.setAttribute("gifts", gifts);
				request.setAttribute("page", page);
				request.setAttribute("isLegal", "legal");
			}
			else
				request.setAttribute("isLegal", "illegal");
		}
		if(gifttype.equals("available"))
		{
			page.setCurrentPage(pagenow);
			page.setPerRows(16);
			Double userCredit = 5000.0;
			page.setTotalRows(dao.getTotalAvailableRows(userCredit));

			gifts = dao.findAvailableByPage(userCredit, page);
			if(gifts != null && gifts.size()>0)
			{
				request.setAttribute("gifts", gifts);
				request.setAttribute("page", page);
				request.setAttribute("isLegal", "legal");
			}
			else
				request.setAttribute("isLegal", "illegal");
		}
		if(gifttype.equals("similar"))
		{
			page.setCurrentPage(pagenow);
			page.setPerRows(16);
			page.setTotalRows(dao.getTotalSimilarRows("giftName", searchgift));

			gifts = dao.findSimilarPropertyByPage(page, "giftName", searchgift);
			if(gifts != null && gifts.size()>0)
			{
				request.setAttribute("gifts", gifts);
				request.setAttribute("page", page);
				request.setAttribute("isLegal", "legal");
			}
			else
				request.setAttribute("isLegal", "illegal");
		}
	}
	
	public void selectAllGifts(HttpServletRequest request){
		int pagenow = 1;
		List<Gift> gifts = new ArrayList();
		GiftDAO dao = new GiftDAO();
		//一页16个礼品
		Page page = new Page();
		page.setCurrentPage(pagenow);
		page.setPerRows(16);
		page.setTotalRows(dao.getTotalRows());
		
		gifts = dao.findByPage(page);
		if(gifts != null && gifts.size()>0)
		{
			request.setAttribute("gifts", gifts);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	public void selectAvailableGifts(HttpServletRequest request){
		int pagenow = 1;
		//session里面拿用户的积分数值
		Double creditlimit = 5000.0;
		List<Gift> gifts = new ArrayList();
		GiftDAO dao = new GiftDAO();
		//一页16个礼品
		Page page = new Page();
		page.setCurrentPage(pagenow);
		page.setPerRows(16);
		page.setTotalRows(dao.getTotalAvailableRows(creditlimit));

		gifts = dao.findAvailableByPage(creditlimit, page);
		if(gifts != null && gifts.size()>0)
		{
			request.setAttribute("gifts", gifts);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void selectSimilarGifts(String searchgift, HttpServletRequest request){
		int pagenow = 1;
		List<Gift> gifts = new ArrayList();
		GiftDAO dao = new GiftDAO();
		//一页16个礼品
		Page page = new Page();
		page.setCurrentPage(pagenow);
		page.setPerRows(16);
		page.setTotalRows(dao.getTotalSimilarRows("giftName", searchgift));

		gifts = dao.findSimilarPropertyByPage(page, "giftName", searchgift);
		if(gifts != null && gifts.size()>0)
		{
			request.setAttribute("gifts", gifts);
			request.setAttribute("page", page);
			request.setAttribute("isLegal", "legal");
		}
		else
			request.setAttribute("isLegal", "illegal");
	}
	
	public boolean getGift(ActionMapping mapping, GiftForm giftForm,
			HttpServletRequest request, HttpServletResponse response){
		int id = giftForm.getGiftId();
		System.out.println("giftId:"+id);
		GiftDAO dao = new GiftDAO();
		Gift gift = dao.findById(id);
		if(gift == null)
			return false;
		
		Double creditneeded = gift.getGiftCredit();
		//Double usercredit = 5000.0;
		HttpSession session  = request.getSession();
		Tester tester = (Tester)session.getAttribute("Tester");

		Double usercredit = tester.getTesterCredit();
		System.out.println("礼物所需积分："+creditneeded);
		//判断用户积分和所需积分大小
		if(usercredit >= creditneeded)
		{
			request.setAttribute("giftitem", gift);
			request.setAttribute("isLegal", "legal");
			return true;
		}
		else
		{
			System.out.println("积分不够");
			request.setAttribute("isLegal", "illegal");
			return false;
		}
	}
	
	public boolean changeGift(ActionMapping mapping, GiftForm giftForm,
			HttpServletRequest request, HttpServletResponse response){
		int gift_id = giftForm.getGiftId();
		int tester_id = 24;
		Double credit = giftForm.getCredit();
		Date change_date = new Date(System.currentTimeMillis());//获取当前时间
		String address = giftForm.getAddress();
		String receiver = giftForm.getReceiver();
		String zipcode = giftForm.getZipcode();
		String mobile = giftForm.getMobile();
		
		System.out.println(gift_id+" "+credit+" "+change_date+" "+address+" "+receiver+" "+zipcode+" "+mobile);
		
		TesterDAO tdao = new TesterDAO();
		GiftDAO dao = new GiftDAO();
		Gift gift = dao.findById(gift_id);
		Tester tester = tdao.findById(tester_id);
		
		if(gift != null && tester != null)
		{
			Session session = HibernateSessionFactory.getSession();
			Transaction tst = session.beginTransaction(); 
			ChangeGift change = new ChangeGift(gift, tester, credit, change_date, receiver, zipcode, mobile);
			session.save(change);
			tst.commit();
			session.close();
			
			System.out.println("兑换成功");
			return true;
		}
		else
		{
			System.out.println("兑换失败");
			return false;
		}
	}
	
	
	
	
	/**
	 * 将获得的InformationForm转换为通用类型
	 * 
	 * @param form
	 * @return
	 */
	public PageIdForm changeToPageIdForm(ActionForm form) {
		InformationForm f = (InformationForm) form;
		
		if (f != null) {
			PageIdForm pageIdForm = new PageIdForm();
			pageIdForm.setId(f.getId() + "");
			pageIdForm.setPage(f.getPage() + "");
			if(f.getSubType()!=null)pageIdForm.setSubType(f.getSubType());
			return pageIdForm;
		}
		
		return null;
		
	}

	/**
	 * 自定义参数的路由
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param targetPage
	 * @param method
	 * @return
	 */
	public ActionForward generalListRouter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, String targetPage,
			MethodNumber method) {
       
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session
				.getAttribute("Administrator");
		if (admin == null) {
			return mapping.findForward("adminLogin");
		}
		
		request.setAttribute("isLegal", "true");
		this.ListHandle(this.changeToPageIdForm(form), request, method);
		return mapping.findForward(targetPage);
	}

	/**
	 * 自定义参数的路由
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param targetPage
	 * @param method
	 * @return
	 */
	public ActionForward generalDetailRouter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, String targetPage,
			MethodNumber method) {

		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session
				.getAttribute("Administrator");
		if (admin == null) {
			return mapping.findForward("adminLogin");
		}
		request.setAttribute("isLegal", "true");
		this.detailHandle(this.changeToPageIdForm(form), request, method);
		return mapping.findForward(targetPage);
	}

	@Override
	public void setTargetListOne(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		page.setTotalRows(DAOFactory.getChangeGiftDAO().getTotalRows());
		List<ChangeGift> changeGifts = DAOFactory.getChangeGiftDAO().findNotDeliveredByPage(page);
		request.setAttribute("currentPage", page);
		request.setAttribute("changeGifts", changeGifts);
		
	}

	@Override
	public void setTargetListTwo(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetListThree(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetDetailOne(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetDetailTwo(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetDetailThree(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
}
