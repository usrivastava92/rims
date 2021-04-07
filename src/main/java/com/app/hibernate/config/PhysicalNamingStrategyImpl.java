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
		String underScoreText = addUnderscores(name.getText());
		return new Identifier(transformToPluralFormWithSuffix(underScoreText), name.isQuoted());
	}

	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		String underScoreText = addUnderscores(name.getText());
		return new Identifier(transformToPluralForm(underScoreText), name.isQuoted());
	}

	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
		String underScoreText = addUnderscores(name.getText());
		return new Identifier(transformToPluralForm(underScoreText), name.isQuoted());
	}

	private String transformToPluralForm(String tableNameInSingularForm) {
		return DataBaseMappingUtil.abbreviateName(tableNameInSingularForm);
	}

	private String transformToPluralFormWithSuffix(String tableNameInSingularForm) {
		String nameWithoutSuffix = DataBaseMappingUtil.abbreviateName(tableNameInSingularForm, 26);
		return nameWithoutSuffix.concat(SUFFIX);
	}

	protected static String addUnderscores(String name) {
		StringBuilder buf = new StringBuilder(name.replace('.', '_'));
		for (int i = 1; i < buf.length() - 1; ++i) {
			if ((Character.isLowerCase(buf.charAt(i - 1))) && (Character.isUpperCase(buf.charAt(i)))
					&& (Character.isLowerCase(buf.charAt(i + 1)))) {
				buf.insert(i++, '_');
			}
		}
		return buf.toString().toLowerCase();

	}

}