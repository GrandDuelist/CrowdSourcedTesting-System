package cn.com.crowdsourcedtesting.datawebservices;

import java.util.Date;

import cn.com.crowdsourcedtesting.DAO.AdministratorDAO;
import cn.com.crowdsourcedtesting.DAO.PublisherDAO;
import cn.com.crowdsourcedtesting.DAO.TesterDAO;
import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.other.page.Page;

public class UserManagement {

	TesterDAO testerDAO = new TesterDAO();
	PublisherDAO publisherDAO = new PublisherDAO();
	AdministratorDAO administratorDAO = new AdministratorDAO();

	public Boolean isTester(String email, String password) {
		Tester tester = testerDAO.isTester(email, password);
		if (tester == null) {
			return new Boolean(false);
		} else {
			return new Boolean(true);
		}
	}

	public Publisher isPublisher(String email, String password) {
		return publisherDAO.isPublisher(email, password);
	}

	public Administrator isAdministrator(String email, String password) {
		return administratorDAO.isAdministrator(email, password);
	}

	public Tester addTester(String email, String password, String name,
			boolean gender, String mobile, Date birthday, double credit) {
		return testerDAO.addTester(email, password, name, gender, mobile,
				birthday, credit);
	}

	public Publisher addPublisher(String name, String email, String password,
			double credit, boolean authority, boolean publisherType,
			String company, String connectEmail) {
		return publisherDAO.addPublisher(name, email, password, credit,
				authority, publisherType, company, connectEmail);
	}

	public Administrator addAdministrator(String name, String email,
			String password, boolean authority, String occupation) {
		return administratorDAO.addAdministrator(name, email, password,
				authority, occupation);
	}

	public Boolean checkPublisher(String email) {
		return publisherDAO.checkPublisher(email);
	}// check

	public Publisher[] viewAllPublisher() {
		return (Publisher[]) publisherDAO.findAll().toArray(new Publisher[0]);
	}

	public Publisher[] findUncheckedCompany(Page page) {
		return (Publisher[]) publisherDAO.findUncheckedCompanyByPage(page)
				.toArray(new Publisher[0]);
	}

	public Publisher[] findUncheckedPerson(Page page) {
		return (Publisher[]) publisherDAO.findUncheckedPersonByPage(page)
				.toArray(new Publisher[0]);
	}

	public int getUncheckedCompanyTotalRows() {
		return publisherDAO.getUncheckedCompanyTotalRows();
	}

	public int getUncheckedPersonTotalRows() {
		return publisherDAO.getUncheckedPersonTotalRows();
	}
}
