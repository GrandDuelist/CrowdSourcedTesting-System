package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class GiftWithoutTesterTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testGetGiftFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "getGift");
		addRequestParameter("giftId", "2");
		actionPerform();
		assertNull(getSession().getAttribute("Tester"));
		verifyForward("changegiftfailed");
	}

	@Test
	public final void testChangeGiftFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "changeGift");
		addRequestParameter("giftId", "2");
		addRequestParameter("credit", "100");
		addRequestParameter("address", "同济大学");
		addRequestParameter("receiver", "测试用户");
		addRequestParameter("zipcode", "201803");
		addRequestParameter("mobile", "188175123");
		actionPerform();
		assertNull(getSession().getAttribute("Tester"));
		verifyForward("changegiftfailed");
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "changeGift");
		addRequestParameter("giftId", "200");
		addRequestParameter("credit", "100");
		addRequestParameter("address", "同济大学");
		addRequestParameter("receiver", "测试用户");
		addRequestParameter("zipcode", "201803");
		addRequestParameter("mobile", "188175123");
		actionPerform();
		verifyForward("changegiftfailed");
	}

}
