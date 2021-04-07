package com.app.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.app.hibernate.config.HibernateUtil;
import com.app.hibernate.entity.core.BaseEntity;
import com.app.logging.BaseLoggers;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.app.hibernate.dao.BaseDao;

@Named("baseDaoImpl")
public class BaseDaoImpl implements BaseDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void select1() {
        BaseLoggers.flowLogger
                .error(String.valueOf(entityManager.createNativeQuery("select 1 from dual").getSingleResult()));
    }

    @Override
    public <T extends BaseEntity> T persistEntity(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <T extends BaseEntity> List<T> persistEntityList(List<T> entityList) {
        for (T entity : entityList) {
            persistEntity(entity);
        }
        return entityList;
    }

    @Override
    public <T extends BaseEntity> T updateEntity(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public <T extends BaseEntity> List<T> updateEntityList(List<T> entityList) {
        for (T entity : entityList) {
            updateEntity(entity);
        }
        return entityList;
    }

    @Override
    public boolean deleteEntityList(List<?> entityList) {
        for (Object entity : entityList) {
            deleteEntity(entity);
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Object entity) {
        if (entity != null) {
            try {
                entityManager.remove(entity);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public <T> boolean deleteEntityById(Class<T> entityClass, Long id) {
        return deleteEntity(getEntityById(entityClass, id));
    }

    @Override
    public <T> List<T> getEntityList(Class<T> entityClass, Map<String, Object> whereClauseMap) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(entityClass);
        Root<T> root = criteria.from(entityClass);
        criteria.select(root);
        List<Predicate> predicates = new ArrayList<>();
        for (Entry<String, Object> entry : whereClauseMap.entrySet()) {
            if (entry.getValue() instanceof List) {
                predicates.add(builder.equal(root.get(entry.getKey()), (List<?>) entry.getValue()));
            } else {
                predicates.add(builder.equal(root.get(entry.getKey()), entry.getValue()));
            }
        }
        criteria.select(root).where(predicates.toArray(new Predicate[] {}));
        return entityManager.createQuery(criteria).getResultList();
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public <T> List<T> getEntityList(Class<T> entityClass, List<String> columns) {
        Session session = (Session) entityManager.getDelegate();
        Criteria cr = session.createCriteria(entityClass);
        ProjectionList projectionList = Projections.projectionList();
        for (String column : columns) {
            projectionList.add(Projections.property(column), column);
        }
        cr.setProjection(projectionList).setResultTransformer(Transformers.aliasToBean(entityClass));
        return cr.list();
    }

    @Override
    public List<?> getEntityList(String namedQueryName, Map<String, Object> whereClauseMap) {
        Query query = entityManager.createNamedQuery(namedQueryName);
        for (Entry<String, Object> entry : whereClauseMap.entrySet()) {
            if (entry.getValue() instanceof List) {
                query = query.setParameter(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof String) {
                query = query.setParameter(entry.getKey(), (String) entry.getValue());
            }
        }
        return query.getResultList();
    }

    @Override
    public <T> List<?> getListUsingHql(String hqlQuery, Class<T> entityClass) {
        return entityManager.createQuery(hqlQuery, entityClass).getResultList();
    }

    @Override
    public List<?> getListUsingHql(String hqlQuery) {
        return entityManager.createQuery(hqlQuery).getResultList();
    }

    @Override
    public List<?> getListUsingSql(String sqlString) {
        return entityManager.createNativeQuery(sqlString).getResultList();
    }

    @Override
    public <T> T getEntityById(Class<T> entityClass, Long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id) {
        T entity = entityManager.find(entityClass, id);
        HibernateUtil.initializeObject(entity, "com.app.hibernate.entity");
        return entity;
    }

    @Override
    public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id, String insidePackageName) {
        T entity = entityManager.find(entityClass, id);
        HibernateUtil.initializeObject(entity, insidePackageName);
        return entity;
    }

    @Override
    public boolean executeQuery(String sqlString) {
        try {
            entityManager.createNativeQuery(sqlString).executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(entityClass);
        Root<T> root = criteria.from(entityClass);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }
}
