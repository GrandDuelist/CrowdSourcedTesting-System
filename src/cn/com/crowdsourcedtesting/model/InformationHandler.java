package cn.com.crowdsourcedtesting.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.modelhelper.MethodNumber;
import cn.com.crowdsourcedtesting.struts.form.InformationForm;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;

public class InformationHandler extends GeneralHandler {

	// 测试者分页
	@Override
	public void setTargetListOne(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		page.setTotalRows(DAOFactory.getTesterDAO().getTotalRows());
		List<Tester> testers = DAOFactory.getTesterDAO().findByPage(page);
		request.setAttribute("currentPage", page);
		request.setAttribute("testers", testers);

	}

	// 公司发布者分页
	@Override
	public void setTargetListTwo(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		page.setTotalRows(DAOFactory.getPublisherDAO().getCompanyTotalRows());
		List<Publisher> publishers = DAOFactory.getPublisherDAO()
				.findCompanyByPage(page);
		request.setAttribute("currentPage", page);
		request.setAttribute("publishers", publishers);
		request.setAttribute("publisherType", "Company");

	}

	// 个人发布者分页

	@Override
	public void setTargetListThree(Page page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println(page.getCurrentPage());
		page.setTotalRows(DAOFactory.getPublisherDAO().getPersonTotalRows());
		List<Publisher> publishers = DAOFactory.getPublisherDAO()
				.findPersonByPage(page);
		request.setAttribute("currentPage", page);
		request.setAttribute("publishers", publishers);
		request.setAttribute("publisherType", "Person");

	}

	// 测试者详情
	@Override
	public void setTargetDetailOne(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Tester tester = DAOFactory.getTesterDAO().findById(id);
		request.setAttribute("tester", tester);

	}

	// 发布者详情
	@Override
	public void setTargetDetailTwo(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Publisher publisher = DAOFactory.getPublisherDAO().findById(id);
		request.setAttribute("publisher", publisher);

	}

	@Override
	public void setTargetDetailThree(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	/**
	 * 将获得的InformationForm转换为通用类型
	 * 
	 * @param form
	 * @return
	 */
	public PageIdForm changeToPageIdForm(ActionForm form) {
		InformationForm f = (InformationForm) form;
		
		if (f != null) {
			PageIdForm pageIdForm = new PageIdForm();
			pageIdForm.setId(f.getId() + "");
			pageIdForm.setPage(f.getPage() + "");
			if(f.getSubType()!=null)pageIdForm.setSubType(f.getSubType());
			return pageIdForm;
		}
		
		return null;
		
	}

	/**
	 * 自定义参数的路由
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param targetPage
	 * @param method
	 * @return
	 */
	public ActionForward generalListRouter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, String targetPage,
			MethodNumber method) {
       
		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session
				.getAttribute("Administrator");
		if (admin == null) {
			return mapping.findForward("adminLogin");
		}
		
		request.setAttribute("isLegal", "true");
		this.ListHandle(this.changeToPageIdForm(form), request, method);
		return mapping.findForward(targetPage);
	}

	/**
	 * 自定义参数的路由
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param targetPage
	 * @param method
	 * @return
	 */
	public ActionForward generalDetailRouter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, String targetPage,
			MethodNumber method) {

		HttpSession session = request.getSession();
		Administrator admin = (Administrator) session
				.getAttribute("Administrator");
		if (admin == null) {
			return mapping.findForward("adminLogin");
		}
		request.setAttribute("isLegal", "true");
		this.detailHandle(this.changeToPageIdForm(form), request, method);
		return mapping.findForward(targetPage);
	}

	/**
	 * 修改维护发布者的信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @return
	 */
	public ActionForward maintainPublisher(ActionMapping mapping,
			ActionForm form, HttpServletRequest request) {
		InformationForm f = (InformationForm) form;
		if(f==null) return this.generalListRouter(mapping, form, request, "publisherList", MethodNumber.MethodTwo);
		
		try {
			
			Publisher publisher = DAOFactory.getPublisherDAO().findById(
					f.getId());
			if(f.getUsername()!=null)publisher.setPublisherName(f.getUsername());
			if (f.getStatus()!=null&&f.getStatus())publisher.setPublisherAuthority(!publisher
						.getPublisherAuthority());
			if(f.getLicense()!=null)publisher.setBusinessLicense(f.getLicense());
			if(f.getCredit()!=null)publisher.setPublisherCredit(f.getCredit());
			if(f.getCompany()!=null)publisher.setPublisherCompany(f.getCompany());
			
			DAOFactory.getPublisherDAO().save(publisher);
			request.setAttribute("modify", "success");
			/*跳回到修改前的页面
			 */
			
		} catch (Exception e) {
			request.setAttribute("modify", "failed");
		
		}
		request.setAttribute("publisherType", f.getPublisherType());
		f.setSubType("detail");
		return this.generalDetailRouter(mapping, form, request, "publisherDetail", MethodNumber.MethodTwo);
		
	}
    /**
     * 修改维护测试者信息
     * @param mapping
     * @param form
     * @param request
     * @return
     */
	public ActionForward maintainTester(ActionMapping mapping, ActionForm form,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		InformationForm f = (InformationForm) form;
		if(f==null) return this.generalListRouter(mapping, form, request, "testerList", MethodNumber.MethodOne);
		
		try {
			
			Tester tester = DAOFactory.getTesterDAO().findById(
					f.getId());
			if (tester == null) {
				System.out.println("tester null==========");
			}
			if (f.getStatus()!=null&&f.getStatus())tester.setHasAuthority(!tester.
					getHasAuthority());
			if(f.getUsername()!=null)tester.setTesterName(f.getUsername());
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			if(f.getBirthday()!=null)tester.setTesterBirthday(dateFormat.parse(f.getBirthday()));	
			DAOFactory.getTesterDAO().save(tester);
			request.setAttribute("modify", "success");
			/*跳回到修改前的页面
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("modify", "failed");
		
		}
		return this.generalDetailRouter(mapping, form, request, "testerDetail", MethodNumber.MethodOne);
	}

}
