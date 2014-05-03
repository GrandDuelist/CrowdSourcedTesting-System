package cn.com.crowdsourcedtesting.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.com.crowdsourcedtesting.bean.Choice;
import cn.com.crowdsourcedtesting.bean.Question;
import cn.com.crowdsourcedtesting.bean.Questionnaire;
import cn.com.crowdsourcedtesting.struts.form.PublisherQuestionnaireForm;
import cn.com.crowdtest.factory.BeanFactory;

/**
 * 处理添加新问卷
 * 
 * @author 方志晗
 * 
 */
public class QuestionnaireHandler {

	
	//添加问卷
	public void createItem(PublisherQuestionnaireForm form,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		Questionnaire  questionnaire= (Questionnaire) session.getAttribute("questionnaire");
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		
		if(questionnaire==null||questions==null)
		{
			if(form.getQuestionnaireName()!=null&&!form.equals("")){
			questionnaire=BeanFactory.getQuestionnaire();
			questionnaire.setTitle(form.getQuestionnaireName());
			session.setAttribute("questionnaire", questionnaire);
			}
			
			
			if(form.getQuestionName()!=null&&!form.getQuestionName().equals("")){
			questions =  new ArrayList<Question>();}
		}
		
		//添加问题和选项
		if(form.getQuestionName()!=null&&!form.getQuestionName().equals("")){
		Question q= BeanFactory.getQuestion();
		q.setQuestionContent(form.getQuestionName());
		
		String choices = form.getChoices();
		while(choices!=null&&!choices.equals(""))
		{
			System.out.println(choices);
			String choice;
			if(choices.indexOf(",")!=-1){
			   choice = choices.substring(0,choices.indexOf(","));
			choices = choices.substring(choices.indexOf(",")+1);
			}else
			{
				 choice = choices;
				 choices =null;
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
