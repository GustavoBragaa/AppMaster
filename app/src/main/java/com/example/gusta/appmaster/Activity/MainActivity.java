package com.example.gusta.appmaster.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gusta.appmaster.R;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrarLivros;
    private Button btListarLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarLivros = (Button) findViewById(R.id.btCadastrarLivros);
        btCadastrarLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chamaCadastrarLivros = new Intent(MainActivity.this, CadastrarLivrosActivity.class);
                startActivity(chamaCadastrarLivros);
            }
        });


        btListarLivros = (Button) findViewById(R.id.btListarLivros);
        btListarLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chamaListarlivros = new Intent(MainActivity.this, ListarLivrosActivity.class);
                startActivity(chamaListarlivros);
            }


        });
    }
}

