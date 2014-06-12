package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class InformationWithoutAdminTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/information");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testManagePublisherList() {
		addRequestParameter("method", "managePublisherList");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "pageNum");
		actionPerform();
		verifyForward("adminLogin");
	}

	@Test
	public final void testManageCompanyList() {
		addRequestParameter("method", "manageCompanyList");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "previousPage");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testManagePersonList() {
		addRequestParameter("method", "managePersonList");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "nextPage");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testManageTesterDetail() {
		addRequestParameter("method", "manageTesterDetail");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "nextPage");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testManagePublisherDetail() {
		addRequestParameter("method", "managePublisherDetail");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "nextPage");
		addRequestParameter("publisherType", "1");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testMaintainPublisherSuccess() {
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainPublisher");
		addRequestParameter("id", "47");
		addRequestParameter("username", "linyiwei");
		addRequestParameter("status", "1");
		addRequestParameter("license", "营业执照00XX11");
		addRequestParameter("company", "网易公司");
		addRequestParameter("credit", "10000");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testMaintainPublisherFail() {
		//id == null 
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainPublisher");
		addRequestParameter("username", "linyiwei");
		addRequestParameter("status", "1");
		addRequestParameter("license", "营业执照00XX11");
		addRequestParameter("company", "网易公司");
		addRequestParameter("credit", "10000");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
		//id == wrong
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainPublisher");
		addRequestParameter("id", "1");
		addRequestParameter("username", "linyiwei");
		addRequestParameter("status", "1");
		addRequestParameter("license", "营业执照00XX11");
		addRequestParameter("company", "网易公司");
		addRequestParameter("credit", "10000");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
		//username = null
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainPublisher");
		addRequestParameter("id", "47");
		addRequestParameter("status", "1");
		addRequestParameter("license", "营业执照00XX11");
		addRequestParameter("company", "网易公司");
		addRequestParameter("credit", "10000");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}
	
	@Test
	public final void testMaintainTesterSuccess() {
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainTester");
		addRequestParameter("id", "29");
		addRequestParameter("username", "linyiwei");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

	@Test
	public final void testMaintainTesterFail() {
		//id = null
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainTester");
		addRequestParameter("username", "linyiwei");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
		//id = wrong
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainTester");
		addRequestParameter("id", "1");
		addRequestParameter("username", "yiwei");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
		//usrname = null 
		setRequestPathInfo("/information");
		addRequestParameter("method", "maintainTester");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}
	
	@Test
	public final void testManageTesterList() {
		setRequestPathInfo("/information");
		addRequestParameter("method", "manageTesterList");
		addRequestParameter("id", "1");
		addRequestParameter("page", "3");
		addRequestParameter("subType", "nextPage");
		actionPerform();
		verifyForward("adminLogin");
		assertNull(getRequest().getAttribute("islegal"));
	}

}
