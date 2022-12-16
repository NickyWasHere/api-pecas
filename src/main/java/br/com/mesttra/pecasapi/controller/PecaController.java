package br.com.mesttra.pecasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.mesttra.pecasapi.dto.CriaPecaDTO;
import br.com.mesttra.pecasapi.dto.MostraPecaDTO;
import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.exception.ErroDeNegocioException;
import br.com.mesttra.pecasapi.service.PecaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/pecas")
public class PecaController {

	@Autowired
	PecaService service;
	
	//CREATE
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public void inserePeca(@RequestBody @Valid CriaPecaDTO pecaDto) {
		service.inserePeca(pecaDto);
	}
	
	//READ
	
	@GetMapping (path = "/{codigoBarras}")
	public MostraPecaDTO mostraPeca(@PathVariable Long codigoBarras) throws ErroDeNegocioException {
		return service.mostraPeca(codigoBarras);
	}
	
	@GetMapping
	public List<MostraPecaDTO> mostraPecas() {
		return service.mostraPecas();
	}
	
	@GetMapping (path = "/{comeco}/comeco")
	public List<MostraPecaDTO> mostraPecasPorComeco(@PathVariable String comeco) {
		return service.mostraPecasPorComeco(comeco);
	}
	
	@GetMapping (path = "/{modelo}/modelo")
	public List<MostraPecaDTO> mostraPecasPorCarro(@PathVariable String modelo) {
		return service.mostraPecasPorCarro(modelo);
	}
	
	@GetMapping (path = "/{categoria}/categoria")
	public List<MostraPecaDTO> mostraPecasPorCategoria(@PathVariable String categoria) {
		return service.mostraPecasPorCategoria(categoria);
	}
	
	//UPDATE
	
	@PutMapping (path = "/{codigoBarras}")
	@ResponseStatus (HttpStatus.ACCEPTED)
	public void atualizaPeca(@RequestBody @Valid Peca peca, @PathVariable Long codigoBarras) throws ErroDeNegocioException {
		service.atualizaPeca(peca);
	}
	
	//DELETE
	
	@DeleteMapping (path = "/{codigoBarras}")
	@ResponseStatus (HttpStatus.ACCEPTED)
	public void excluiPeca(@PathVariable Long codigoBarras) throws ErroDeNegocioException {
		service.excluiPeca(codigoBarras);
	}
}
