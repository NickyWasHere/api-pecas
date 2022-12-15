package br.com.mesttra.pecasapi.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import br.com.mesttra.pecasapi.dto.*;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus (HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler ({ErroDeNegocioException.class})
	public @ResponseBody ResponseDTO handleErroDeNegocio(Exception e) {
		return new ResponseDTO(e.getMessage());
	}
	
	@ResponseStatus (HttpStatus.BAD_REQUEST)
	@ExceptionHandler ({MethodArgumentNotValidException.class})
	public @ResponseBody List<ValidationResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		List<ValidationResponseDTO> resposta = new ArrayList<>();
		
		for (ObjectError er : e.getBindingResult().getAllErrors()) {
			String erro = er.getCodes()[0];
			String nomeAtributo = erro.substring(erro.lastIndexOf(".") + 1, erro.length());
			
			resposta.add(new ValidationResponseDTO(nomeAtributo, er.getDefaultMessage()));
		}
		
		return resposta;
	}
	
	@ResponseStatus (HttpStatus.BAD_REQUEST)
	@ExceptionHandler ({HttpMessageNotReadableException.class})
	public @ResponseBody ResponseDTO handleHttpMessageNotReadable() {
		return new ResponseDTO("Categoria deve ser FUNILARIA, MOTOR, PERFORMANCE ou SOM");
	}
	
	@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler ({Exception.class})
	public @ResponseBody ResponseDTO handleException(Exception e) {
		return new ResponseDTO("Ocorreu um erro interno: " + e.getMessage());
	}
}
