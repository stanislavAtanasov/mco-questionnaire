package com.example.mco.config;

import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JooqConfig {
	private final AppConfig appConfig;
	private final DataSource dataSource;
	
	@Autowired
	public JooqConfig(AppConfig appConfig, DataSource dataSource) {
		this.appConfig = appConfig;
		this.dataSource = dataSource;
	}
	
	@Bean
	public DSLContext create() {
	    return new DefaultDSLContext(configuration());
	}
	 
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
	    return new DataSourceConnectionProvider
	      (new TransactionAwareDataSourceProxy(dataSource));
	}
	 
	@Bean
	public ExceptionTranslator exceptionTransformer() {
	    return new ExceptionTranslator();
	}
	
	private DefaultConfiguration configuration() {
	    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
	    jooqConfiguration.set(connectionProvider());
	    jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
	    jooqConfiguration.set(SQLDialect.valueOf(appConfig.getDb().getJooqSqlDialect()));
	    jooqConfiguration.setSettings(new Settings()
										    .withRenderMapping(new RenderMapping()
										    .withSchemata(
													new MappedSchema().withInput(appConfig.getDb().getSchemaDefault())
										                          .withOutput(appConfig.getDb().getSchema()))));
	    return jooqConfiguration;
	}
	
	
	class ExceptionTranslator extends DefaultExecuteListener {
		
		@Override
	    public void exception(ExecuteContext context) {
	        SQLDialect dialect = context.configuration().dialect();
	        SQLExceptionTranslator translator 
	          = new SQLErrorCodeSQLExceptionTranslator(dialect.name());
	        context.exception(translator
	          .translate("Access database using jOOQ", context.sql(), context.sqlException()));
	    }
	}
}
