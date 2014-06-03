package cn.com.crowdsourcedtesting.modelhelper;

import java.util.List;

import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.LoginForm;
import cn.com.crowdsourcedtesting.subinterface.RoleIdentify;
import cn.com.crowdtest.factory.*;

public class CheckAuthority  implements RoleIdentify{

	@Override
	public boolean isLegalUser(LoginForm loginForm) {
		// TODO Auto-generated method stub
	
	    List <Tester> testers = DAOFactory.getTesterDAO().findByProperty("testername",loginForm.getUsername());
		
	    if(testers!=null&&testers.get(0).getTesterPassword().equals(loginForm.getPassword()))
	    {
	    	
	    	
	    	return true;
	    	
	    }
		
		
		return false;
	}
	
	
	
	

	@Override
	public UserType roleOfUser(LoginForm loginForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
