package com.bitranger.parknshop.admin.data;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PsAdministator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see temp.PsAdministator
 * @author MyEclipse Persistence Tools
 */
public class PsAdministatorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PsAdministatorDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(PsAdministator transientInstance) {
		log.debug("saving PsAdministator instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PsAdministator persistentInstance) {
		log.debug("deleting PsAdministator instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PsAdministator findById(java.lang.Integer id) {
		log.debug("getting PsAdministator instance with id: " + id);
		try {
			PsAdministator instance = (PsAdministator) getHibernateTemplate()
					.get("temp.PsAdministator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PsAdministator> findByExample(PsAdministator instance) {
		log.debug("finding PsAdministator instance by example");
		try {
			List<PsAdministator> results = (List<PsAdministator>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PsAdministator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PsAdministator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PsAdministator> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<PsAdministator> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<PsAdministator> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all PsAdministator instances");
		try {
			String queryString = "from PsAdministator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PsAdministator merge(PsAdministator detachedInstance) {
		log.debug("merging PsAdministator instance");
		try {
			PsAdministator result = (PsAdministator) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PsAdministator instance) {
		log.debug("attaching dirty PsAdministator instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PsAdministator instance) {
		log.debug("attaching clean PsAdministator instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PsAdministatorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PsAdministatorDAO) ctx.getBean("PsAdministatorDAO");
	}
}