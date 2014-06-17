package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class EditTaskTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/entrance");
		addRequestParameter("username", "1014582610@qq.com");
		addRequestParameter("password", "1234");
		addRequestParameter("method", "enter");
		actionPerform();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public final void testSubmitCloseFormSuccess() {
		setRequestPathInfo("/editTask");
		addRequestParameter("taskID", "1");
		addRequestParameter("method", "submitCloseForm");
		actionPerform();
		verifyForward("taskCloseForm");
	}

	@Test
	public final void testSubmitCloseFormFail() {
		setRequestPathInfo("/editTask");
		addRequestParameter("method", "submitCloseForm");
		actionPerform();
		verifyForwardPath("taskList.do");
	}
	
	@Test
	public final void testCloseMessage() {
		setRequestPathInfo("/editTask");
		addRequestParameter("method", "closeMessage");
		actionPerform();
		verifyForwardPath("taskList.do");
	}

}
