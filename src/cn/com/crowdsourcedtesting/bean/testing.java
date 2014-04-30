package cn.com.crowdsourcedtesting.bean;

import java.util.List;

import cn.com.crowdsourcedtesting.DAO.*;

import cn.com.crowdtest.factory.DAOFactory;

public class testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiftDAO gd=  DAOFactory.getGiftDAO();
		
		/*List<Gift> gifts=g.findAll();
		System.out.println();
		System.out.println(gifts.size());*/
		
		Gift g =  new  Gift();
		g.setChangeGifts(null);
		g.setGiftName("礼品");
		g.setGiftPhoto("000");
		g.setGiftCredit(12.00);
		g.setGiftAmount(22);
		
		
		gd.save(g);

	}

}
