package cn.com.crowdtest.factory;

import cn.com.crowdsourcedtesting.bean.*;

public class BeanFactory {
	
	public static Gift getGift()
	{
		return new Gift();
		
	}

}
