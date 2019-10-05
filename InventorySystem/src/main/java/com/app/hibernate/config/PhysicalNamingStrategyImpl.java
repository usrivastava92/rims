package com.app.hibernate.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = 1L;
	public static final PhysicalNamingStrategyImpl INSTANCE = new PhysicalNamingStrategyImpl();
	private static final String SUFFIX = "";

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return new Identifier(name.getText().concat(SUFFIX).toUpperCase(), name.isQuoted());
	}

}