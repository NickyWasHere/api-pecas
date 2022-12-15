package br.com.mesttra.pecasapi.dto;

import org.springframework.beans.BeanUtils;

import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriarPecaDTO {

	@NotBlank
	private String nome;

	@NotBlank
	private String modeloCarro;
	
	@NotBlank
	private String fabricante;
	
	@NotNull
	private Double precoCusto;
	
	@NotNull
	private Double precoVenda;
	
	@NotNull
	private Integer quantidade;
	
	private Categoria categoria;
	
	public Peca toPeca() {
		Peca peca = new Peca();
		BeanUtils.copyProperties(this, peca);
		return peca;
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
