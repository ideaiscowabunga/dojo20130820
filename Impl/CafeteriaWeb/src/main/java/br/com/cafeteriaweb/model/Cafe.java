package br.com.cafeteriaweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cafeteriaweb.exception.ValidateException;

@Entity
@Table(name="cafes")
public class Cafe implements Serializable {
	
	private static final long serialVersionUID = -2102332887945445971L;

	@Id
	@SequenceGenerator(name="SEQUENCE", sequenceName="CAFES_SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	@Column(name="ID_CAFE")
	private Long id;
	
	@Column(name="NM_CAFE")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private Float preco;

	public Cafe(String nome, String descricao, Float preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Cafe() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public void validate() throws ValidateException {
		ArrayList<String> invalidationReasons = new ArrayList<String>();
		
		if( nome == null || nome.length() > 15 || nome.length() < 3) {
			invalidationReasons.add("nome");
		}
		
		if( descricao != null && descricao.length() > 60) {
			invalidationReasons.add("descricao");
		}
		
		if( preco == null || preco <= 0F ) {
			invalidationReasons.add("preco");
		}
		
		if( !invalidationReasons.isEmpty() ) {
			throw new ValidateException(invalidationReasons);
		}
	}

}
