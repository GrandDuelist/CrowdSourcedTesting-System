package cn.com.crowdsourcedtesting.testing;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servletunit.struts.MockStrutsTestCase;

public class GiftTesting extends MockStrutsTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setContextDirectory(new File("WebRoot"));
		setRequestPathInfo("/login");
		addRequestParameter("username", "ezhihan@gmail.com");
		addRequestParameter("password", "1234");
		addRequestParameter("method", "testerLogin");
		actionPerform();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testSelectGiftSuccess() {
		setRequestPathInfo("/gifts");
		addRequestParameter("giftId", "3");
		addRequestParameter("method", "selectGift");
		actionPerform();
		assertNotNull(getRequest().getAttribute("giftitem"));
		verifyForward("giftitem");
	}

	@Test
	public final void testSelectGiftFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("giftId", "1");
		addRequestParameter("method", "selectGift");
		actionPerform();
		assertNull(getRequest().getAttribute("giftitem"));
		verifyForward("giftitem");
	}
	
	@Test
	public final void testSelectRecentGift() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "selectRecentGift");
		actionPerform();
		assertNotNull(getRequest().getAttribute("gifts"));
		verifyForward("allgifts");
	}

	@Test
	public final void testSelectPageSuccess() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "selectPage");
		addRequestParameter("pagenow", "1");
		actionPerform();
		assertNotNull(getRequest().getAttribute("gifts"));
		verifyForward("allgifts");
	}

	@Test
	public final void testSelectPageFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "selectPage");
		addRequestParameter("pagenow", "111");
		actionPerform();
		assertNull(getRequest().getAttribute("gifts"));
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		verifyForward("allgifts");
	}
	
	@Test
	public final void testSelectAllGifts() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "selectAllGifts");
		actionPerform();
		assertNotNull(getRequest().getAttribute("gifts"));
		verifyForward("allgifts");
	}

	@Test
	public final void testSelectAvailableGifts() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "selectAvailableGifts");
		actionPerform();
		assertNotNull(getRequest().getAttribute("gifts"));
		verifyForward("allgifts");
	}

	@Test
	public final void testSelectSimilarGiftsSuccess() {
		setRequestPathInfo("/gifts");
		addRequestParameter("searchinput", "礼品2");
		addRequestParameter("method", "selectSimilarGifts");
		actionPerform();
		assertNotNull(getRequest().getAttribute("gifts"));
		verifyForward("allgifts");
	}
	
	@Test
	public final void testSelectSimilarGiftsFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("searchinput", "不存在测试");
		addRequestParameter("method", "selectSimilarGifts");
		actionPerform();
		assertNull(getRequest().getAttribute("gifts"));
		assertEquals("illegal", getRequest().getAttribute("isLegal"));
		verifyForward("allgifts");
	}


	@Test
	public final void testGetGiftSuccess() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "getGift");
		addRequestParameter("giftId", "2");
		actionPerform();
		verifyForward("changegift");
	}

	@Test
	public final void testGetGiftFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "getGift");
		addRequestParameter("giftId", "200");
		actionPerform();
		verifyForward("changegiftfailed");
	}
	
	@Test
	public final void testChangeGiftSuccess() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "changeGift");
		addRequestParameter("giftId", "2");
		addRequestParameter("credit", "100");
		addRequestParameter("address", "同济大学");
		addRequestParameter("receiver", "测试用户");
		addRequestParameter("zipcode", "201803");
		addRequestParameter("mobile", "188175123");
		actionPerform();
		verifyForward("changegiftsuccess");
	}

	@Test
	public final void testChangeGiftFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "changeGift");
		addRequestParameter("giftId", "200");
		addRequestParameter("credit", "100");
		addRequestParameter("address", "同济大学");
		addRequestParameter("receiver", "测试用户");
		addRequestParameter("zipcode", "201803");
		addRequestParameter("mobile", "188175123");
		actionPerform();
		verifyForward("changegiftfailed");
	}
	
	@Test
	public final void testChangeGiftListFail() {
		setRequestPathInfo("/gifts");
		addRequestParameter("method", "changeGiftList");
		actionPerform();
		verifyForward("adminLogin");
	}

}
