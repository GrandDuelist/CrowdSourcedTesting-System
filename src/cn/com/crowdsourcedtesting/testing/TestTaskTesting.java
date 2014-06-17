package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class TestTaskTesting extends MockStrutsTestCase {

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

	
	//未添加用户判断的语句，容易崩溃 
	@Test
	public final void testAddNewCommentSuccess() {
		setRequestPathInfo("/comment");
		addRequestParameter("method", "addNewComment");
		addRequestParameter("taskId", "38");
		addRequestParameter("comment", "评论测试");
		actionPerform();
		verifyForward("allcomment");
	}

	//未添加任务判断的语句，容易崩溃
	@Test
	public final void testAddNewCommentFail() {
		setRequestPathInfo("/comment");
		addRequestParameter("method", "addNewComment");
		addRequestParameter("taskId", "1");
		addRequestParameter("comment", "评论测试");
		actionPerform();
		verifyForward("allcomment");
	}
	
	@Test
	public final void testCheckWebList() {
		setRequestPathInfo("/checkTestTaskList");
		addRequestParameter("method", "checkWebList");
		addRequestParameter("page", "2");
		addRequestParameter("subType", "nextPage");
		actionPerform();
		verifyForward("list");
	}

	@Test
	public final void testCheckCommentSuccess() {
		setRequestPathInfo("/comment");
		addRequestParameter("method", "checkComment");
		addRequestParameter("taskId", "38");
		actionPerform();
		assertEquals("legal", getRequest().getAttribute("isLegal"));
		verifyForward("allcomment");
	}

	
	//未添加任务判断的语句，容易崩溃
	@Test
	public final void testCheckCommentFail() {
		//id = wrong
		setRequestPathInfo("/comment");
		addRequestParameter("method", "checkComment");
		addRequestParameter("taskId", "1");
		actionPerform();
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		assertNull(getRequest().getAttribute("comments"));
		//comment size = null
		setRequestPathInfo("/checkTestTaskList");
		addRequestParameter("method", "checkComment");
		addRequestParameter("taskId", "37");
		actionPerform();
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		assertNull(getRequest().getAttribute("comments"));
	}

	@Test
	public final void testCheckConfirmWithoutAdmin() {
		setRequestPathInfo("/checkRegisterDetail");
		addRequestParameter("method", "checkConfirm");
		actionPerform();
		verifyForward("adminLogin");
	}

}
