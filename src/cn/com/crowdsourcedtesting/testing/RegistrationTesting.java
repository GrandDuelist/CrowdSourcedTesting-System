package cn.com.crowdsourcedtesting.testing;


import java.io.File;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;



public class RegistrationTesting extends MockStrutsTestCase {

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
	public final void testTesterRegistrationActiveSuccess() {
		setRequestPathInfo("/registrationTester");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("method", "testerRegistrationActivate");
		actionPerform();
		String code = (String) getRequest().getAttribute("randomcode");
		assertNotNull(code);
		verifyForward("activate");
	}

	@Test
	public final void testTesterRegistrationActiveFail() {
		setRequestPathInfo("/registrationTester");
		addRequestParameter("email", "");
		addRequestParameter("method", "testerRegistrationActivate");
		try {
			actionPerform();
			String code = (String) getRequest().getAttribute("randomcode");
			assertNotNull(code);
			verifyForward("activate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setRequestPathInfo("/registrationTester");
		addRequestParameter("email", "1014582610");
		addRequestParameter("method", "testerRegistrationActivate");
		try {
			actionPerform();
			String code = (String) getRequest().getAttribute("randomcode");
			assertNotNull(code);
			verifyForward("activate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public final void testTesterRegistrationSuccess(){
		setRequestPathInfo("/registrationTester");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("name", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("gender", "0");
		addRequestParameter("credit", "0");
		actionPerform();
		verifyForward("success");
	}
	
	@Test
	public final void testTesterRegistrationFail(){
		setRequestPathInfo("/registrationTester");
		//addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("name", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("credit", "0");
		actionPerform();
		verifyForward("success");
	}
	
	@Test
	public final void testPublisherRegistrationActiveSuccess() {
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("email", "1014582610@qq.com");
		addRequestParameter("method", "publisherRegistrationActive");
		actionPerform();
		String code = (String) getRequest().getAttribute("randomcode");
		assertNotNull(code);
		verifyForward("activate");
	}
	
	@Test
	public final void testPublisherRegistrationActiveFail() {
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("email", "");
		addRequestParameter("method", "publisherRegistrationActive");
		try {
			actionPerform();
			String code = (String) getRequest().getAttribute("randomcode");
			assertNotNull(code);
			verifyForward("activate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("email", "1014582610");
		addRequestParameter("method", "publisherRegistrationActive");
		try {
			actionPerform();
			String code = (String) getRequest().getAttribute("randomcode");
			assertNotNull(code);
			verifyForward("activate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public final void testPublisherRegistrationSuccess() {
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("logEail", "1306922411@qq.com");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("credit", "0.0");
		addRequestParameter("authority", "0");
		addRequestParameter("type", "0");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
	}
	
	@Test
	public final void testPublisherRegistrationFail() {
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("logEail", "130692241");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("credit", "0.0");
		addRequestParameter("authority", "0");
		addRequestParameter("type", "0");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("logEail", "1306922411@qq.com");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "1152724");
		//addRequestParameter("credit", "0.0");
		addRequestParameter("authority", "0");
		addRequestParameter("type", "0");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("logEail", "1306922411@qq.com");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("credit", "0");
		addRequestParameter("authority", "0");
		addRequestParameter("type", "0");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/registrationPublisher");
		addRequestParameter("logEail", "1306922411@qq.com");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "1152724");
		addRequestParameter("credit", "0.0");
		addRequestParameter("authority", "test");
		addRequestParameter("type", "test");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
		setRequestPathInfo("/registrationPublisher");
		//addRequestParameter("logEail", "1306922411@qq.com");
		addRequestParameter("publisherName", "linyiwei");
		addRequestParameter("password", "21312321312312312321312313123123213123131313");
		addRequestParameter("credit", "0.0");
		//addRequestParameter("authority", "0");
		addRequestParameter("type", "0");
		addRequestParameter("method", "publisherRegistratione");
		actionPerform();
		verifyForward("success");
	}
}
