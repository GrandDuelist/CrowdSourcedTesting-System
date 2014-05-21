package cn.com.crowdsourcedtesting.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.crowdsourcedtesting.base.BaseHibernateDAO;
import cn.com.crowdsourcedtesting.bean.Product;
import cn.com.crowdsourcedtesting.bean.Subcategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.com.crowdsourcedtesting.bean.Product
 * @author MyEclipse Persistence Tools
 */

public class ProductDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);
	// property constants
	public static final String VERSION = "version";
	public static final String STATUS = "status";
	public static final String DESCRIPTION = "description";
	public static final String LOGIN_XML_FILE = "loginXmlFile";
	public static final String ICON = "icon";
	public static final String APK_ADDRESS = "apkAddress";
	public static final String WEB_LINK = "webLink";
	public static final String DESKTOP_ADDRESS = "desktopAddress";

	public void save(Product transientInstance) {
		log.debug("saving Product instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Product findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getSession().get(
					"cn.com.crowdsourcedtesting.bean.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.com.crowdsourcedtesting.bean.Product")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByLoginXmlFile(Object loginXmlFile) {
		return findByProperty(LOGIN_XML_FILE, loginXmlFile);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByApkAddress(Object apkAddress) {
		return findByProperty(APK_ADDRESS, apkAddress);
	}

	public List findByWebLink(Object webLink) {
		return findByProperty(WEB_LINK, webLink);
	}

	public List findByDesktopAddress(Object desktopAddress) {
		return findByProperty(DESKTOP_ADDRESS, desktopAddress);
	}

	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public Product addWebProduct(String productName, String icon,
			String webLink, String description) {
		Session session = getSession();
		Transaction trans = null;
		Product product = null;
		try {
			trans = session.beginTransaction();
			SubcategoryDAO subCategoryDAO = new SubcategoryDAO();
			Subcategory subcategory = subCategoryDAO.findById(1);
			product = new Product(subcategory, productName, new Date(), "1",
					true, description, icon);
			product.setWebLink(webLink);
			session.save(product);
			trans.commit();
			log.debug("add web product successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			if (trans != null) {
				trans.rollback();
			}
			product = null;
			throw re;
		}
		return product;
	}
	
	public Product addAndroidProduct(String productName, String icon,
			String appLocation, String description) {
		Session session = getSession();
		Transaction trans = null;
		Product product = null;
		try {
			trans = session.beginTransaction();
			SubcategoryDAO subCategoryDAO = new SubcategoryDAO();
			Subcategory subcategory = subCategoryDAO.findById(1);
			product = new Product(subcategory, productName, new Date(), "1",
					true, description, icon);
			product.setApkAddress(appLocation);
			session.save(product);
			trans.commit();
			log.debug("add web product successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			if (trans != null) {
				trans.rollback();
			}
			product = null;
			throw re;
		}
		return product;
	}
	
	public Product addDesktopProduct(String productName, String icon,
			String desktopAddress, String description) {
		Session session = getSession();
		Transaction trans = null;
		Product product = null;
		try {
			trans = session.beginTransaction();
			SubcategoryDAO subCategoryDAO = new SubcategoryDAO();
			Subcategory subcategory = subCategoryDAO.findById(1);
			product = new Product(subcategory, productName, new Date(), "1",
					true, description, icon);
			product.setDesktopAddress(desktopAddress);
			session.save(product);
			trans.commit();
			log.debug("add desktop product successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			if (trans != null) {
				trans.rollback();
			}
			product = null;
			throw re;
		}
		return product;
	}
}