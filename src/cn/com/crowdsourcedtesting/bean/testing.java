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
		GiftDAO g=  DAOFactory.getGiftDAO();
		
		List<Gift> gifts=g.findAll();
		System.out.println();
		System.out.println(gifts.size());

	}

}
