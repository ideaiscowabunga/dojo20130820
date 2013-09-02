package br.com.cafeteriaweb.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListagemDeCafesTest extends AbstractFunctionalTests {

	@Test
	public void existemElementosNaTabela() throws Exception {
		goTo("list");
		WebElement linhaDaTabela = findElementById("#cafe9999");
		List<WebElement> tds = linhaDaTabela.findElements( By.cssSelector("td") );
		assertEquals( 5, tds.size());
		assertEquals("9999", tds.get(0).getText());
		assertEquals("pilao", tds.get(1).getText());
		assertEquals("Negro e forte", tds.get(2).getText());
		assertEquals("12.5", tds.get(3).getText());
		
		WebElement linkDelecao = tds.get(4);
		assertNotNull(linkDelecao);
		assertEquals("/delete?id=9999", linkDelecao.getAttribute("href"));
	}
	
	@Test
	public void excluirElementoDaTabela() throws Exception {
		goTo("list");
		findElementById("delete9999").click();
		
		try {
			findElementById("#cafe9999");
			fail("Não deveria existir o café 9999, pois acabou de ser excluído");
		} catch (NoSuchElementException e) { }
	}	
	
}
