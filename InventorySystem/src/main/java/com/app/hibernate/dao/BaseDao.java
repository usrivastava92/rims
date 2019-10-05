package com.app.hibernate.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {

	public void select1();

	public void persistEntity(Object entity);

	public void persistEntityList(List<?> entityList);

	public <T> List<T> getEntityList(Class<T> entityClass, Map<String, Object> whereClauseMap);

	public void updateEntity(Object entity);

	public void updateEntityList(List<?> entityList);

	public <T> List<T> getEntityList(Class<T> entityClass, List<String> columns);

	public List<?> getEntityList(String namedQueryName, Map<String, Object> whereClauseMap);

	public List<Object[]> getEntityList(String sqlString);

}
