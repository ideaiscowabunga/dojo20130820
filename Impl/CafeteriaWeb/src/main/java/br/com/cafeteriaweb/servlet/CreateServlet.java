package br.com.cafeteriaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;

import br.com.cafeteriaweb.dao.CafeDao;
import br.com.cafeteriaweb.exception.ValidateException;
import br.com.cafeteriaweb.model.Cafe;

public class CreateServlet implements HttpRequestHandler {
	
	private static final Log LOGGER = LogFactory.getLog(CreateServlet.class);
	
	@Autowired
	private CafeDao cafeDao;

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			createCafe( request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("preco") );
			response.sendRedirect("list?message=create.success");
		} catch ( ValidateException e ) {
			response.sendRedirect("list?message=invalid.coffee&errors=" + e.toString() );
		} catch ( Exception e ) {
			LOGGER.error("Ocorreu um erro generico ao salvar um novo cafe", e);
			response.sendRedirect("list?message=create.error");
		}
	}

	private Cafe createCafe(String nomeCafe, String descricaoCafe, String precoCafe) throws ValidateException {
		Float preco = 0F;
		
		try {
			preco = Float.valueOf(precoCafe);
		} catch (NumberFormatException e) { }
		
		Cafe cafe = new Cafe(nomeCafe, descricaoCafe, preco);
		cafe.validate();
		
		cafeDao.create(cafe);
		return cafe;
	}
}
