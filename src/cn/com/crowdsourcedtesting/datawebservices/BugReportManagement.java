package cn.com.crowdsourcedtesting.datawebservices;

import java.util.List;

import cn.com.crowdsourcedtesting.DAO.BugReportDAO;
import cn.com.crowdsourcedtesting.bean.BugReport;
import cn.com.crowdsourcedtesting.bean.TestTask;

public class BugReportManagement {

	BugReportDAO bugReportDao=new BugReportDAO();
	
	public BugReport findById(int id){
		return bugReportDao.findById(id);
	}
	public void addBugReport(BugReport instance){
		bugReportDao.addBugReport(instance);
	}
	public BugReport[] getBugReportByTask(int taskID){
		TestTask testTask=new TestTask();
		testTask.setTaskId(taskID);
		List<BugReport> list = bugReportDao.getBugReportByTask(testTask);
		return (BugReport[]) list.toArray();
	}
}
