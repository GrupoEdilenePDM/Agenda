package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Tela_de_alteracao extends AppCompatActivity {
    private TextView Data_de_compromisso;
    private TextView v_data_de_compromisso;
    private TextView horario_ini;
    private TextView v_horario_ini;
    private TextView horario_fim;
    private TextView v_horario_fim;
    private TextView local;
    private EditText edit_local;
    private TextView descricao;
    private EditText edit_descricao;
    private Button bt_proxima_tela;
    private EditText edit_tipo_evento;
    private  Spinner spinner;
    private ArrayAdapter<String> tipos_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_alteracao);

        spinner=(Spinner)findViewById(R.id.spinner);
        tipos_eventos=new ArrayAdapter<String>(Tela_de_alteracao.this,android.R.layout.simple_spinner_item);
        tipos_eventos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(tipos_eventos);
        tipos_eventos.add("escola");
        tipos_eventos.add("trabalho");
        tipos_eventos.add("lazer");
        tipos_eventos.add("saúde");
        tipos_eventos.add("familia");

        bt_proxima_tela=(Button)findViewById(R.id.bt_proxima_tela);
        bt_proxima_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_de_alteracao.this, Tela_de_alteracao2.class);
                startActivity(intent);
                finish();


            }
        });




    }
}
