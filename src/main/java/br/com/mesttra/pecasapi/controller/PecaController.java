package br.com.mesttra.pecasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.mesttra.pecasapi.dto.CriarPecaDTO;
import br.com.mesttra.pecasapi.dto.MostrarPecaDTO;
import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.exception.ErroDeNegocioException;
import br.com.mesttra.pecasapi.service.PecaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/pecas")
public class PecaController {

	@Autowired
	PecaService service;
	
	@PostMapping
	public void cadastrarPeca(@RequestBody @Valid CriarPecaDTO pecaDto) {
		service.cadastrarPeca(pecaDto);
	}
	
	@GetMapping (path = "/{codigoBarras}")
	public MostrarPecaDTO verPeca(@PathVariable Long codigoBarras) throws ErroDeNegocioException {
		return service.verPeca(codigoBarras);
	}
	
	@GetMapping
	public List<MostrarPecaDTO> verPecas() {
		return service.verPecas();
	}
	
	@PutMapping (path = "/{codigoBarras}")
	public void atualizarPeca(@RequestBody @Valid Peca peca, @PathVariable Long codigoBarras) throws ErroDeNegocioException {
		service.atualizarPeca(peca);
	}
	
	@DeleteMapping (path = "/{codigoBarras}")
	public void excluirPeca(@PathVariable Long codigoBarras) throws ErroDeNegocioException {
		service.excluirPeca(codigoBarras);
	}
}
