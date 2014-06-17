/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package cn.com.crowdsourcedtesting.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import cn.com.crowdsourcedtesting.DAO.ProductDAO;
import cn.com.crowdsourcedtesting.DAO.TestTaskDAO;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.model.GeneralHelperHandler;
import cn.com.crowdsourcedtesting.modelhelper.TaskType;
import cn.com.crowdsourcedtesting.struts.form.PublishTestingTaskForm;

/**
 * MyEclipse Struts Creation date: 05-24-2014
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/publishTestingTask" name="publishTestingTaskForm"
 *                input="/form/publishTestingTask.jsp" parameter="method"
 *                scope="request" validate="true"
 */
public class PublishTestingTaskAction extends DispatchAction {

	private final String productErrorMessageAttributeName = "ProductPublishErrorMessage";
	private final String taskErrorMessageAttributeName = "TaskPublishErrorMessage";

	private final String productSystemErrorMessage = "系统错误";
	private final String productIconFileTypeErrorMessage = "上传图标文件类型错误";
	private final String productApkFileTypeErrorMessage = "上传应用文件类型错误";
	private final String productNoIconFileErrorMessage = "未上传图标";
	private final String productNoApkFileErrorMessage = "未上传应用程序";
	private final String productFileUploadErrorMessage = "文件上传错误";
	private final String productUrlErrorMessage = "上传连接出错";

	private final String taskFormErrorMessage = "表单星标内容不能为空";
	private final String taskDaterangeFormatErrorMessage = "时间范围格式错误，请重新输入";
	private final String taskSystemErrorMessage = "系统错误,请重试或者稍后再试";

	private final String goToPubWebProductForward = "pubWeb";
	private final String goToPubAndroidProductForward = "pubAndroid";
	private final String goToPubDesktopProductForward = "pubDesktop";
	private final String goToPubWebTaskForward = "webProductSuccess";
	private final String goToPubAndroidTaskForward = "androidProductSuccess";
	private final String goToPubDesktopTaskForward = "desktopProductSuccess";
	private final String webProductErrorForward = "webProductError";
	private final String webProductSuccessForward = "webProductSuccess";
	private final String androidProductErrorForward = "androidProductError";
	private final String androidProductSuccessForward = "androidProductSuccess";
	private final String desktopProductErrorForward = "desktopProductError";
	private final String desktopProductSuccessForward = "desktopProductSuccess";
	private final String taskPublishSuccessForward = "taskSuccess";
	private final String publisherLogin = "publisherLogin";

	GeneralHelperHandler generalHelperHandler = new GeneralHelperHandler();

