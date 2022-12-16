package br.com.mesttra.pecasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mesttra.pecasapi.dto.CriaPecaDTO;
import br.com.mesttra.pecasapi.dto.MostraPecaDTO;
import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.enums.Categoria;
import br.com.mesttra.pecasapi.exception.ErroDeNegocioException;
import br.com.mesttra.pecasapi.repository.PecaRepository;

@Service
public class PecaService {

	@Autowired
	PecaRepository repository;
	
	//CREATE
	
	public void inserePeca(CriaPecaDTO pecaDto) {		
		repository.save(pecaDto.toPeca());
		
	}
	
	//READ
	
	public MostraPecaDTO mostraPeca(Long codigoBarras) throws ErroDeNegocioException {
		Optional<Peca> pecaCadastrada = repository.findById(codigoBarras);
		
		if (pecaCadastrada.isEmpty())
			throw new ErroDeNegocioException("Nenhuma peça encontrada");
		
		return MostraPecaDTO.toDto(pecaCadastrada.get());
	}
	
	public List<MostraPecaDTO> mostraPecas() {
		List<Peca> pecas = (List<Peca>) repository.findAll();		
		return listaDto(pecas);
	}
	
	public List<MostraPecaDTO> mostraPecasPorComeco(String comeco) {
		List<Peca> pecas = repository.findByNomeStartsWith(comeco);
		return listaDto(pecas);
	}
	
	public List<MostraPecaDTO> mostraPecasPorCarro(String modelo) {
		List<Peca> pecas = repository.findByModeloCarro(modelo);
		return listaDto(pecas);
	}
	
	public List<MostraPecaDTO> mostraPecasPorCategoria(String categoria) {
		List<Peca> pecas = repository.findByCategoria(Enum.valueOf(Categoria.class, categoria));
		return listaDto(pecas);
	}
	
	private List<MostraPecaDTO> listaDto(List<Peca> pecas) {
		List<MostraPecaDTO> pecasDto = new ArrayList<>();
		
		for (Peca p : pecas) {
			pecasDto.add(MostraPecaDTO.toDto(p));
			
		}
		
		return pecasDto;
	}
	
	//UPDATE
	
	public void atualizaPeca(Peca peca) throws ErroDeNegocioException {
		if (!repository.existsById(peca.getCodigoBarras()))
			throw new ErroDeNegocioException("Não foi cadastrada nenhuma peça com este código de barras");
		
		repository.save(peca);
	}
	
	//DELETE
	
	public void excluiPeca(Long codigoBarras) throws ErroDeNegocioException {
		if (!repository.existsById(codigoBarras))
			throw new ErroDeNegocioException("Não foi cadastrada nenhuma peça com este código de barras");
		
		repository.deleteById(codigoBarras);
	}
}
