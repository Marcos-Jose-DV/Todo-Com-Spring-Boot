package br.com.descomplica.projeto.documentacao.repository;

import br.com.descomplica.projeto.documentacao.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {

}