	public ActionForward goToPublish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		return mapping.findForward("pubTask");
	}

	public ActionForward taskManagement(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		return mapping.findForward("taskManagement");
	}

	public ActionForward pubWeb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		return mapping.findForward("pubWeb");
	}

	public ActionForward pubAndroid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		return mapping.findForward("pubAndroid");
	}

	public ActionForward pubDesktop(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		return mapping.findForward("pubDesktop");
	}

	public ActionForward webSubmitForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}
		
		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;
		
		FormFile iconFile = publishTestingForm.getIcon();
		if (iconFile == null) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productNoIconFileErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}
		String[] name = publishTestingForm.getIcon().getFileName().split("\\.");
		if (name.length <= 1
				|| !generalHelperHandler.isPic(name[name.length - 1])) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productIconFileTypeErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}
		
		String webUrl = publishTestingForm.getWebUrl();
		if ((webUrl = generalHelperHandler.isUrl(webUrl)) == null) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productUrlErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}

		String iconFileTypeName = name[name.length - 1];

		String iconFilePath = "product/web/icon/product_template_"
				+ publisher.getPublisherId() + "." + iconFileTypeName;
		String realPath = request.getSession().getServletContext()
				.getRealPath("/" + iconFilePath);

		try {
			BufferedInputStream bin = new BufferedInputStream(
					iconFile.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(realPath));
			int bufferSize = 0;
			byte[] buffer = new byte[1024];
			while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
				bout.write(buffer, 0, bufferSize);
			}
			bout.flush();
			bout.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productFileUploadErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}

		Product product = new Product();
		product.setProductName(publishTestingForm.getWebName());
		product.setWebLink(webUrl);
		product.setIcon(iconFilePath);
		product.setDescription(publishTestingForm.getDescription());

		request.getSession().setAttribute("WebProduct", product);

		return new ActionRedirect(mapping.findForward(webProductSuccessForward));
	}

	public ActionForward pubWebTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;
		System.out.println(publishTestingForm.getDaterange());
		System.out.println(publishTestingForm.getPerReward());
		System.out.println(publishTestingForm.getWholeReward());

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}

		Product product = (Product) request.getSession().getAttribute(
				"WebProduct");
		if (product == null) {
			return new ActionRedirect(
					mapping.findForward(goToPubWebProductForward));
		}

		if (publishTestingForm.getDaterange() == null
				|| "".equals(publishTestingForm.getDaterange())
				|| publishTestingForm.getPerReward() == null
				|| "".equals(publishTestingForm.getPerReward())
				|| publishTestingForm.getWholeReward() == null
				|| "".equals(publishTestingForm.getWholeReward())) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskFormErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		Integer perReward = publishTestingForm.getPerReward();
		Integer wholeCredit = publishTestingForm.getWholeReward();

		String[] dateRange = publishTestingForm.getDaterange().split("-");
		if (dateRange.length != 2) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = dateFormat.parse(dateRange[0]);
			endDate = dateFormat.parse(dateRange[1]);
			System.out.println(beginDate);
			System.out.println(endDate);
		} catch (ParseException e) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		File iconFile = new File(request.getSession().getServletContext()
				.getRealPath("/" + product.getIcon()));
		String[] name = product.getIcon().split("\\.");
		String iconNewName = "product/web/icon/product_"
				+ publisher.getPublisherId() + "_" + System.currentTimeMillis()
				+ "." + name[name.length - 1];
		iconFile.renameTo(new File(request.getSession().getServletContext()
				.getRealPath("/" + iconNewName)));
		product.setIcon(iconNewName);

		try {
			ProductDAO productDAO = new ProductDAO();
			product = productDAO.addWebProduct(product.getProductName(),
					product.getIcon(), product.getWebLink(),
					product.getDescription());
			TestTaskDAO testTaskDAO = new TestTaskDAO();
			testTaskDAO.addTestTask(product, TaskType.Web, publisher, beginDate, endDate,
					perReward, wholeCredit);
		} catch (RuntimeException re) {
			re.printStackTrace();
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskSystemErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		request.getSession().removeAttribute("WebProduct");

		ActionRedirect redirect = new ActionRedirect(
				mapping.findForwardConfig(taskPublishSuccessForward));
		return redirect;
	}

	public ActionForward androidSubmitForm(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}

		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;
