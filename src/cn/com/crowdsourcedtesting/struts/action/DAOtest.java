package cn.com.crowdsourcedtesting.struts.action;

import java.util.ArrayList;
import java.util.List;

import cn.com.crowdsourcedtesting.DAO.GiftDAO;
import cn.com.crowdsourcedtesting.DAO.RecruitmentDAO;
import cn.com.crowdsourcedtesting.bean.Gift;
import cn.com.crowdsourcedtesting.bean.Recruitment;
import cn.com.other.page.Page;

public class DAOtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pagenow = 1;
		List<Recruitment> recruitments = new ArrayList();
		RecruitmentDAO dao = new RecruitmentDAO();
		Page page = new Page();
		page.setCurrentPage(pagenow);
		page.setPerRows(12);
		page.setTotalRows(dao.getTotalRows());
		
		recruitments = dao.findByPage(page);
		System.out.println(recruitments.size());
		
		
//		int pagenow = 1;
//		//session里面拿用户的积分数值
//		Double creditlimit = 5000.0;
//		List<Gift> gifts = new ArrayList();
//		GiftDAO dao = new GiftDAO();
//		//一页16个礼品
//		Page page = new Page();
//		page.setCurrentPage(pagenow);
//		page.setPerRows(16);
//		page.setTotalRows(dao.getTotalAvailableRows(creditlimit));
//		
//		gifts = dao.findAvailableByPage(creditlimit, page);
//		System.out.println(gifts.size());
//		
//		System.out.println(dao.findById(2).getGiftName());
	}

}
