package br.com.mesttra.pecasapi.dto;

import org.springframework.beans.BeanUtils;

import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.enums.Categoria;

public class MostrarPecaDTO {

	private Long codigoBarras;
	
	private String nome;
	
	private String modeloCarro;
	
	private String fabricante;
	
	private Double precoVenda;
	
	private Integer quantidade;
	
	private Categoria categoria;

	public static MostrarPecaDTO toDto(Peca peca) {
		MostrarPecaDTO pecaDto = new MostrarPecaDTO();
		BeanUtils.copyProperties(peca, pecaDto);
		return pecaDto;
		
	}
	
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
