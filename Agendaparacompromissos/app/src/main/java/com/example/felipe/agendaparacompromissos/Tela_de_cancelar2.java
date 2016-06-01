package com.example.felipe.agendaparacompromissos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Tela_de_cancelar2 extends AppCompatActivity {


    private Spinner spinner2;
    private  Spinner spinner3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private EditText editText;
    private  EditText editText2;
    private ArrayAdapter<String> ocorrencias;
    private ArrayAdapter<String> repeticao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cancelar2);


        spinner2=(Spinner)findViewById(R.id.spinner2);
        ocorrencias=new ArrayAdapter<String>(Tela_de_cancelar2.this,android.R.layout.simple_spinner_item);
        ocorrencias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(ocorrencias);
        ocorrencias.add("diarimente");
        ocorrencias.add("semanalmente");
        ocorrencias.add("mensalmente");
        ocorrencias.add("anualmente");


        spinner3=(Spinner)findViewById(R.id.spinner3);
        repeticao=new ArrayAdapter<String>(Tela_de_cancelar2.this,android.R.layout.simple_spinner_item);
        repeticao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(repeticao);
        repeticao.add("1 dia");
        repeticao.add("1 semana");
        repeticao.add("1 mês");
        repeticao.add("1 ano");

    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        finish();
        setContentView(R.layout.activity_tela_de_cancelar2);
    }
}
