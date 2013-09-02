package br.com.cafeteriaweb.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ListagemDeCafesTest extends AbstractFunctionalTests {

	@Test
	public void existemElementosNaTabela() throws Exception {
		goTo("list");
		WebElement linhaDaTabela = findElementById("cafe9999");
		List<WebElement> tds = linhaDaTabela.findElements( By.cssSelector("td") );
		assertEquals( 5, tds.size());
		assertEquals("9999", tds.get(0).getText());
		assertEquals("pilao", tds.get(1).getText());
		assertEquals("Negro e forte", tds.get(2).getText());
		assertEquals("R$ 12.5", tds.get(3).getText());
		
		WebElement linkDelecao = tds.get(4).findElement(By.tagName("a"));
		assertNotNull(linkDelecao);
		assertEquals("delete?id=9999", linkDelecao.getAttribute("href"));
	}
	
	@Test
	public void excluirCafe() throws Exception {
		goTo("list");
		findElementById("delete9999").click();
		
		try {
			findElementById("cafe9999");
			fail("Não deveria existir o café 9999, pois acabou de ser excluído");
		} catch (NoSuchElementException e) { }
	}	
	
	@Test
	public void criarCafe() throws Exception {
		goTo("list");
		type("nomeCafe", "Expresso");
		type("descricaoCafe", "Café Tradicional");
		type("precoCafe", "3.5");
		findElementById("btCriar").click();
		Thread.sleep(1000);
		assertTrue( getCurrentUrl().contains("list?message=create.success") );
	}
	
}
