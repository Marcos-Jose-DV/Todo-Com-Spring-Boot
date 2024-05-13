package br.com.descomplica.projeto.documentacao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "tarefa_id")
	private Integer tareafaId;

	@Column(name = "tarefa_nome")
	private String tarefaNome;

	public Integer getTarefaId() {
		return tareafaId;
	}

	public void setTarefaId(Integer tareafaId) {
		this.tareafaId = tareafaId;
	}

	public String getTarefaNome() {
		return tarefaNome;
	}

	public void setTarefaNome(String tarefaNome) {
		this.tarefaNome = tarefaNome;
	}



}
