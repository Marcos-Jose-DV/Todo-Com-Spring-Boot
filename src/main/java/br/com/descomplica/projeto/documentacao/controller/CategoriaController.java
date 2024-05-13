package br.com.descomplica.projeto.documentacao.controller;

import java.util.List;

import br.com.descomplica.projeto.documentacao.ViewModels.TarefaVM;
import br.com.descomplica.projeto.documentacao.entity.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.descomplica.projeto.documentacao.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tarefa")
public class CategoriaController {
	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	@Operation(summary="Listar todas as tarefas", description  = "Listagem de Tarefas")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
			  @ApiResponse(responseCode = "400", description = "Requisição Inválida"), 
			  @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."), 
			  @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
	public ResponseEntity<List<Tarefa>> getAll(){
		List<Tarefa> tarefas = tarefaService.getAll();
		if(!tarefas.isEmpty())
			return new ResponseEntity<>(tarefas, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> getById(@PathVariable Integer id) {
		Tarefa tarefa = tarefaService.getById(id);
		if(tarefa != null)
			return new ResponseEntity<>(tarefa, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> saveCategoria(@RequestBody TarefaVM vm) {

		Tarefa tarefa =  new Tarefa();
		tarefa.setTarefaNome(vm.getTarefaNome());
		return new ResponseEntity<>(tarefaService.saveCategoria(tarefa), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateCategoria(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
		Tarefa tarefaAtualizada = tarefaService.updateCategoria(id, tarefa);
		if(tarefaAtualizada != null)
			return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
		if(tarefaService.deleteCategoria(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
