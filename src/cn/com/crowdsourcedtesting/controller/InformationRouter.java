package cn.com.crowdsourcedtesting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.model.InformationHandler;
import cn.com.crowdsourcedtesting.modelhelper.MethodNumber;
import cn.com.crowdsourcedtesting.struts.form.InformationForm;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.crowdtest.factory.DAOFactory;

public class InformationRouter extends DispatchAction {

	InformationHandler handler = new InformationHandler();

	/**
	 * 管理员管理发布者
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward managePublisherList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return this.manageCompanyList(mapping, form, request, response);
	}
	
	
	/**
	 * 管理公司发布者
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward manageCompanyList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return handler.generalListRouter(mapping, form, request, "publisherList", MethodNumber.MethodTwo);
	}
	
	
	/**
	 * 跳转到个人发布者
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward managePersonList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return handler.generalListRouter(mapping, form, request, "publisherList", MethodNumber.MethodThree);
	}
	

	/**
	 * 跳转到测试者详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward manageTesterDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

	  return handler.generalDetailRouter(mapping, form, request, "testerDetail", MethodNumber.MethodOne);
	
	}
	
	
	
	/**
	 * 跳转到发布者详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward managePublisherDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
        InformationForm f = (InformationForm)form;
		request.setAttribute("publisherType", f.getPublisherType());
	  return handler.generalDetailRouter(mapping, form, request, "publisherDetail", MethodNumber.MethodTwo);
	
	}

	
	
	/**
	 * 修改发布者详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward maintainPublisher(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		return handler.maintainPublisher(mapping, form, request);
		
	
		
	}
	
	/**
	 * 修改发布者详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward maintainTester(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		return handler.maintainTester(mapping, form, request);
		
	
		
	}
	

	/**
	 * 管理员管理测试者
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward manageTesterList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		return handler.generalListRouter(mapping, form, request, "testerList", MethodNumber.MethodOne);
	}
	
	

	


}
