package cn.com.crowdsourcedtesting.testing;


import java.io.File;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class RecruitmentTesting extends MockStrutsTestCase {

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
	public final void testSelectPageSuccess() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("pagenow", "1");
		addRequestParameter("method", "selectPage");
		actionPerform();
		assertEquals("legal", getRequest().getAttribute("isLegal"));
		verifyForward("hirelist");
	}

	@Test
	public final void testSelectPageFail(){
		setRequestPathInfo("/recruitment");
		addRequestParameter("pagenow", "1123");
		addRequestParameter("method", "selectPage");
		actionPerform();
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		verifyForward("hirelist");
		addRequestParameter("pagenow", "test");
		addRequestParameter("method", "selectPage");
		actionPerform();
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		verifyForward("hirelist");
	}
	
	@Test
	public final void testSelectAllRecruitment() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("method", "selectAllRecruitment");
		actionPerform();
		verifyForward("hirelist");
		assertNotNull(getRequest().getAttribute("page"));
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
	}

	@Test
	public final void testSelectRecentRecruitment() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("method", "selectRecentRecruitment");
		actionPerform();
		verifyForward("index");
		assertEquals("success", getRequest().getAttribute("flag"));
		assertNotNull(getRequest().getAttribute("page"));
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
	}

	@Test
	public final void testSelectRecruitment() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("method", "selectRecruitment");
		addRequestParameter("id", "21");
		actionPerform();
		verifyForward("hireitem");
		assertNotNull(getRequest().getAttribute("hireitem"));
	}

	@Test
	public final void testAddNewRecruitmentSuccess() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(114, 6, 6);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(114, 8, 8);
		setRequestPathInfo("/recruitment");
		addRequestParameter("title", "招募信息测试");
		addRequestParameter("online", "0");
		addRequestParameter("place", "上海");
		addRequestParameter("startdate", calendar.toString());
		addRequestParameter("enddate", calendar2.toString());
		addRequestParameter("company", "众测公司");
		addRequestParameter("brief", "招募测试人员");
		addRequestParameter("content", "待遇优厚");
		addRequestParameter("method", "addNewRecruitment");
		actionPerform();
		verifyForwardPath("/publisher_hirelist.jsp");
	}

	@Test
	public final void testAddNewRecruitmentFail() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("place", "上海");
		addRequestParameter("company", "众测公司");
		addRequestParameter("brief", "招募测试人员");
		addRequestParameter("content", "待遇优厚");
		addRequestParameter("method", "addNewRecruitment");
		actionPerform();
		verifyForwardPath("/publisher_hirelist.jsp");
	}
	
	@Test
	public final void testReviceRecruitmentSuccess() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("id", "21");
		addRequestParameter("title", "招募信息测试");
		addRequestParameter("online", "0");
		addRequestParameter("place", "上海");
		addRequestParameter("company", "众测公司");
		addRequestParameter("brief", "招募测试人员");
		addRequestParameter("content", "待遇优厚");
		addRequestParameter("method", "reviceRecruitment");
		actionPerform();
		verifyForwardPath("/publisher_hirelist.jsp");
		setRequestPathInfo("/recruitment");
		addRequestParameter("id", "1");
		addRequestParameter("title", "招募信息测试");
		addRequestParameter("online", "0");
		addRequestParameter("place", "上海");
		addRequestParameter("company", "众测公司");
		addRequestParameter("brief", "招募测试人员");
		addRequestParameter("content", "待遇优厚");
		addRequestParameter("method", "reviceRecruitment");
		actionPerform();
		verifyForwardPath("/publisher_hirelist.jsp");
	}

	
	@Test
	public final void testReviceRecruitmentFail() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("id", "1");
		addRequestParameter("title", "招募信息测试");
		addRequestParameter("online", "0");
		addRequestParameter("place", "上海");
		addRequestParameter("company", "众测公司");
		addRequestParameter("brief", "招募测试人员");
		addRequestParameter("content", "待遇优厚");
		addRequestParameter("method", "reviceRecruitment");
		actionPerform();
		verifyForwardPath("/publisher_hirelist.jsp");
	}
	
	@Test
	public final void testGotoBackStage() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("method", "gotoBackStage");
		actionPerform();
		verifyForward("backstage");
	}

	@Test
	public final void testGotoPub() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("method", "gotoPub");
		actionPerform();
		verifyForward("additem");
		assertEquals("legal", getRequest().getAttribute("isLegal"));
	}

	@Test
	public final void testGotoItemSuccess() {
		setRequestPathInfo("/recruitment");
		addRequestParameter("id", "21");
		addRequestParameter("method", "gotoItem");
		actionPerform();
		verifyForward("edititem");
	}
}
