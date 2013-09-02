package br.com.cafeteriaweb;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

public abstract class AbstractTests extends AbstractTransactionalJUnit4SpringContextTests {

	protected JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() throws Exception {
		BasicDataSource dataSource = chooseDataSource();
		setDataSource( dataSource );
		setJdbcTemplate( dataSource ); 
		executeSqlScript( getFileName(), false );
		Thread.sleep( getTimeToWaitForOracleCommit() );
	}

	private void setJdbcTemplate(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	protected abstract Long getTimeToWaitForOracleCommit();

	protected abstract String getFileName();

	protected abstract BasicDataSource chooseDataSource();

}