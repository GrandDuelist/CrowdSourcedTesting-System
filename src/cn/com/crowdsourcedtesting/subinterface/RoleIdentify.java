package cn.com.crowdsourcedtesting.subinterface;

import cn.com.crowdsourcedtesting.modelhelper.UserType;
import cn.com.crowdsourcedtesting.struts.form.LoginForm;


public interface RoleIdentify{
	
	public boolean isLegalUser(LoginForm loginForm);
	public UserType roleOfUser(LoginForm loginForm);

}
