package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class PublishTestingTaskWithoutPublisherTesting extends
		MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/publishTestingTask");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testGoToPublish() {
		addRequestParameter("method", "goToPublish");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testTaskManagement() {
		addRequestParameter("method", "taskManagement");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testPubWeb() {
		addRequestParameter("method", "pubWeb");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testPubAndroid() {
		addRequestParameter("method", "pubAndroid");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testPubDesktop() {
		addRequestParameter("method", "pubDesktop");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testWebSubmitForm() {
		addRequestParameter("method", "webSubmitForm");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testAndroidSubmitForm() {
		addRequestParameter("method", "androidSubmitForm");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}

	@Test
	public final void testDesktopSubmitForm() {
		addRequestParameter("method", "desktopSubmitForm");
		actionPerform();
		verifyForwardPath("entrance.do?method=goToLogin");
	}


}
