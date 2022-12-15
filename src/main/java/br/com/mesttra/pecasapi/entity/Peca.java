package br.com.mesttra.pecasapi.entity;

import br.com.mesttra.pecasapi.enums.Categoria;
import jakarta.persistence.*;

@Entity
public class Peca {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "codigo_barras")
	private Long codigoBarras;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (name = "modelo_carro", nullable = false)
	private String modeloCarro;
	
	@Column (nullable = false)
	private String fabricante;
	
	@Column (name = "preco_custo", nullable = false)
	private Double precoCusto;
	
	@Column (name = "preco_venda", nullable = false)
	private Double precoVenda;
	
	@Column (nullable = false)
	private Integer quantidade;
	
	@Column (nullable = false)
	private Categoria categoria;

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
