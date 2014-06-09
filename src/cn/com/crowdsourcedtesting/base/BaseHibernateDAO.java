package cn.com.crowdsourcedtesting.base;

import org.hibernate.Session;

import cn.com.crowdtest.factory.HibernateSessionFactory;



/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	@Override
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}