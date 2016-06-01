package com.example.felipe.agendaparacompromissos;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Tela_de_alteracao extends AppCompatActivity {
    private TextView Data_de_compromisso;
    private EditText v_data_de_compromisso;
    private TextView horario_ini;
    private TextView v_horario_ini;
    private TextView horario_fim;
    private TextView v_horario_fim;
    private TextView local;
    private EditText edit_local;
    private TextView descricao;
    private EditText edit_descricao;
    private Button bt_proxima_tela;
    private  Spinner spinner;
    private ArrayAdapter<String> tipos_eventos;
    private  Banco_de_dados banco_de_dados;
    private  String codigo;
     private int horas,minutos;
    Mascaras mask=new Mascaras() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_alteracao);

        Data_de_compromisso = (TextView) findViewById(R.id.Data_de_compromisso);
        v_data_de_compromisso = (EditText) findViewById(R.id.v_data_de_compromisso);
        v_data_de_compromisso.addTextChangedListener(mask.insert("#/#/####",v_data_de_compromisso ));
        horario_ini = (TextView) findViewById(R.id.horario_ini);
        v_horario_ini = (TextView) findViewById(R.id.v_horario_ini);
        horario_fim = (TextView) findViewById(R.id.horario_fim);
        v_horario_fim = (TextView) findViewById(R.id.v_horario_fim);
        local = (TextView) findViewById(R.id.local);
        edit_local = (EditText) findViewById(R.id.edit_local);
        descricao = (TextView) findViewById(R.id.descricao);
        edit_descricao = (EditText) findViewById(R.id.edit_descricao);
        bt_proxima_tela = (Button) findViewById(R.id.bt_proxima_tela);


        v_horario_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepicker = new TimePickerDialog(Tela_de_alteracao.this, new TimePickerDialog.OnTimeSetListener() {

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
                TimePickerDialog timepicker = new TimePickerDialog(Tela_de_alteracao.this,new TimePickerDialog.OnTimeSetListener() {

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






        spinner=(Spinner)findViewById(R.id.spinner);
        tipos_eventos=new ArrayAdapter<String>(Tela_de_alteracao.this,android.R.layout.simple_spinner_item);
        tipos_eventos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(tipos_eventos);

        banco_de_dados = new Banco_de_dados(getBaseContext());
        codigo = this.getIntent().getStringExtra("codigo");

        Cursor cursor = banco_de_dados.carregaDadoById(Integer.parseInt(codigo));
     v_data_de_compromisso.setText(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.data_inicio)));
       v_horario_ini.setText(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.hora_inicio)));
        v_horario_fim.setText(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.hora_fim)));
        edit_local.setText(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.local)));
        edit_descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.descricao)));
        tipos_eventos.add(cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.tipo_de_evento)));
        tipos_eventos.add("escola");
        tipos_eventos.add("trabalho");
        tipos_eventos.add("lazer");
        tipos_eventos.add("saúde");
        tipos_eventos.add("familia");







        bt_proxima_tela=(Button)findViewById(R.id.bt_proxima_tela);
        bt_proxima_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_inicio=v_data_de_compromisso.getText().toString();
                String hora_ini=v_horario_ini.getText().toString();
                String hora_fim=v_horario_fim.getText().toString();
                String local=edit_local.getText().toString();
                String descricao=edit_descricao.getText().toString();
                String tipo_evento_selecionado = spinner.getSelectedItem().toString();
                String tipo_de_evento=tipo_evento_selecionado;

                if(data_inicio.trim().isEmpty() ||hora_ini.trim().isEmpty()||hora_fim.trim().isEmpty()||local.trim().isEmpty()||descricao.trim().isEmpty()||tipo_evento_selecionado.trim().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Existe algum campo vazio ou vc não selecionou o tipo de evento desejado!!", Toast.LENGTH_SHORT).show();
                }else {


                    Intent intent = new Intent(Tela_de_alteracao.this, Tela_de_alteracao2.class);
                    intent.putExtra("codigo",codigo);
                    intent.putExtra("data_inicio", data_inicio);
                    intent.putExtra("hora_ini", hora_ini);
                    intent.putExtra("hora_fim", hora_fim);
                    intent.putExtra("local", local);
                    intent.putExtra("descricao", descricao);
                    intent.putExtra("tipo_de_evento", tipo_de_evento);
                    startActivity(intent);
                    onPause();

                }

            }
        });




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
        setContentView(R.layout.activity_tela_de_opcao);
    }
}
