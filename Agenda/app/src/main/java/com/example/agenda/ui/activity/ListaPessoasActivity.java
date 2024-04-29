package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.ui.dao.PessoaDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaPessoasActivity extends AppCompatActivity {

    public static final String titulo_AppBar = "Lista de pessoas";
    private final PessoaDAO dao = new PessoaDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);

        setTitle(titulo_AppBar);

        ConfiguraFABNovaPessoa();
    }

    private void ConfiguraFABNovaPessoa() {
        FloatingActionButton botaoNovaPessoa = findViewById(R.id.activity_lista_pessoas_fab_nova_pessoa);
        botaoNovaPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbreFormularioPessoaActivity();
            }
        });
    }

    private void AbreFormularioPessoaActivity() {
        startActivity(new Intent(this, FormPessoaActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ConfiguraLista();
    }

    private void ConfiguraLista() {
        ListView listaPessoas = findViewById(R.id.activity_lista_pessoas_listview);
        listaPessoas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
