package com.app.hibernate.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.core.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.app.hibernate.dao.BaseDao;
import com.app.hibernate.service.BaseService;

@Named("baseServiceImpl")
public class BaseServiceImpl implements BaseService {

	@Inject
	@Named("baseDaoImpl")
	private BaseDao daoImpl;

	@Override
	@Transactional
	public void select1() {
		daoImpl.select1();

	}

	@Override
	@Transactional
	public <T extends BaseEntity> T persistEntity(T entity) {
	return	daoImpl.persistEntity(entity);
	}

	@Override
	@Transactional
	public <T extends BaseEntity> List<T> persistEntityList(List<T> entityList) {
		return daoImpl.persistEntityList(entityList);
	}

	@Override
	@Transactional
	public <T extends  BaseEntity> T updateEntity(T entity) {
		return daoImpl.updateEntity(entity);
	}

	@Override
	@Transactional
	public <T extends  BaseEntity> List<T> updateEntityList(List<T> entityList) {
		return daoImpl.updateEntityList(entityList);
	}

	@Override
	@Transactional
	public boolean deleteEntityList(List<?> entityList) {
		return daoImpl.deleteEntityList(entityList);
	}

	@Override
	@Transactional
	public boolean deleteEntity(Object entity) {
		return daoImpl.deleteEntity(entity);
	}

	@Override
	@Transactional
	public <T> boolean deleteEntityById(Class<T> entityClass, Long id) {
		return daoImpl.deleteEntityById(entityClass, id);
	}

	@Override
	@Transactional
	public <T> List<T> getEntityList(Class<T> entityClass, Map<String, Object> whereClauseMap) {
		return daoImpl.getEntityList(entityClass, whereClauseMap);
	}

	@Override
	@Transactional
	public <T> List<T> getEntityList(Class<T> entityClass, List<String> columns) {
		return daoImpl.getEntityList(entityClass, columns);
	}

	@Override
	@Transactional
	public List<?> getEntityList(String namedQueryName, Map<String, Object> whereClauseMap) {
		return daoImpl.getEntityList(namedQueryName, whereClauseMap);
	}

	@Override
	@Transactional
	public List<?> getListUsingSql(String sqlString) {
		return daoImpl.getListUsingSql(sqlString);
	}

	@Override
	@Transactional
	public <T> T getEntityById(Class<T> entityClass, Long id) {
		return daoImpl.getEntityById(entityClass, id);
	}

	@Override
	@Transactional
	public <T> List<?> getListUsingHql(String hqlQuery, Class<T> entityClass) {
		return daoImpl.getListUsingHql(hqlQuery, entityClass);
	}

	@Override
	@Transactional
	public List<?> getListUsingHql(String hqlQuery) {
		return daoImpl.getListUsingHql(hqlQuery);
	}

	@Override
	@Transactional
	public boolean executeQuery(String sqlString) {
		String validatedQuery = sqlString.trim();
		if (validatedQuery.endsWith(";")) {
			validatedQuery = validatedQuery.substring(0, validatedQuery.length() - 1);
		}
		return daoImpl.executeQuery(validatedQuery);
	}

	@Override
	@Transactional
	public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id){
		return daoImpl.getEntityByIdWithAllLazyObjects(entityClass,id);
	}

	@Override
	@Transactional
	public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id,String insidePackageName){
		return daoImpl.getEntityByIdWithAllLazyObjects(entityClass,id,insidePackageName);
	}

	@Override
	@Transactional
	public <T> List<T> findAll(Class<T> entityClass){
		return daoImpl.findAll(entityClass);
	}

}
