package cn.com.crowdsourcedtesting.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.com.crowdsourcedtesting.bean.Questionnaire;
import cn.com.crowdsourcedtesting.modelhelper.MethodNumber;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;


/**
 * 此handler里面包含一些常用的页面处理方法
 * 其他handler直接调用这里面的功用模块
 * @author 方志晗
 *
 */
public abstract class GeneralHandler {
	
	
	//ListHandle的接口
	abstract public void  setTargetListOne(Page page, HttpServletRequest request);
	abstract public void  setTargetListTwo(Page page, HttpServletRequest request);
	abstract public void  setTargetListThree(Page page, HttpServletRequest request);
	
	//DetailHandle的接口
	abstract public void  setTargetDetailOne(int id,HttpServletRequest request);
	abstract public void  setTargetDetailTwo(int id,HttpServletRequest request);
	
	
	//通用的列表处理
	public void ListHandle(PageIdForm form,
			HttpServletRequest request, MethodNumber method)
	{
		String subType = null; //子类型 
		Page  page = new Page();
		if(form!=null)
		{
			
			subType=form.getSubType();
		}
		
		int currentPage = 1;
		//根据不同的类型来
		
		//类型为空
		if(subType ==null)
		{
			currentPage = 1;
			
		}else if("pageNum".equals(subType))
		{
			currentPage  = Integer.parseInt(form.getPage());
		}else if("previousPage".equals(subType))
		{
			currentPage = Integer.parseInt(form.getPage())-1;
		}else if("nextPage".equals(subType))
		{
			currentPage = Integer.parseInt(form.getPage())+1;
		}
		
		page.setCurrentPage(currentPage);
		
		
		//不同的方法调用不同的接口
		switch(method){
		case MethodOne:setTargetListOne(page,request);break;
		case MethodTwo:setTargetListTwo(page,request);break;
		case MethodThree:setTargetListThree(page,request);break;
		}
		
		
	}
	
	
	
	/**
	 * 查看具体的问卷
	 * @param pageIDForm
	 * @param request
	 */

	public void detailHandle(PageIdForm pageIDForm,
			HttpServletRequest request, MethodNumber method) {
		// TODO Auto-generated method stub
		
		if(pageIDForm!=null&&pageIDForm.getId()!=null&&!pageIDForm.getId().equals(""))
		{
		int id  = Integer.parseInt(pageIDForm.getId());
		
		//不同的方法调用不同的接口
		switch(method){
		case MethodOne:setTargetDetailOne(id,request);break;
		case MethodTwo:setTargetDetailTwo(id,request);break;
		
		}
		
		
		
		}
		
	}
	

	
	

}
