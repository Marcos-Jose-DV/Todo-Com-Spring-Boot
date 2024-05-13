package br.com.descomplica.projeto.documentacao.ViewModels;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

public class TarefaVM {

    @NotNull
    private String tarefaNome;

    public String getTarefaNome(){

        return tarefaNome;
    }
    public void setTarefaNome(String tarefaNome) {
        this.tarefaNome = tarefaNome;
    }
}
