package com.example.mco.config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AppConfigTest {
	
	@Mock
	private AppConfig.Db db;

	@Spy
	private AppConfig objectUnderTest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getSchemaDefaultTest() {
		final String value = "mco";
		when(objectUnderTest.getDb()).thenReturn(db);
		when(db.getSchemaDefault()).thenReturn("mco");

		assertEquals(value, objectUnderTest.getDb().getSchemaDefault());
	}
	
	@Test
	public void getSchemaTest() {
		final String value = "mco";
		when(objectUnderTest.getDb()).thenReturn(db);
		when(db.getSchema()).thenReturn("mco");

		assertEquals(value, objectUnderTest.getDb().getSchema());
	}
	@Test
	public void getJooqSqlDialect() {
		final String value = "h2";
		when(objectUnderTest.getDb()).thenReturn(db);
		when(db.getJooqSqlDialect()).thenReturn("h2");

		assertEquals(value, objectUnderTest.getDb().getJooqSqlDialect());
	}
}