package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.R;
import com.example.agenda.model.Pessoa;
import com.example.agenda.ui.dao.PessoaDAO;

public class FormPessoaActivity extends AppCompatActivity {

    public static final String titulo_AppBar = "Nova pessoa";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final PessoaDAO dao = new PessoaDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_pessoa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle(titulo_AppBar);

        InicializacaoDosCampos();

        ConfiguraBotaoSalvar();
    }

    private void ConfiguraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_form_pessoas_botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoaCriada = CriaPessoas();
                Salva(pessoaCriada);
            }
        });
    }

    private void InicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_form_pessoas_nome);
        campoTelefone = findViewById(R.id.activity_form_pessoas_telefone);
        campoEmail = findViewById(R.id.activity_form_pessoas_email);
    }

    private void Salva(Pessoa pessoa) {
        dao.salva(pessoa);
        finish();
    }

    @NonNull
    private Pessoa CriaPessoas() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Pessoa(nome, telefone, email);
    }
}