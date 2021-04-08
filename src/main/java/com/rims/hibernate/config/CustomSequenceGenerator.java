
package com.rims.hibernate.config;

import java.util.Properties;

import org.hibernate.boot.model.naming.Identifier;

import org.hibernate.boot.model.relational.QualifiedName;

import org.hibernate.boot.model.relational.QualifiedNameImpl;

import org.hibernate.dialect.Dialect;

import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import org.hibernate.id.enhanced.SequenceStyleGenerator;

import org.hibernate.internal.util.config.ConfigurationHelper;

public class CustomSequenceGenerator extends SequenceStyleGenerator

{

	public static final String ENTITY_TARGET_TABLE_NAME = "target_table";

	protected QualifiedName determineSequenceName(Properties params, Dialect dialect, JdbcEnvironment jdbcEnv) {
		String sequencePerEntitySuffix = ConfigurationHelper.getString("sequence_per_entity_suffix", params, "_SEQ");
		String sequenceName = (ConfigurationHelper.getBoolean("prefer_sequence_per_entity", params, false))
				? params.getProperty("target_table") + sequencePerEntitySuffix
				: "hibernate_sequence";
		sequenceName = DataBaseMappingUtil.abbreviateName(sequenceName);
		sequenceName = ConfigurationHelper.getString("sequence_name", params, sequenceName);
		return new QualifiedNameImpl(jdbcEnv.getCurrentCatalog(), jdbcEnv.getCurrentSchema(),
				new Identifier(sequenceName, false));

	}

}