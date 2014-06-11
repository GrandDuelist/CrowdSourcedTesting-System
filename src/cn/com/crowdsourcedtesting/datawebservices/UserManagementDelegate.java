package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam;

import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.other.page.Page;

@javax.jws.WebService(targetNamespace = "http://datawebservices.crowdsourcedtesting.com.cn/", serviceName = "UserManagementService", portName = "UserManagementPort")
@javax.jws.soap.SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.RPC)
public class UserManagementDelegate {

	cn.com.crowdsourcedtesting.datawebservices.UserManagement userManagement = new cn.com.crowdsourcedtesting.datawebservices.UserManagement();

	public Tester isTester(
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password) {
		return userManagement.isTester(email, password);
	}

	public Publisher isPublisher(
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password) {
		return userManagement.isPublisher(email, password);
	}

	public Administrator isAdministrator(
			@WebParam(name = "email") String email, 
			@WebParam(name = "password") String password) {
		return userManagement.isAdministrator(email, password);
	}

	public Tester addTester(
			@WebParam(name = "email") String email, 
			@WebParam(name = "password") String password,
			@WebParam(name = "name") String name,
			@WebParam(name = "gender") boolean gender,
			@WebParam(name = "mobile") String mobile,
			@WebParam(name = "birthday") Date birthday,
			@WebParam(name = "credit") double credit) {
		return userManagement.addTester(email, password, name, gender, mobile,
				birthday, credit);
	}

	public Publisher addPublisher(
			@WebParam(name = "name") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password,
			@WebParam(name = "credit") double credit,
			@WebParam(name = "authority") boolean authority,
			@WebParam(name = "publisherType")boolean publisherType,
			@WebParam(name = "company") String company,
			@WebParam(name = "connectEmail") String connectEmail) {
		return userManagement.addPublisher(name, email, password, credit,
				authority, publisherType, company, connectEmail);
	}

	public Administrator addAdministrator(
			@WebParam(name = "name") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "password") String password,
			@WebParam(name = "authority") boolean authority,
			@WebParam(name = "occupation") String occupation) {
		return userManagement.addAdministrator(name, email, password,
				authority, occupation);
	}

	public Boolean checkPublisher(
			@WebParam(name = "email") String email) {
		return userManagement.checkPublisher(email);
	}

	public Publisher[] viewAllPublisher() {
		return userManagement.viewAllPublisher();
	}

	public Publisher[] findUncheckedCompany(
			@WebParam(name = "page") Page page) {
		return userManagement.findUncheckedCompany(page);
	}

	public Publisher[] findUncheckedPerson(
			@WebParam(name = "page") Page page) {
		return userManagement.findUncheckedPerson(page);
	}

	public int getUncheckedCompanyTotalRows() {
		return userManagement.getUncheckedCompanyTotalRows();
	}

	public int getUncheckedPersonTotalRows() {
		return userManagement.getUncheckedPersonTotalRows();
	}

}