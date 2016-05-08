package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela_de_opcao extends AppCompatActivity {
    private TextView titulo;
    private Button bt_agendar;
    private Button bt_alterar;
    private Button bt_cancelar;
    private  String data_compromisso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_opcao);

        titulo=(TextView)findViewById(R.id.titulo);
        Bundle bundle=getIntent().getExtras();
        data_compromisso=bundle.getString("data_compromisso");
        titulo.setText("Evento do dia: "+data_compromisso);



        bt_agendar=(Button)findViewById(R.id.bt_agendar);
        bt_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_de_opcao.this, Tela_de_cadastro.class);
                intent.putExtra("data_compromisso", data_compromisso);
                startActivity(intent);
                finish();

            }
        });

        bt_alterar=(Button)findViewById(R.id.bt_alterar);
        bt_alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_de_opcao.this, Tela_de_alteracao.class);
                startActivity(intent);
                finish();

            }
        });

        bt_cancelar=(Button)findViewById(R.id.bt_cancelar);
        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_de_opcao.this, Tela_de_cancelar.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