//		System.out.println(publishTestingForm.getAppName());
//		System.out.println(publishTestingForm.getIcon().getFileName());
//		System.out.println(publishTestingForm.getApkFile().getFileName());
//		System.out.println(publishTestingForm.getDescription());

		FormFile iconFile = publishTestingForm.getIcon();
		if (iconFile == null) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productNoIconFileErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}
		String[] iconFileName = publishTestingForm.getIcon().getFileName()
				.split("\\.");
		if (iconFileName.length <= 1
				|| !generalHelperHandler
						.isPic(iconFileName[iconFileName.length - 1])) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productIconFileTypeErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}

		FormFile apkFile = publishTestingForm.getApkFile();
		if (apkFile == null) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productNoApkFileErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}
		String[] apkFileName = publishTestingForm.getApkFile().getFileName()
				.split("\\.");
		if (apkFileName.length <= 1
				|| !"apk".equalsIgnoreCase(apkFileName[apkFileName.length - 1])) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productIconFileTypeErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}

		String iconFileTypeName = iconFileName[iconFileName.length - 1];
		String apkFileTypeName = "apk";

		String iconFilePath = "product/android/icon/product_template_"
				+ publisher.getPublisherId() + "." + iconFileTypeName;
		String realPath = request.getSession().getServletContext()
				.getRealPath("/" + iconFilePath);
		try {
			BufferedInputStream bin = new BufferedInputStream(
					iconFile.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(realPath));
			int bufferSize = 0;
			byte[] buffer = new byte[1024];
			while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
				bout.write(buffer, 0, bufferSize);
			}
			bout.flush();
			bout.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productFileUploadErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}

		String apkFilePath = "product/android/apkfile/product_template_"
				+ publisher.getPublisherId() + "." + apkFileTypeName;
		realPath = request.getSession().getServletContext()
				.getRealPath("/" + apkFilePath);
		try {
			BufferedInputStream bin = new BufferedInputStream(
					iconFile.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(realPath));
			int bufferSize = 0;
			byte[] buffer = new byte[1024];
			while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
				bout.write(buffer, 0, bufferSize);
			}
			bout.flush();
			bout.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productSystemErrorMessage);
			return mapping.findForward(androidProductErrorForward);
		}

		Product product = new Product();
		product.setProductName(publishTestingForm.getAppName());
		product.setIcon(iconFilePath);
		product.setApkAddress(apkFilePath);
		product.setDescription(publishTestingForm.getDescription());

		request.getSession().setAttribute("AndroidProduct", product);

		return new ActionRedirect(
				mapping.findForward(androidProductSuccessForward));
	}

	public ActionForward pubAndroidTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;
		System.out.println(publishTestingForm.getDaterange());
		System.out.println(publishTestingForm.getPerReward());
		System.out.println(publishTestingForm.getWholeReward());

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}

		Product product = (Product) request.getSession().getAttribute(
				"AndroidProduct");
		if (product == null) {
			return new ActionRedirect(
					mapping.findForward(goToPubAndroidProductForward));
		}

		if (publishTestingForm.getDaterange() == null
				|| "".equals(publishTestingForm.getDaterange())
				|| publishTestingForm.getPerReward() == null
				|| "".equals(publishTestingForm.getPerReward())
				|| publishTestingForm.getWholeReward() == null
				|| "".equals(publishTestingForm.getWholeReward())) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskFormErrorMessage);
			return mapping.findForward(goToPubAndroidTaskForward);
		}

		Integer perReward = publishTestingForm.getPerReward();
		Integer wholeCredit = publishTestingForm.getWholeReward();

		String[] dateRange = publishTestingForm.getDaterange().split("-");
		if (dateRange.length != 2) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubAndroidTaskForward);
		}

		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = dateFormat.parse(dateRange[0]);
			endDate = dateFormat.parse(dateRange[1]);
			System.out.println(beginDate);
			System.out.println(endDate);
		} catch (ParseException e) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubAndroidTaskForward);
		}

		File iconFile = new File(request.getSession().getServletContext()
				.getRealPath("/" + product.getIcon()));
		String[] name = product.getIcon().split("\\.");
		String iconNewName = "product/android/icon/product_"
				+ publisher.getPublisherId() + "_" + System.currentTimeMillis()
				+ "." + name[name.length - 1];
		iconFile.renameTo(new File(request.getSession().getServletContext()
				.getRealPath("/" + iconNewName)));
		product.setIcon(iconNewName);

		File apkFile = new File(request.getSession().getServletContext()
				.getRealPath("/" + product.getApkAddress()));
		name = product.getApkAddress().split("\\.");
		String apkNewName = "product/android/apkfile/product_"
				+ publisher.getPublisherId() + "_" + System.currentTimeMillis()
				+ "." + name[name.length - 1];
		apkFile.renameTo(new File(request.getSession().getServletContext()
				.getRealPath("/" + apkNewName)));
		product.setApkAddress(apkNewName);

		try {
			ProductDAO productDAO = new ProductDAO();
			product = productDAO.addAndroidProduct(product.getProductName(),
					product.getIcon(), product.getApkAddress(),
					product.getDescription());
			TestTaskDAO testTaskDAO = new TestTaskDAO();
			testTaskDAO.addTestTask(product, TaskType.Android, publisher, beginDate, endDate,
					perReward, wholeCredit);
		} catch (RuntimeException re) {
			re.printStackTrace();
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskSystemErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		request.getSession().removeAttribute("AndroidProduct");

		ActionRedirect redirect = new ActionRedirect(
				mapping.findForwardConfig(taskPublishSuccessForward));
		return redirect;
	}

	public ActionForward desktopSubmitForm(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}

		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;

		FormFile iconFile = publishTestingForm.getIcon();
		if (iconFile == null) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productNoIconFileErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}
		String[] name = publishTestingForm.getIcon().getFileName().split("\\.");
		if (name.length <= 1
				|| !generalHelperHandler.isPic(name[name.length - 1])) {
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productIconFileTypeErrorMessage);
			return mapping.findForward(webProductErrorForward);
		}

		String iconFileTypeName = name[name.length - 1];

		String iconFilePath = "product/desktop/icon/product_template_"
				+ publisher.getPublisherId() + "." + iconFileTypeName;
		String realPath = request.getSession().getServletContext()
				.getRealPath("/" + iconFilePath);

		try {
			BufferedInputStream bin = new BufferedInputStream(
					iconFile.getInputStream());
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(realPath));
			int bufferSize = 0;
			byte[] buffer = new byte[1024];
			while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
				bout.write(buffer, 0, bufferSize);
			}
			bout.flush();
			bout.close();
			bin.close();
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute(productErrorMessageAttributeName,
					productFileUploadErrorMessage);
			return mapping.findForward(desktopProductErrorForward);
		}

		Product product = new Product();
		product.setProductName(publishTestingForm.getAppName());
		product.setDesktopAddress(publishTestingForm.getDownLoadLink());
		product.setIcon(iconFilePath);
		product.setDescription(publishTestingForm.getDescription());

		request.getSession().setAttribute("DesktopProduct", product);

		return new ActionRedirect(
				mapping.findForward(desktopProductSuccessForward));
	}

	public ActionForward pubDesktopTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PublishTestingTaskForm publishTestingForm = (PublishTestingTaskForm) form;
		System.out.println(publishTestingForm.getDaterange());
		System.out.println(publishTestingForm.getPerReward());
		System.out.println(publishTestingForm.getWholeReward());

		Publisher publisher = (Publisher) request.getSession().getAttribute(
				"Publisher");
		if (publisher == null) {
			return new ActionRedirect(mapping.findForwardConfig(publisherLogin));
		}

		Product product = (Product) request.getSession().getAttribute(
				"DesktopProduct");
		if (product == null) {
			return new ActionRedirect(
					mapping.findForward(goToPubDesktopProductForward));
		}

		if (publishTestingForm.getDaterange() == null
				|| "".equals(publishTestingForm.getDaterange())
				|| publishTestingForm.getPerReward() == null
				|| "".equals(publishTestingForm.getPerReward())
				|| publishTestingForm.getWholeReward() == null
				|| "".equals(publishTestingForm.getWholeReward())) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskFormErrorMessage);
			return mapping.findForward(goToPubDesktopTaskForward);
		}

		Integer perReward = publishTestingForm.getPerReward();
		Integer wholeCredit = publishTestingForm.getWholeReward();

		String[] dateRange = publishTestingForm.getDaterange().split("-");
		if (dateRange.length != 2) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubDesktopTaskForward);
		}

		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = dateFormat.parse(dateRange[0]);
			endDate = dateFormat.parse(dateRange[1]);
			System.out.println(beginDate);
			System.out.println(endDate);
		} catch (ParseException e) {
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskDaterangeFormatErrorMessage);
			return mapping.findForward(goToPubDesktopTaskForward);
		}

		File iconFile = new File(request.getSession().getServletContext()
				.getRealPath("/" + product.getIcon()));
		String[] name = product.getIcon().split("\\.");
		String iconNewName = "product/desktop/icon/product_"
				+ publisher.getPublisherId() + "_" + System.currentTimeMillis()
				+ "." + name[name.length - 1];
		iconFile.renameTo(new File(request.getSession().getServletContext()
				.getRealPath("/" + iconNewName)));
		product.setIcon(iconNewName);

		try {
			ProductDAO productDAO = new ProductDAO();
			product = productDAO.addDesktopProduct(product.getProductName(),
					product.getIcon(), product.getDesktopAddress(),
					product.getDescription());
			TestTaskDAO testTaskDAO = new TestTaskDAO();
			testTaskDAO.addTestTask(product, TaskType.Desktop, publisher, beginDate, endDate,
					perReward, wholeCredit);
		} catch (RuntimeException re) {
			re.printStackTrace();
			request.getSession().setAttribute(taskErrorMessageAttributeName,
					taskSystemErrorMessage);
			return mapping.findForward(goToPubWebTaskForward);
		}

		request.getSession().removeAttribute("WebProduct");

		ActionRedirect redirect = new ActionRedirect(
				mapping.findForwardConfig(taskPublishSuccessForward));
		return redirect;
	}

	public ActionForward pubTaskSuccess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward(taskPublishSuccessForward);
	}
}