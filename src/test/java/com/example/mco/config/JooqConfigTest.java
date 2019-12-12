package com.example.mco.config;

import org.jooq.DSLContext;
import org.jooq.impl.DataSourceConnectionProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class JooqConfigTest {

	@Spy
	private AppConfig appConfig;

	@Mock
	private DataSource dataSource;

	@Mock
	private AppConfig.Db db;

	@InjectMocks
	private JooqConfig objectUnderTest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void create() {
		when(appConfig.getDb()).thenReturn(db);
		when(db.getSchema()).thenReturn("mco");
		when(db.getSchemaDefault()).thenReturn("mco");
		when(db.getJooqSqlDialect()).thenReturn("H2");
		
		DSLContext context = objectUnderTest.create();
		assertNotNull(context);
	}

	@Test
	public void connectionProvider() {
		DataSourceConnectionProvider provider = objectUnderTest.connectionProvider();
		assertNotNull(provider);
	}
}
