package br.com.cafeteriaweb.integration.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

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
	
	@Test
	public void deletarCafe() {
		dao.delete(9999L);
		assertEquals(0, jdbcTemplate.queryForInt("SELECT COUNT(*) FROM CAFES WHERE ID_CAFE = 9999"));
	}

	@Test
	public void criarCafe() {
		Cafe cafe = new Cafe("Expresso", "Tradicional", 3.5F);
		cafe = dao.create(cafe);
		
		Map<String, Object> resultMap = jdbcTemplate.queryForMap( "SELECT * FROM CAFES WHERE ID_CAFE = ?", cafe.getId() );
		assertEquals( "Expresso", resultMap.get("NM_CAFE") );
		assertEquals( "Tradicional", resultMap.get("DESCRICAO") );
		assertEquals( 3.5D, resultMap.get("PRECO") );
	}
}
