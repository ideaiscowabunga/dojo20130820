package br.com.cafeteriaweb.integration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import br.com.cafeteriaweb.AbstractTests;

@ContextConfiguration({"classpath:spring/dataTestsContext.xml", "classpath:spring/applicationContext.xml"})
public abstract class AbstractIntegrationTests extends AbstractTests {

	@Autowired
	private BasicDataSource dataSource;

	@Override
	protected String getFileName() {
		return "sql/prepareIntegrationTestsDataBase.sql";
	}

	@Override
	protected BasicDataSource chooseDataSource() {
		return dataSource;
	}

	@Override
	protected Long getTimeToWaitForOracleCommit() {
		return 0L;
	}

}
