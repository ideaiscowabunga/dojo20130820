package br.com.cafeteriaweb.integration.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cafeteriaweb.dao.CafeDao;
import br.com.cafeteriaweb.integration.AbstractIntegrationTests;
import br.com.cafeteriaweb.model.Cafe;

public class CafeDaoTest extends AbstractIntegrationTests {

	@Autowired
	private CafeDao dao;
	
	@Test
	public void buscouCafes() {
		List<Cafe> cafes = dao.findAll();
		assertEquals(2, cafes.size());
		assertEquals(Long.valueOf(9998), cafes.get(0).getId());
		assertEquals(Long.valueOf(9999), cafes.get(1).getId());
	}
}
