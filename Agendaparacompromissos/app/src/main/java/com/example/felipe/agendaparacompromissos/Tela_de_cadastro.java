package com.example.felipe.agendaparacompromissos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Tela_de_cadastro extends AppCompatActivity {
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
    private  int horas;
    private  int minutos;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);
        Data_de_compromisso = (TextView) findViewById(R.id.Data_de_compromisso);
        v_data_de_compromisso = (TextView) findViewById(R.id.v_data_de_compromisso);
        horario_ini = (TextView) findViewById(R.id.horario_ini);
        v_horario_ini = (TextView) findViewById(R.id.v_horario_ini);
        v_horario_fim = (TextView) findViewById(R.id.v_horario_fim);
        local = (TextView) findViewById(R.id.local);
        edit_local = (EditText) findViewById(R.id.edit_local);
        descricao = (TextView) findViewById(R.id.descricao);
        edit_descricao = (EditText) findViewById(R.id.edit_descricao);
        bt_proxima_tela = (Button) findViewById(R.id.bt_proxima_tela);

        Bundle bundle=getIntent().getExtras();
        //se existe valor no parametro data_compromisso ,então o campo  valor_data recebe essa valor
        String data_compromisso=bundle.getString("data_compromisso");
        v_data_de_compromisso.setText(data_compromisso);


                spinner=(Spinner)findViewById(R.id.spinner);
                tipos_eventos=new ArrayAdapter<String>(Tela_de_cadastro.this,android.R.layout.simple_spinner_item);
                tipos_eventos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(tipos_eventos);
                tipos_eventos.add("escola");
                tipos_eventos.add("trabalho");
                tipos_eventos.add("lazer");
                tipos_eventos.add("saúde");
                tipos_eventos.add("familia");


        v_horario_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepicker = new TimePickerDialog(Tela_de_cadastro.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hora, int minuto) {
                        horas = hora;
                        minutos = minuto;
                        v_horario_ini.setText(horas + ":" + minutos);

                    }
                }, horas, minutos, true);
                timepicker.setTitle("Selecione o horário de inicio:");
                timepicker.show();


            }
        });


        v_horario_fim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepicker = new TimePickerDialog(Tela_de_cadastro.this,new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hora, int minuto) {
                        horas=hora;
                        minutos=minuto;
                        v_horario_fim.setText(horas + ":" + minutos);

                    }
                },horas,minutos,true);
                timepicker.setTitle("Selecione o horário de fim:");
                timepicker.show();


            }
        });







        bt_proxima_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_inicio=v_data_de_compromisso.getText().toString();
                String horario_ini=v_horario_ini.getText().toString();
                String horario_fim=v_horario_fim.getText().toString();
                String local=edit_local.getText().toString();
                String descricao=edit_descricao.getText().toString();


                if(data_inicio.trim().isEmpty() ||horario_ini.trim().isEmpty()||horario_fim.trim().isEmpty()||local.trim().isEmpty()||descricao.trim().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Existe algum campo vazio!!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(Tela_de_cadastro.this, Tela_de_cadastro2.class);
                    startActivity(intent);
                    finish();


                }


            }
        });
    }
}