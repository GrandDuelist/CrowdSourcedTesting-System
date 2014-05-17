package cn.com.crowdsourcedtesting.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForward;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.crowdsourcedtesting.base.HibernateSessionFactory;
import cn.com.crowdsourcedtesting.bean.Administrator;
import cn.com.crowdsourcedtesting.bean.Choice;
import cn.com.crowdsourcedtesting.bean.Publisher;
import cn.com.crowdsourcedtesting.bean.Question;
import cn.com.crowdsourcedtesting.bean.Questionnaire;
import cn.com.crowdsourcedtesting.struts.form.PageIdForm;
import cn.com.crowdsourcedtesting.struts.form.PublisherQuestionnaireForm;
import cn.com.crowdtest.factory.BeanFactory;
import cn.com.crowdtest.factory.DAOFactory;
import cn.com.other.page.Page;

/**
 * 处理添加新问卷
 * 
 * @author 方志晗
 * 
 */
public class QuestionnaireHandler {

	// 添加问卷
	public void createItem(PublisherQuestionnaireForm form,
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		Questionnaire questionnaire = (Questionnaire) session
				.getAttribute("questionnaire");
		List<Question> questions = (List<Question>) session
				.getAttribute("questions");

		String currentID = null;
		String subType = form.getSubType();

		if (subType != null && subType.equals("selectQuestion")) {

			if (form.getCurrentOne() != null
					&& !form.getCurrentOne().equals("")) {
				currentID = form.getCurrentOne();
				if (currentID != null && !currentID.equals("")) {

					session.setAttribute("currentID", currentID);
				}
			}

		} else if (subType != null && "confirmQuestion".equals(subType)) {

			if (form.getCurrentOne() != null
					&& !form.getCurrentOne().equals("")) {
				currentID = form.getCurrentOne();
				if (currentID != null && !currentID.equals("")) {

					// 确认题目
					if (questionnaire != null & questions != null) {
						Question q = questions.get(Integer.parseInt(currentID));

						questionnaire.getQuestions().add(q);
						questions.remove(q);

						System.out.println(q.getQuestionContent());
						session.setAttribute("questionnaire", questionnaire);
						session.setAttribute("questions", questions);
					}
				}
			}

		} else if (subType != null && "deleteQuestion".equals(subType)) {
			// 删除题目
			if (form.getCurrentOne() != null
					&& !form.getCurrentOne().equals("")) {
				currentID = form.getCurrentOne();
				if (currentID != null && !currentID.equals("")) {

					// 确认题目
					if (questionnaire != null & questions != null) {
						Question q = questions.get(Integer.parseInt(currentID));

						questions.remove(q);

						System.out.println(q.getQuestionContent());

						session.setAttribute("questions", questions);
					}
				}
			}

		} else if (subType != null && "publishQuetionnaire".equals(subType)) {

			//存储问卷
			Questionnaire q = (Questionnaire) session
					.getAttribute("questionnaire");
			
		
				Publisher publisher  = (Publisher)session.getAttribute("Publisher");
			     q.setPublisher(publisher);
			    
			
			
			Session sess = HibernateSessionFactory.getSession();

			Transaction tran = null;

			try {

			    
				tran = sess.beginTransaction();
				
				 q.setCredit(300.00);
			     q.setQuestionnaireCount(q.getQuestions().size());
			     
				q.setIsPassed(false);
				sess.save(q);
				
				Iterator it1 = q.getQuestions().iterator();
				
				while(it1.hasNext())
				{
					Question q1 = (Question) it1.next();
					
					q1.setQuestionnaire(q);
					q1.setQuestionCount(q1.getChoices().size());
					q1.setQuestionType(false);
					sess.save(q1);
					
					
					Iterator it2 = q1.getChoices().iterator();
					
					while(it2.hasNext())
					{
						Choice c = (Choice) it2.next();
						c.setQuestion(q1);
						c.setSelectCount(0);
						sess.save(c);
					}
					
					
					
					
				}
				
			
				tran.commit();
				
				session.removeAttribute("questionnaire");
				session.removeAttribute("questions");
				
				
			} catch (RuntimeException e) {

				e.printStackTrace();
				if (tran != null) {
					tran.rollback();
				}

			} finally {

				sess.close();
			}

		}

		else {

			// String currentID = request.getParameter("currentID");

			if (questionnaire == null || questions == null
					|| questionnaire.equals("")) {
				if (form.getQuestionnaireName() != null && !form.equals("")) {
					questionnaire = BeanFactory.getQuestionnaire();
					questionnaire.setTitle(form.getQuestionnaireName());
					session.setAttribute("questionnaire", questionnaire);
				}

				if (form.getQuestionName() != null
						&& !form.getQuestionName().equals("")) {
					questions = new ArrayList<Question>();
				}
			}

			// 添加问题和选项
			if (form.getQuestionName() != null
					&& !form.getQuestionName().equals("")) {
				Question q = BeanFactory.getQuestion();
				q.setQuestionContent(form.getQuestionName());

				String choices = form.getChoices();
				while (choices != null && !choices.equals("")) {
					System.out.println(choices);
					String choice;
					if (choices.indexOf(",") != -1) {
						choice = choices.substring(0, choices.indexOf(","));
						choices = choices.substring(choices.indexOf(",") + 1);
					} else {
						choice = choices;
						choices = null;
					}
					Choice c = BeanFactory.getChoice();

					c.setChoiceContent(choice);
					q.getChoices().add(c);
				}
				questions.add(q);
				session.setAttribute("questions", questions);
			}

			session.setAttribute("type", "confirm");
		}
	}
	
	/**
	 * 审查问卷列表
	 * @param form
	 * @param request
	 */
	public void checkQuestionnaire(PageIdForm form,
			HttpServletRequest request) {
		String subType = null; //子类型 
		Page  page = new Page();
		page.setTotalRows(DAOFactory.getQuestionnaireDAO().getUncheckedTotalRows());
		
		
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
			
		}else if(subType.equals("detail"))
		{
			currentPage = Integer.parseInt(form.getPage());
		}else if("checkConfirm".equals(subType))  //审核通过
		{
			int id = Integer.parseInt(form.getId());
			
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
		List <Questionnaire> questionnaires  = DAOFactory.getQuestionnaireDAO().findByUnCheckedPage(page);
		HttpSession session  = request.getSession();
		session.setAttribute("currentPage", page);
		session.setAttribute("questionnaires", questionnaires);
		session.setAttribute("questionnaireCurrentPage", currentPage);
	}
	
	
	/**
	 * 查看具体的问卷
	 * @param pageIDForm
	 * @param request
	 */

	public void checkQuestionnaireDetail(PageIdForm pageIDForm,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		if(pageIDForm!=null&&pageIDForm.getId()!=null&&!pageIDForm.getId().equals(""))
		{
		int id  = Integer.parseInt(pageIDForm.getId());
		
		Questionnaire questionnaire = DAOFactory.getQuestionnaireDAO().findById(id);
		HttpSession session  = request.getSession();

		session.setAttribute("questionnaire", questionnaire);
		}
		
		
		
		
	}
	
	
	
}
