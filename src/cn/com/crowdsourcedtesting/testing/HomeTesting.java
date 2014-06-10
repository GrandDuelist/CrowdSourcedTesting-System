package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.crowdsourcedtesting.bean.Tester;

import servletunit.struts.MockStrutsTestCase;

public class HomeTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/login");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testTesterLogin() {
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("password", "111111");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		//verifyForward("login");
		verifyForwardPath("/page_personal_center.jsp");
		Tester tester  = (Tester)getSession().getAttribute("Tester");
		assertEquals("linyiwei123", tester.getTesterName());
	}

}
