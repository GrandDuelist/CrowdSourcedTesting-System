package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class PublishTestingTaskTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/entrance");
		addRequestParameter("username", "1014582610@qq.com");
		addRequestParameter("password", "1234");
		addRequestParameter("method", "enter");
		actionPerform();
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
		verifyForward("pubTask");
	}

	@Test
	public final void testTaskManagement() {
		addRequestParameter("method", "taskManagement");
		actionPerform();
		verifyForward("taskManagement");
	}

	@Test
	public final void testPubWeb() {
		addRequestParameter("method", "pubWeb");
		actionPerform();
		verifyForward("pubWeb");
	}

	@Test
	public final void testPubAndroid() {
		addRequestParameter("method", "pubAndroid");
		actionPerform();
		verifyForward("pubAndroid");
	}

	@Test
	public final void testPubDesktop() {
		addRequestParameter("method", "pubDesktop");
		actionPerform();
		verifyForward("pubDesktop");
	}

	@Test
	public final void testWebSubmitFormFail() {
		addRequestParameter("method", "webSubmitForm");
		addRequestParameter("webUrl", "www.baidu.com");
		addRequestParameter("description", "this is a web test");
		actionPerform();
		assertNull(getRequest().getSession().getAttribute("productErrorMessageAttributeName"));
	}

	@Test
	public final void testAndroidSubmitFormFail() {
		addRequestParameter("method", "androidSubmitForm");
		addRequestParameter("appName", "testAndroid");
		addRequestParameter("description", "this is a app test");
		actionPerform();
		assertNull(getRequest().getSession().getAttribute("productErrorMessageAttributeName"));
	}


	@Test
	public final void testDesktopSubmitFormFail() {
		addRequestParameter("method", "desktopSubmitForm");
		addRequestParameter("appName", "testDesktop");
		addRequestParameter("downLoadLink", "www.baidu.com");
		addRequestParameter("description", "this is a desktop test");
		actionPerform();
		assertNull(getRequest().getSession().getAttribute("productErrorMessageAttributeName"));
	}

	@Test
	public final void testPubTaskSuccess() {
		addRequestParameter("method", "pubTaskSuccess");
		actionPerform();
		verifyForwardPath("/publisher_taskpub_success.jsp");
	}

}
