package cn.com.crowdsourcedtesting.model;

import javax.servlet.http.HttpSession;

import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.LoginForm;
import cn.com.crowdsourcedtesting.struts.form.PublisherLoginForm;
import cn.com.crowdtest.factory.DAOFactory;

public class SecurityHandler {

	// 测试用户的登录
	public Tester handleTesterLogin(LoginForm form)
	{
		Tester tester=DAOFactory.getTesterDAO().isTester(form.getUsername(), form.getPassword());

		return tester;
		
	}
	
	// 发布者的登录
		public Publisher handlePublisherLogin(PublisherLoginForm form)
		{
			Publisher publisher=DAOFactory.getPublisherDAO().isPublisher(form.getUsername(), form.getPassword());

			
			return publisher;
			
		}
}
