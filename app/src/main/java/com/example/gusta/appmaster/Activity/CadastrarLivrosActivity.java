package com.example.gusta.appmaster.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gusta.appmaster.DAO.FireBase;
import com.example.gusta.appmaster.Entidades.Livros;
import com.example.gusta.appmaster.R;
import com.google.firebase.database.DatabaseReference;

public class CadastrarLivrosActivity extends AppCompatActivity {

    private Button btCadastrar, btVoltarTela;
    private EditText edtNomeLivro, edtGenero, edtAutor;
    private Livros livros;
    private DatabaseReference firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livros);


        edtNomeLivro = (EditText) findViewById(R.id.edtNomeLivro);
        edtGenero = (EditText) findViewById(R.id.edtGenero);
        edtAutor = (EditText) findViewById(R.id.edtAutor);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btVoltarTela = (Button) findViewById(R.id.btVoltarTela);


        btVoltarTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltaTela = new Intent(CadastrarLivrosActivity.this, MainActivity.class);
                startActivity(voltaTela);
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                livros = new Livros();
                livros.setLivro(edtNomeLivro.getText().toString());
                livros.setGenero(edtGenero.getText().toString());
                livros.setAutor(edtAutor.getText().toString());


                salvarLivros(livros);
            }
        });

    }

    private boolean salvarLivros(Livros livros) {
        try {
            firebase = FireBase.getFireBase().child("addlivros");
            firebase.child(livros.getLivro()).setValue(livros);
            Toast.makeText(CadastrarLivrosActivity.this, "Livro inserido com sucesso", Toast.LENGTH_SHORT).show();

            Intent voltaTela = new Intent(CadastrarLivrosActivity.this, MainActivity.class);
            startActivity(voltaTela);

            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
