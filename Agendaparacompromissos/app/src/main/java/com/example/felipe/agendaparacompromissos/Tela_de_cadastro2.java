package com.example.felipe.agendaparacompromissos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tela_de_cadastro2 extends AppCompatActivity {
    Mascaras mask=new Mascaras() ;
    private Spinner spinner2;
    private Spinner spinner3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private EditText editText;
    private EditText editText2;
    private Button bt_cadastrar;
    private Button bt_voltar;
    private ArrayAdapter<String> ocorrencias;
    private ArrayAdapter<String> repeticao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        bt_cadastrar = (Button) findViewById(R.id.bt_cadastrar);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        editText2.addTextChangedListener(mask.insert("##/##/####",editText2));

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ocorrencias = new ArrayAdapter<String>(Tela_de_cadastro2.this, android.R.layout.simple_spinner_item);
        ocorrencias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(ocorrencias);
        ocorrencias.add("diarimente");
        ocorrencias.add("semanalmente");
        ocorrencias.add("mensalmente");
        ocorrencias.add("anualmente");


        spinner3 = (Spinner) findViewById(R.id.spinner3);
        repeticao = new ArrayAdapter<String>(Tela_de_cadastro2.this, android.R.layout.simple_spinner_item);
        repeticao.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(repeticao);
        repeticao.add("1 dia");
        repeticao.add("1 semana");
        repeticao.add("1 mês");
        repeticao.add("1 ano");


        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num_ocorrencias;
                String data_final;
                num_ocorrencias=editText.getText().toString();
                data_final=editText2.getText().toString();
                if (radioButton1.isChecked()) {
                        if (num_ocorrencias.trim().isEmpty()) {
                         Toast.makeText(getApplicationContext(), "Preencha o número de ocorrências !!", Toast.LENGTH_SHORT).show();
                         } else {
                        Toast.makeText(getApplicationContext(), "Cadastrado", Toast.LENGTH_SHORT).show();
                              }

                } else if (radioButton2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Cadastrado", Toast.LENGTH_SHORT).show();
                } else if (radioButton3.isChecked()) {
                            if (data_final.trim().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Preencha com a data final !!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Cadastrado", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(getApplicationContext(), "Marque alguma opção acima !!!", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}
