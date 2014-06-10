package cn.com.crowdsourcedtesting.datawebservices;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@javax.jws.WebService(targetNamespace = "http://datawebservices.crowdsourcedtesting.com.cn/", serviceName = "UserManagementService", portName = "UserManagementPort")
public class UserManagementDelegate {
	
	cn.com.crowdsourcedtesting.datawebservices.UserManagement userManagement = new cn.com.crowdsourcedtesting.datawebservices.UserManagement();
	
	public Tester isTester(
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password) {
		return userManagement.isTester(email, password);
	}
	
	public Publisher isPublisher(
			@WebParam(name = "email") String email,
			@WebParam(name = "password")String password) {
		return userManagement.isPublisher(email, password);
	}
	
	public Administrator isAdministrator(
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password) {
		return userManagement.isAdministrator(email, password);
	}
	
	
}
