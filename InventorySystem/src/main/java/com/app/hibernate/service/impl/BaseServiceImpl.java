package com.app.hibernate.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

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
	public void persistEntity(Object entity) {
		daoImpl.persistEntity(entity);
	}

	@Override
	@Transactional
	public void persistEntityList(List<?> entityList) {
		daoImpl.persistEntityList(entityList);
	}

	@Override
	@Transactional
	public void updateEntity(Object entity) {
		daoImpl.updateEntity(entity);
	}

	@Override
	@Transactional
	public void updateEntityList(List<?> entityList) {
		daoImpl.updateEntityList(entityList);
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
	public List<Object[]> getEntityList(String sqlString) {
		return daoImpl.getEntityList(sqlString);
	}

	@Override
	@Transactional
	public <T> T getEntityById(Class<T> entityClass, Long id) {
		return daoImpl.getEntityById(entityClass, id);
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
}
