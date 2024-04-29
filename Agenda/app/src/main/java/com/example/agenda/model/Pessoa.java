package com.example.agenda.model;

import androidx.annotation.NonNull;

public class Pessoa {
    private final String nome;
    private final String telefone;
    private final String email;

    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + "\n" + telefone + "\n" + email + "\n";
    }
}
