package br.com.cafeteriaweb.functional.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cafeteriaweb.functional.AbstractFunctionalTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleTests extends AbstractFunctionalTests {

	@Test
	public void indexHeader() {
		goTo("index.html");
		WebElement header = findElementByCssSelector("#content h1");
		assertEquals("Descrição do Problema", header.getText());
	}
	
}
