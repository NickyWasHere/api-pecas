package br.com.mesttra.pecasapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.pecasapi.entity.Peca;

@Repository
public interface PecaRepository extends CrudRepository<Peca, Long> {

}
