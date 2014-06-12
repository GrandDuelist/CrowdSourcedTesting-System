package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class EditTaskWithoutPublisherTesting extends MockStrutsTestCase {

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
	public final void testSubmitCloseFormWithoutPublisher() {
		setRequestPathInfo("/editTask");
		addRequestParameter("taskID", "1");
		addRequestParameter("method", "submitCloseForm");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

}
