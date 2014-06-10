package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.crowdsourcedtesting.bean.Tester;

import servletunit.struts.MockStrutsTestCase;

public class SecurityTesting extends MockStrutsTestCase {

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
	public final void testTesterLoginSuccess() {
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("password", "111111");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForwardPath("/page_personal_center.jsp");
		Tester tester  = (Tester)getSession().getAttribute("Tester");
		assertEquals("linyiwei123", tester.getTesterName());
	}
	
	@Test
	public final void testTesterLoginFail(){
		String[] passworderror = {"Password Wrong"};
		String[] usernameerror = {"Usrname Not found"};
		
		addRequestParameter("username", "113213123@qq.com");
		addRequestParameter("password", "111111");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForward("login");
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("password", "测试密码");
		addRequestParameter("method", "testerLogin");
		//verifyActionErrors(passworderror);
		actionPerform();
		verifyForward("login");
		addRequestParameter("username", "1306922411");
		addRequestParameter("password", "测试密码");
		addRequestParameter("method", "testerLogin");
		//verifyActionErrors(usernameerror);
		actionPerform();
		verifyForward("login");
		addRequestParameter("password", "测试密码");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForward("login");
		//verifyActionErrors(usernameerror);
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForward("login");
		//verifyActionErrors(usernameerror);
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForward("login");
		//verifyActionErrors(usernameerror);
		addRequestParameter("username", "");
		addRequestParameter("password", "");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		verifyForward("login");
		//verifyActionErrors(usernameerror);
	}

	/*@Test
	public final void testTesterLogoutSuccess() {
		addRequestParameter("username", "1306922411@qq.com");
		addRequestParameter("password", "111111");
		addRequestParameter("method", "testerLogin");
		actionPerform();
		assertNotNull(getSession().getAttribute("UserType"));
		verifyForwardPath("/page_personal_center.jsp");
		addRequestParameter("method", "testerLogout");
		actionPerform();
		Tester tester  = (Tester)getSession().getAttribute("Tester");
		assertEquals("linyiwei123", tester.getTesterName());
		verifyForward("home");
	}
	
	@Test
	public final void testManageSuccess() {
		setRequestPathInfo("/manage");
		addRequestParameter("username", "SHAWN@126.COM");
		addRequestParameter("password", "123456");
		addRequestParameter("method", "manage");
		actionPerform();
		verifyForward("home");
		assertNotNull(getSession().getAttribute("UserType"));
	}

	@Test
	public final void testManageFail() {
		setRequestPathInfo("/manage");
		addRequestParameter("username", "SHAWN@126.COM");
		addRequestParameter("password", "123213213");
		addRequestParameter("method", "manage");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getSession().getAttribute("UserType"));
		assertEquals("fail", getSession().getAttribute("a_login"));
	}
	
	@Test
	public final void testEnterSuccess() {
		setRequestPathInfo("/entrance");
		addRequestParameter("username", "1014582610@qq.com");
		addRequestParameter("password", "1234");
		addRequestParameter("method", "enter");
		actionPerform();
		verifyForward("manage");
		assertNotNull(getSession().getAttribute("UserType"));
	}

	@Test
	public final void testEnterFail(){
		setRequestPathInfo("/entrance");
		addRequestParameter("username", "1014582610@qq.com");
		addRequestParameter("password", "123213213");
		addRequestParameter("method", "enter");
		actionPerform();
		verifyForward("login");
		assertNull(getSession().getAttribute("UserType"));
		assertEquals("fail", getSession().getAttribute("p_login"));
	}

	@Before
	public final void testAdminLogin(){
		setRequestPathInfo("/manage");
		addRequestParameter("username", "SHAWN@126.COM");
		addRequestParameter("password", "123213213");
		addRequestParameter("method", "manage");
		actionPerform();
		
	}
	
	@Test
	public final void testTesterSendCodeSuccess() {
		setRequestPathInfo("/findpassword");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("method", "testerSendCode");
		actionPerform();
		verifyForward("findpassword");
		setRequestPathInfo("/findpassword");
		addRequestParameter("password", "112233");
		addRequestParameter("method", "testerFindPassword");
		actionPerform();
		verifyForward("success");
	}

	@Test
	public final void testTesterSendCodeFail() {
		setRequestPathInfo("/findpassword");
		addRequestParameter("email", "101458");
		addRequestParameter("method", "testerSendCode");
		actionPerform();
		verifyForward("findpassword");
		setRequestPathInfo("/findpassword");
		addRequestParameter("email", "");
		addRequestParameter("method", "testerSendCode");
		actionPerform();
		verifyForward("findpassword");
	}
	

	@Test
	public final void testTesterChangeInformationSuccess() {
		setRequestPathInfo("/security");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("password", "111");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/security");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("name", "linyiwei");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/security");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("password", "123");
		addRequestParameter("name", "yiwei");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
	}

	@Test
	public final void testTesterChangeInformationFail() {
		setRequestPathInfo("/security");
		addRequestParameter("email", "101458asdf2610@qq.com");
		addRequestParameter("password", "12321");
		addRequestParameter("name", "linyiwei");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/security");
		addRequestParameter("email", "101458asdf26");
		addRequestParameter("password", "");
		addRequestParameter("name", "");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/security");
		addRequestParameter("email", "");
		addRequestParameter("password", "");
		addRequestParameter("name", "");
		addRequestParameter("method", "testerChangeInformation");
		actionPerform();
		verifyForward("success");
	}*/
}
