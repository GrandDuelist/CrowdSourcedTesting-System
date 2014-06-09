package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;
import javax.jws.WebParam;
import cn.com.crowdsourcedtesting.DAO.ProductDAO;
import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.other.page.Page;

@javax.jws.WebService(targetNamespace = "http://datawebservices.crowdsourcedtesting.com.cn/", serviceName = "TaskManagementService", portName = "TaskManagementPort")
public class TaskManagementDelegate {

	cn.com.crowdsourcedtesting.datawebservices.TaskManagement taskManagement = new cn.com.crowdsourcedtesting.datawebservices.TaskManagement();

	public Product addWebProduct(String productName, String icon,
			String webLink, String description) {
		return taskManagement.addWebProduct(productName, icon, webLink,
				description);
	}

	public Product addAndroidProduct(String productName, String icon,
			String appLocation, String description) {
		return taskManagement.addAndroidProduct(productName, icon, appLocation,
				description);
	}

	public Product addDesktopProduct(String productName, String icon,
			String desktopAddress, String description) {
		return taskManagement.addDesktopProduct(productName, icon,
				desktopAddress, description);
	}

	public TestTask addTestTask(Product product, int productType,
			Publisher publisher, Date beginTime, Date endTime,
			double perReward, double wholeCredit) {
		return taskManagement.addTestTask(product, productType, publisher,
				beginTime, endTime, perReward, wholeCredit);
	}

	public TestTask[] findUncheckedWebByPage(Page page) {
		return taskManagement.findUncheckedWebByPage(page);
	}

	public int getUncheckedWebTotalRows() {
		return taskManagement.getUncheckedWebTotalRows();
	}

	public TestTask[] findUncheckedAndroidByPage(Page page) {
		return taskManagement.findUncheckedAndroidByPage(page);
	}

	public int getUncheckedAndroidTotalRows() {
		return taskManagement.getUncheckedAndroidTotalRows();
	}

	public TestTask[] findUncheckedDesktopByPage(Page page) {
		return taskManagement.findUncheckedDesktopByPage(page);
	}

	public int getUncheckedDesktopTotalRows() {
		return taskManagement.getUncheckedDesktopTotalRows();
	}

	public TestTask[] findPublisherWebTestTaskByPage(Page page,
			Publisher publisher) {
		return taskManagement.findPublisherWebTestTaskByPage(page, publisher);
	}

	public int getPublisherWebTotalRows(Publisher publisher) {
		return taskManagement.getPublisherWebTotalRows(publisher);
	}

	public TestTask[] findcheckedWebByPage(Page page) {
		return taskManagement.findcheckedWebByPage(page);
	}

	public int getcheckedWebTotalRows() {
		return taskManagement.getcheckedWebTotalRows();
	}

}