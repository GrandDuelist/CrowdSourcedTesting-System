package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class BugReportManagementTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/entrance");
		addRequestParameter("username", "SHAWN@GMAIL.COM");
		addRequestParameter("password", "123456");
		addRequestParameter("method", "enter");
		actionPerform();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	//noBugReport界面跳转问题
	@Test
	public final void testBugReportList() 
	{
		// taskid = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "bugReportList");
		actionPerform();
		verifyForwardPath("taskList.do");
		//task = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "bugReportList");
		addRequestParameter("taskId", "2");
		actionPerform();
		verifyForwardPath("taskList.do");
		//bugreport = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "bugReportList");
		addRequestParameter("taskId", "33");
		actionPerform();
		verifyForwardPath("taskList.do");
		//bugreportid = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "bugReportList");
		addRequestParameter("taskId", "28");
		actionPerform();
		assertNull(getRequest().getAttribute("BugReportDetail"));
		//success
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "bugReportList");
		addRequestParameter("taskId", "28");
		addRequestParameter("bugReportId", "8");
		actionPerform();
		assertNotNull(getRequest().getAttribute("BugReportDetail"));
	}

	@Test
	public final void testSelectBugReport() {
		//ensure = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("bugReportId", "8");
		actionPerform();
		verifyForwardPath("taskList.do");
		//ensure = ""
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "");
		addRequestParameter("bugReportId", "8");
		actionPerform();
		verifyForwardPath("taskList.do");
		//bugid = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "");
		actionPerform();
		verifyForwardPath("taskList.do");
		//bugreport = null
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "true");
		addRequestParameter("bugReportId", "1");
		actionPerform();
		verifyForwardPath("taskList.do");
		//ensure = false 
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "false");
		addRequestParameter("bugReportId", "8");
		actionPerform();
		//ensure = true
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "true");
		addRequestParameter("bugReportId", "9");
		actionPerform();
		//ensure = other
		setRequestPathInfo("/bugReportManagement");
		addRequestParameter("method", "selectBugReport");
		addRequestParameter("ensure", "other");
		addRequestParameter("bugReportId", "8");
		actionPerform();
		verifyForwardPath("taskList.do");
	}

}
