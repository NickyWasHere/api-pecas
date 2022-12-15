package br.com.mesttra.pecasapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mesttra.pecasapi.dto.CriarPecaDTO;
import br.com.mesttra.pecasapi.dto.MostrarPecaDTO;
import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.exception.ErroDeNegocioException;
import br.com.mesttra.pecasapi.repository.PecaRepository;

@Service
public class PecaService {

	@Autowired
	PecaRepository repository;
	
	public void cadastrarPeca(CriarPecaDTO pecaDto) {		
		repository.save(pecaDto.toPeca());
		
	}
	
	public MostrarPecaDTO verPeca(Long codigoBarras) throws ErroDeNegocioException {
		Optional<Peca> pecaCadastrada = repository.findById(codigoBarras);
		
		if (pecaCadastrada.isEmpty())
			throw new ErroDeNegocioException("Nenhuma peça encontrada");
		
		return MostrarPecaDTO.toDto(pecaCadastrada.get());
	}
	
	public List<MostrarPecaDTO> verPecas() {
		List<MostrarPecaDTO> pecasDto = new ArrayList<>();
		List<Peca> pecas = (List<Peca>) repository.findAll();
		
		for (Peca p : pecas) {
			pecasDto.add(MostrarPecaDTO.toDto(p));
		}
		
		return pecasDto;
	}
	
	public void atualizarPeca(Peca peca) throws ErroDeNegocioException {
		if (!repository.existsById(peca.getCodigoBarras()))
			throw new ErroDeNegocioException("Não foi cadastrada nenhuma peça com este código de barras");
		
		repository.save(peca);
	}
	
	public void excluirPeca(Long codigoBarras) throws ErroDeNegocioException {
		if (!repository.existsById(codigoBarras))
			throw new ErroDeNegocioException("Não foi cadastrada nenhuma peça com este código de barras");
		
		repository.deleteById(codigoBarras);
	}
}
