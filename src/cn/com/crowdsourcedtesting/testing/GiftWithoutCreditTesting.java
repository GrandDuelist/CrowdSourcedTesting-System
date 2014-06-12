package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class GiftWithoutCreditTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/login");
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("password", "123456");
		addRequestParameter("method", "testerLogin");
		actionPerform();
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
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		verifyForward("changegiftfailed");
	}

}
