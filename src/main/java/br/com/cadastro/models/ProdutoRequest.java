package br.com.cadastro.models;

import java.io.Serializable;

public class ProdutoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047106553517430389L;
	
	private Long id;

	private Integer codigo;
	
	private String produtoNome;
	
	private String descricao;
		
	private String marca;

	private String tipo;
	
	private String validade;
	
	private String depositoid;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getDepositoid() {
		return depositoid;
	}

	public void setDepositoid(String depositoid) {
		this.depositoid = depositoid;
	}


	
	
}
