package cn.com.crowdsourcedtesting.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Tester;
import cn.com.crowdsourcedtesting.struts.form.RegistrationPublisherForm;
import cn.com.crowdsourcedtesting.struts.form.RegistrationTesterForm;
import cn.com.crowdtest.factory.DAOFactory;

public class RegistrationHandler {
	
	
	GeneralHelperHandler generalHelperHandler = new GeneralHelperHandler();
	//测试用户注册
	public void handleRegistrationTester(HttpServletRequest request,RegistrationTesterForm form) {
		
		Tester tester = new Tester();
		
		String photoFileTypeName = null;
		String photoFilePath = null;
		String photorealPath = null;
		
		FormFile photo = form.getPhoto();
		if(photo != null)
		{
			String[] name = form.getPhoto().getFileName().split("\\.");
			if (name.length <= 1
					|| !generalHelperHandler.isPic(name[name.length - 1])) {
			}
			else {
				photoFileTypeName = name[name.length - 1];
				photoFilePath = "registrate/tester/photo/photo_"
						+ form.getEmail() + "." + photoFileTypeName;
				photorealPath = request.getSession().getServletContext()
						.getRealPath("/" + photoFilePath);
				try {
					BufferedInputStream bin = new BufferedInputStream(
							photo.getInputStream());
					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(photorealPath));
					int bufferSize = 0;
					byte[] buffer = new byte[1024];
					while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
						bout.write(buffer, 0, bufferSize);
					}
					bout.flush();
					bout.close();
					bin.close();
				} catch (IOException e) {
					
				}
			}
		}
		
		tester.setTesterName(form.getName());
		tester.setTesterEmail(form.getEmail());
		tester.setTesterPassword(form.getPassword());
		tester.setTesterGender(form.getGender());
		tester.setTesterMobile(form.getMobile());
		tester.setTesterBirthday(form.getBirthday());
		tester.setTesterPhoto(photoFilePath);
		tester.setTesterCredit(form.getCredit());
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			DAOFactory.getTesterDAO().save(tester);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally{
			session.close();
		}
		
				
	}
	
	//测试发布者注册
	public void handleRegistrationPublisher(HttpServletRequest request,RegistrationPublisherForm form) {
		Publisher publisher = new Publisher();
		
		String photoFileTypeName = null;
		String photoFilePath = null;
		String photorealPath = null;
		
		FormFile photo = form.getPhoto();
		if(photo != null)
		{
			String[] name = form.getPhoto().getFileName().split("\\.");
			if (name.length <= 1
					|| !generalHelperHandler.isPic(name[name.length - 1])) {
			}
			else {
				photoFileTypeName = name[name.length - 1];
				photoFilePath = "registrate/publisher/photo/photo_"
						+ form.getLogEmail()+ "." + photoFileTypeName;
				photorealPath = request.getSession().getServletContext()
						.getRealPath("/" + photoFilePath);
				try {
					BufferedInputStream bin = new BufferedInputStream(
							photo.getInputStream());
					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(photorealPath));
					int bufferSize = 0;
					byte[] buffer = new byte[1024];
					while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
						bout.write(buffer, 0, bufferSize);
					}
					bout.flush();
					bout.close();
					bin.close();
					publisher.setPublisherPhoto(photoFilePath);
				} catch (IOException e) {
					
				}
			}
		}
		else {
			System.out.println("null");
		}
		
		String licenseFileTypeName = null;
		String licenseFilePath = null;
		String licenserealPath = null;
		
		FormFile license = form.getLicense();
		if(license != null)
		{
			String[] name = form.getLicense().getFileName().split("\\.");
			if (name.length <= 1
				|| !generalHelperHandler.isPic(name[name.length - 1])) {	
			}
			else {
				licenseFileTypeName = name[name.length - 1];
				licenseFilePath = "registrate/publisher/license/license_"
						+ form.getLogEmail()+ "." + licenseFileTypeName;
				licenserealPath = request.getSession().getServletContext()
						.getRealPath("/"+licenseFilePath);
				try {
					BufferedInputStream bin = new BufferedInputStream(
							license.getInputStream());
					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(licenserealPath));
					int bufferSize = 0;
					byte[] buffer = new byte[1024];
					while ((bufferSize = bin.read(buffer, 0, buffer.length)) != -1) {
						bout.write(buffer, 0, bufferSize);
					}
					bout.flush();
					bout.close();
					bin.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
		}
		
		publisher.setPublisherAuthority(form.getAuthority());
		publisher.setPublisherLogEmail(form.getLogEmail());
		publisher.setPublisherName(form.getPublisherName());
		publisher.setPublisherType(form.getType());
		publisher.setPublisherCredit(form.getCredit());
		publisher.setPublisherPassword(form.getPassword());
		publisher.setPublisherConnectEmail(form.getConnectEmail());
		publisher.setPublisherCompany(form.getCompanyName());
		
		//缺少license映射
		
		
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			DAOFactory.getPublisherDAO().save(publisher);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			
		} finally {
			session.close();
		}
	
	}
}
