package cn.com.crowdtest.factory;

import cn.com.crowdsourcedtesting.DAO.*;

public class DAOFactory {
	
	public static GiftDAO getGiftDAO(){
		return new GiftDAO();
	}

}
