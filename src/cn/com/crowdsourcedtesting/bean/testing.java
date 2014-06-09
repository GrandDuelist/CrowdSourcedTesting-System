package cn.com.crowdsourcedtesting.bean;

public class testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 /*  GiftDAO gd=  DAOFactory.getGiftDAO();
		
		List<Gift> gifts=gd.findAll();
		System.out.println();
		System.out.println(gifts.size());
		
		Gift g =  new  Gift();
	
		g.setGiftName("礼品");
		g.setGiftPhoto("000");
		g.setGiftCredit(12.00);
		g.setGiftAmount(22);
		
		
		gd.save(g);
		
		System.out.println(gd.getTotalRows());
*/
		/*Tester tester = new Tester();
		tester.setTesterEmail("ezhihan@gmail.com");
		tester.setTesterPassword("1234");
		tester.setTesterName("ezhihan");
		
		DAOFactory.getTesterDAO().save(tester);*/
		
//		Tester tester = DAOFactory.getTesterDAO().isTester("ezhihan@gmail.com", "123");
//		
//		if(tester!=null)
//		{
//			System.out.println(tester.getTesterId());
//		}
		
		/*Session session = HibernateSessionFactory.getSession();
		Questionnaire q = BeanFactory.getQuestionnaire();
		Question q1 = BeanFactory.getQuestion();
		Choice c1= BeanFactory.getChoice();
		c1.setChoiceContent("怎么样");
		q1.setQuestionContent("你喜欢那个英雄");
		q.setTitle("游戏问卷");
		
		q1.getChoices().add(c1);
		q.getQuestions().add(q1);
		
		DAOFactory.getChoiceDAO().save(c1);
		DAOFactory.getQuestionDAO().save(q1);
		DAOFactory.getQuestionnaireDAO().save(q);*/
		
		
//		List<Recruitment> t=DAOFactory.getRecruitmentDAO().findAll();
//		System.out.println(t.size());
	/*	Publisher publisher= new PublisherDAO().findById(8);
		Questionnaire q = new Questionnaire(publisher,"问卷",0.0,0);
		Session sess = HibernateSessionFactory.getSession();

		Transaction tran = null;

		try {

		    
			tran = sess.beginTransaction();
			sess.save(q);
			tran.commit();
		
	} catch (RuntimeException e) {

		e.printStackTrace();
		if (tran != null) {
			tran.rollback();
		}

	} finally {

		sess.close();
	}
	
	}*/
	}

}
