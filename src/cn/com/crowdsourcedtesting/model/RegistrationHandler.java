package cn.com.crowdsourcedtesting.model;

import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.RegistrationTesterForm;
import cn.com.crowdtest.factory.DAOFactory;

public class RegistrationHandler {
	
	//测试用户注册
	public void handleRegistrationTester(RegistrationTesterForm form) {
		
		Tester tester = new Tester();
		
		tester.setTesterName(form.getName());
		tester.setTesterEmail(form.getEmail());
		tester.setTesterPassword(form.getPassword());
		tester.setTesterGender(form.getGender());
		tester.setTesterMobile(form.getMobile());
		tester.setTesterBirthday(form.getBirthday());
		tester.setTesterPhoto(form.getPhoto());
		tester.setTesterCredit(form.getCredit());
		
		DAOFactory.getTesterDAO().save(tester);
				
	}
	
	//测试发布者注册
}
