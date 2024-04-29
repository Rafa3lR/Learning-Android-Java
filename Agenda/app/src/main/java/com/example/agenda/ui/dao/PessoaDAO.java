package com.example.agenda.ui.dao;

import com.example.agenda.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private final static List<Pessoa> pessoas = new ArrayList<>();

    public void salva(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public List<Pessoa> todos() {
        return new ArrayList<>(pessoas);
    }
}
