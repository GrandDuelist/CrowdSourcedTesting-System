package cn.com.crowdtest.test;

import cn.com.crowdsourcedtesting.model.GeneralHelperHandler;

public class StaticTest {

	public static void main(String[] argv) {
		GeneralHelperHandler handler = new GeneralHelperHandler();
		System.out.print(handler.isUrl("www.baidu.com"));
	}
}
