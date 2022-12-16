package br.com.mesttra.pecasapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.pecasapi.entity.Peca;
import br.com.mesttra.pecasapi.enums.Categoria;

@Repository
public interface PecaRepository extends CrudRepository<Peca, Long> {
	List<Peca> findByNomeStartsWith(String comeco);
	
	List<Peca> findByModeloCarro(String modelo);
	
	List<Peca> findByCategoria(Categoria categoria);
}
