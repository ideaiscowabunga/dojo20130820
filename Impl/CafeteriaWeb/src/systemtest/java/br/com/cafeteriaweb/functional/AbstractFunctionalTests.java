package br.com.cafeteriaweb.functional;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import br.com.cafeteriaweb.AbstractTests;

@ContextConfiguration({"classpath:spring/applicationSystemTestContext.xml"})
public abstract class AbstractFunctionalTests extends AbstractTests {

	@Autowired
	private BasicDataSource dataSource;

	@Autowired
	private BasicDataSource remoteDataSource;

	private String urlBase = System.getProperty("urlBase","http://localhost:8085/CafeteriaWeb/");

	private WebDriver webDriver;
	
	@Override
	protected Long getTimeToWaitForOracleCommit() {
		return 500L;
	}

	@Override
	protected String getFileName() {
		return "sql/prepareFunctionalTestsDataBase.sql";
	}

	@Override
	protected BasicDataSource chooseDataSource() {
		Map<Boolean, BasicDataSource> dataSources = new HashMap<Boolean, BasicDataSource>();
	    dataSources.put(Boolean.TRUE, remoteDataSource);
	    dataSources.put(Boolean.FALSE, dataSource);
	    
	    Boolean isRemote = Boolean.valueOf( System.getProperty("remote","false") );
	    setDataSource( dataSources.get(isRemote) );
	    
	    return dataSources.get(isRemote);
	}

	@Before
	public void setUp() {
		webDriver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.close();
	}
	
	protected void goTo(String relativePath) {
		webDriver.get(urlBase + relativePath);
	}
	
	protected WebElement findElementById(String id) {
		return webDriver.findElement( By.id(id) );
	}
	
	protected WebElement findElementByCssSelector(String cssSelector) {
		return webDriver.findElement( By.cssSelector(cssSelector) );
	}
	
	protected void type(String elementId, String value) {
		WebElement element = findElementById(elementId);
	    element.clear();
	    element.click();
	    element.sendKeys( value );
	}
}
