package cn.com.crowdsourcedtesting.datawebservices;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

import cn.com.crowdsourcedtesting.bean.BugReport;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@javax.jws.WebService(targetNamespace = "http://datawebservices.crowdsourcedtesting.com.cn/", serviceName = "BugReportManagementService", portName = "BugReportManagementPort")
public class BugReportManagementDelegate {

	cn.com.crowdsourcedtesting.datawebservices.BugReportManagement bugReportManagement = new cn.com.crowdsourcedtesting.datawebservices.BugReportManagement();

	public BugReport findById(
			@WebParam(name = "id") int id) {
		return bugReportManagement.findById(id);
	}

	public void addBugReport(
			@WebParam(name = "BugReport")BugReport instance) {
		bugReportManagement.addBugReport(instance);
	}

	public BugReport[] getBugReportByTask(
			@WebParam(name = "taskID") int taskID) {
		return bugReportManagement.getBugReportByTask(taskID);
	}

}