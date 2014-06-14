package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;

import cn.com.crowdsourcedtesting.DAO.ProductDAO;
import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.other.page.Page;

public class TaskManagement {

	ProductDAO productDAO = new ProductDAO();
	TestTaskDAO testTaskDAO = new TestTaskDAO();

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
		return (TestTask[]) testTaskDAO.findUncheckedWebByPage(page).toArray();
	}

	public int getUncheckedWebTotalRows() {
		return testTaskDAO.getUncheckedWebTotalRows();
	}

	public TestTask[] findUncheckedAndroidByPage(Page page) {
		return (TestTask[]) testTaskDAO.findUncheckedAndroidByPage(page)
				.toArray();
	}

	public int getUncheckedAndroidTotalRows() {
		return testTaskDAO.getUncheckedAndroidTotalRows();
	}

	public TestTask[] findUncheckedDesktopByPage(Page page) {
		return (TestTask[]) testTaskDAO.findUncheckedDesktopByPage(page)
				.toArray();
	}

	public int getUncheckedDesktopTotalRows() {
		return testTaskDAO.getUncheckedDesktopTotalRows();
	}

	public TestTask[] findPublisherWebTestTaskByPage(Page page,
			Publisher publisher) {
		return (TestTask[]) testTaskDAO.findPublisherWebTestTaskByPage(page,
				publisher).toArray();
	}

	public int getPublisherWebTotalRows(Publisher publisher) {
		return testTaskDAO.getPublisherWebTotalRows(publisher);
	}

	public TestTask[] findcheckedWebByPage(Page page) {
		return (TestTask[]) testTaskDAO.findcheckedWebByPage(page).toArray();
	}

	public int getcheckedWebTotalRows() {
		return testTaskDAO.getcheckedWebTotalRows();
	}
}
