package com.app.hibernate.service;

import com.app.hibernate.entity.core.BaseEntity;

import java.util.List;
import java.util.Map;

public interface BaseService {

	public void select1();

	public <T extends BaseEntity> T persistEntity(T entity);

	public <T extends BaseEntity> List<T> persistEntityList(List<T> entityList);


	public <T extends BaseEntity> T updateEntity(T entity);

	public <T extends BaseEntity> List<T> updateEntityList(List<T> entityList);


	public <T> List<T> getEntityList(Class<T> entityClass, Map<String, Object> whereClauseMap);

	public <T> List<T> getEntityList(Class<T> entityClass, List<String> columns);

	public List<?> getEntityList(String namedQueryName, Map<String, Object> whereClauseMap);

	public List<?> getListUsingSql(String sqlString);

	public <T> List<?> getListUsingHql(String hqlQuery, Class<T> entityClass);

	public List<?> getListUsingHql(String hqlQuery);

	public <T> T getEntityById(Class<T> entityClass, Long id);

	public boolean executeQuery(String sqlString);

	public boolean deleteEntity(Object entity);

	public boolean deleteEntityList(List<?> entityList);

	public <T> boolean deleteEntityById(Class<T> entityClass, Long id);

	public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id);

	public <T> T getEntityByIdWithAllLazyObjects(Class<T> entityClass, Long id,String insidePackageName);

	public <T> List<T> findAll(Class<T> entityClass);
}
