package cn.com.crowdsourcedtesting.DAO;

import org.hibernate.Session;

import cn.com.crowdtest.factory.HibernateSessionFactory;



/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}