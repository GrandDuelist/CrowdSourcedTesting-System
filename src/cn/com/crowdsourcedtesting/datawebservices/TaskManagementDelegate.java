package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

import cn.com.crowdsourcedtesting.bean.JoinTask;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.TestTask;
import cn.com.other.page.Page;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@javax.jws.WebService(targetNamespace = "http://datawebservices.crowdsourcedtesting.com.cn/", serviceName = "TaskManagementService", portName = "TaskManagementPort")
public class TaskManagementDelegate {

	cn.com.crowdsourcedtesting.datawebservices.TaskManagement taskManagement = new cn.com.crowdsourcedtesting.datawebservices.TaskManagement();

	// @WebMethod(operationName = "addWebProduct")
	public Product addWebProduct(
			@WebParam(name = "productName") String productName,
			@WebParam(name = "icon") String icon,
			@WebParam(name = "webLink") String webLink,
			@WebParam(name = "description") String description) {
		return taskManagement.addWebProduct(productName, icon, webLink,
				description);
	}

	public Product addAndroidProduct(
			@WebParam(name = "productName") String productName,
			@WebParam(name = "icon") String icon,
			@WebParam(name = "appLocation") String appLocation,
			@WebParam(name = "description") String description) {
		return taskManagement.addAndroidProduct(productName, icon, appLocation,
				description);
	}

	public Product addDesktopProduct(
			@WebParam(name = "productName") String productName,
			@WebParam(name = "icon") String icon,
			@WebParam(name = "desktopAddress") String desktopAddress,
			@WebParam(name = "description") String description) {
		return taskManagement.addDesktopProduct(productName, icon,
				desktopAddress, description);
	}

	public TestTask addTestTask(@WebParam(name = "product") Product product,
			@WebParam(name = "productType") int productType,
			@WebParam(name = "publisher") Publisher publisher,
			@WebParam(name = "beginTime") Date beginTime,
			@WebParam(name = "endTime") Date endTime,
			@WebParam(name = "perReward") double perReward,
			@WebParam(name = "wholeCredit") double wholeCredit) {
		return taskManagement.addTestTask(product, productType, publisher,
				beginTime, endTime, perReward, wholeCredit);
	}

	public TestTask[] findUncheckedWebByPage(@WebParam(name = "page") Page page) {
		return taskManagement.findUncheckedWebByPage(page);
	}

	public int getUncheckedWebTotalRows() {
		return taskManagement.getUncheckedWebTotalRows();
	}

	public TestTask[] findUncheckedAndroidByPage(
			@WebParam(name = "page") Page page) {
		return taskManagement.findUncheckedAndroidByPage(page);
	}

	public int getUncheckedAndroidTotalRows() {
		return taskManagement.getUncheckedAndroidTotalRows();
	}

	public TestTask[] findUncheckedDesktopByPage(
			@WebParam(name = "page") Page page) {
		return taskManagement.findUncheckedDesktopByPage(page);
	}

	public int getUncheckedDesktopTotalRows() {
		return taskManagement.getUncheckedDesktopTotalRows();
	}

	public TestTask[] findPublisherWebTestTaskByPage(
			@WebParam(name = "page") Page page,
			@WebParam(name = "publisher") Publisher publisher) {
		return taskManagement.findPublisherWebTestTaskByPage(page, publisher);
	}

	public int getPublisherWebTotalRows(
			@WebParam(name = "publisher") Publisher publisher) {
		return taskManagement.getPublisherWebTotalRows(publisher);
	}

	public TestTask[] findcheckedWebByPage(@WebParam(name = "page") Page page) {
		return taskManagement.findcheckedWebByPage(page);
	}

	public int getcheckedWebTotalRows() {
		return taskManagement.getcheckedWebTotalRows();
	}

	public boolean isTesterJoinTask(@WebParam(name = "testerId") int testerId,
			@WebParam(name = "testTaskId") int testTaskId) {
		return taskManagement.isTesterJoinTask(testerId, testTaskId);
	}

	public JoinTask addJoinTask(@WebParam(name = "testerId") int testerId,
			@WebParam(name = "testTaskId") int testTaskId) {
		return taskManagement.addJoinTask(testerId, testTaskId);
	}

}