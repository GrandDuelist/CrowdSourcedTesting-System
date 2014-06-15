package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;

import cn.com.crowdsourcedtesting.DAO.JoinTaskDAO;
import cn.com.crowdsourcedtesting.DAO.ProductDAO;
import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.bean.JoinTask;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.other.page.Page;

public class TaskManagement {

	ProductDAO productDAO = new ProductDAO();
	TestTaskDAO testTaskDAO = new TestTaskDAO();
	JoinTaskDAO joinTaskDAO = new JoinTaskDAO();

	public Product addWebProduct(String productName, String icon,
			String webLink, String description) {

		return productDAO
				.addWebProduct(productName, icon, webLink, description);
	}

	public Product addAndroidProduct(String productName, String icon,
			String appLocation, String description) {
		return productDAO.addAndroidProduct(productName, icon, appLocation,
				description);
	}

	public Product addDesktopProduct(String productName, String icon,
			String desktopAddress, String description) {
		return productDAO.addDesktopProduct(productName, icon, desktopAddress,
				description);
	}

	public TestTask addTestTask(Product product, int productType,
			Publisher publisher, Date beginTime, Date endTime,
			double perReward, double wholeCredit) {

		return testTaskDAO.addTestTask(product, productType, publisher,
				beginTime, endTime, perReward, wholeCredit);
	}

	public TestTask[] findUncheckedWebByPage(Page page) {
		return testTaskDAO.findUncheckedWebByPage(page)
				.toArray(new TestTask[0]);
	}

	public int getUncheckedWebTotalRows() {
		return testTaskDAO.getUncheckedWebTotalRows();
	}

	public TestTask[] findUncheckedAndroidByPage(Page page) {
		return testTaskDAO.findUncheckedAndroidByPage(page).toArray(
				new TestTask[0]);
	}

	public int getUncheckedAndroidTotalRows() {
		return testTaskDAO.getUncheckedAndroidTotalRows();
	}

	public TestTask[] findUncheckedDesktopByPage(Page page) {
		return testTaskDAO.findUncheckedDesktopByPage(page).toArray(
				new TestTask[0]);
	}

	public int getUncheckedDesktopTotalRows() {
		return testTaskDAO.getUncheckedDesktopTotalRows();
	}

	public TestTask[] findPublisherWebTestTaskByPage(Page page,
			Publisher publisher) {
		return testTaskDAO.findPublisherWebTestTaskByPage(page, publisher)
				.toArray(new TestTask[0]);
	}

	public int getPublisherWebTotalRows(Publisher publisher) {
		return testTaskDAO.getPublisherWebTotalRows(publisher);
	}

	public TestTask[] findcheckedWebByPage(Page page) {
		return testTaskDAO.findcheckedWebByPage(page).toArray(new TestTask[0]);
	}

	public int getcheckedWebTotalRows() {
		return testTaskDAO.getcheckedWebTotalRows();
	}
	
	public boolean isTesterJoinTask(int testerId, int testTaskId) {
		Tester tester = new Tester();
		tester.setTesterId(testerId);
		TestTask testTask = new TestTask();
		testTask.setTaskId(testTaskId);
		return joinTaskDAO.isExist(tester, testTask);
	}
	
	public JoinTask addJoinTask(int testerId, int testTaskId) {
		Tester tester = new Tester();
		tester.setTesterId(testerId);
		TestTask testTask = new TestTask();
		testTask.setTaskId(testTaskId);
		return joinTaskDAO.addJoinTask(tester, testTask);
	}
}
