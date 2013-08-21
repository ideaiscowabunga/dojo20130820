package br.com.cafeteriaweb.functional;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListagemDeCafesTest extends AbstractFunctionalTests {

	@Test
	public void existemElementosNaTabela() throws Exception {
		goTo("list");
		WebElement linhaDaTabela = findElementByCssSelector("table .cafe");
		List<WebElement> tds = linhaDaTabela.findElements( By.cssSelector("td") );
		assertEquals( 5, tds.size());
		assertEquals("9999", tds.get(0).getText());
		assertEquals("pilao", tds.get(1).getText());
		assertEquals("Negro e forte", tds.get(2).getText());
		assertEquals("12.5", tds.get(3).getText());
		
	}
	
}
