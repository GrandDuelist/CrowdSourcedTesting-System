package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class TestTaskDetailViewTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/login");
		addRequestParameter("username", "Shawn100@qq.com");
		addRequestParameter("password", "123456");
		addRequestParameter("method", "testerLogin");
		actionPerform();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testDetailViewSuccess() {
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "detailView");
		addRequestParameter("taskID", "28");
		actionPerform();
		assertEquals("true", getRequest().getSession().getAttribute("HasJoinedTask"));
	}

	
	//id = null 和 task = null 会发生崩溃
	@Test
	public final void testDetailViewFail() {
		//id = null
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "detailView");
		actionPerform();
		verifyForwardPath("/page_list.jsp");
		//task = null
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "detailView");
		addRequestParameter("taskID", "2");
		actionPerform();
		verifyForwardPath("/page_list.jsp");
		//tester not exist
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "detailView");
		addRequestParameter("taskID", "37");
		actionPerform();
		assertEquals("false", getRequest().getSession().getAttribute("HasJoinedTask"));
	}
	
	@Test
	public final void testJoinTaskSuccess() {
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "joinTask");
		addRequestParameter("taskID", "29");
		actionPerform();
	}

	//id = null 和 task = null 会发生崩溃
	@Test
	public final void testJoinTaskFail() {
		//id = null
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "joinTask");
		actionPerform();
		//task = null
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "9");
		actionPerform();
		//tester exist
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "joinTask");
		addRequestParameter("taskID", "28");
		actionPerform();
	}
	

	@Test
	public final void testBugReportPageSuccess() {
		setRequestPathInfo("/testTaskViewList");
		addRequestParameter("method", "bugReportPage");
		addRequestParameter("taskID", "28");
		actionPerform();
		verifyForward("bugReportPage");
	}
	
	//id = null 和 task = null 会发生崩溃
	@Test
	public final void testBugReportPageFail() {
		//id = null
		setRequestPathInfo("/testTaskViewList");
		addRequestParameter("method", "bugReportPage");
		actionPerform();
		verifyForwardPath("/page_list.jsp");
		//task = null
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "bugReportPage");
		addRequestParameter("taskID", "8");
		actionPerform();
		verifyForwardPath("/page_list.jsp");
	}
	
	//picture null 崩溃
	@Test
	public final void testBugReportSubmitFail() {
		setRequestPathInfo("/testTaskDetailView");
		addRequestParameter("method", "bugReportSubmit");
		addRequestParameter("taskID", "28");
		addRequestParameter("bugTitle", "bug提交");
		addRequestParameter("bugType", "0");
		addRequestParameter("bugOperation", "test operation");
		addRequestParameter("bugResult", "test result");
		actionPerform();
		verifyForward("taskDetailPage");
	}
}
