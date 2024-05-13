package br.com.descomplica.projeto.documentacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.descomplica.projeto.documentacao.entity.Tarefa;
import br.com.descomplica.projeto.documentacao.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {
	@Autowired
	TarefaRepository tarefaRepository;

	public List<Tarefa> getAll(){
		return tarefaRepository.findAll();
	}
	public Tarefa getById(Integer id) {
		return tarefaRepository.findById(id).orElse(null) ;
	}
	
	public Tarefa saveCategoria(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public Tarefa updateCategoria(Integer id, Tarefa tarefa) {
		Tarefa tarefaAtualizada = tarefaRepository.findById(id).orElse(null);
		if(tarefaAtualizada != null) {
			tarefaAtualizada.setTarefaNome(tarefa.getTarefaNome());
			return tarefaRepository.save(tarefaAtualizada);
		}else {
			return null;
		}
	}

	public Boolean deleteCategoria(Integer id) {
		Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
		if(tarefa != null) {
			tarefaRepository.delete(tarefa);
			return true;
		}else {
			return false;
		}
	}
}
