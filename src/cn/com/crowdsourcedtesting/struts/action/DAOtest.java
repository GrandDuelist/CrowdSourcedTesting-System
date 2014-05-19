package cn.com.crowdsourcedtesting.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		int pagenow = 1;
		List<Gift> gifts = new ArrayList();
		GiftDAO dao = new GiftDAO();
		//一页16个礼品
		Page page = new Page();
		page.setCurrentPage(pagenow);
		page.setPerRows(16);
		page.setTotalRows(dao.getTotalSimilarRows("giftName", "礼"));
		gifts = dao.findSimilarPropertyByPage(page, "giftName", "礼");
		
		System.out.println(gifts.size());
		for(int i=0; i<gifts.size(); i++)
		{
			System.out.println(gifts.get(i).getGiftName());
		}
		
		
	}

}
