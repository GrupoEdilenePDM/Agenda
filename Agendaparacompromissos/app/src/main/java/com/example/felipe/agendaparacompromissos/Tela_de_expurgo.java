package com.example.felipe.agendaparacompromissos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tela_de_expurgo extends AppCompatActivity {

    private EditText edit_data_ini;
    private  EditText edit_data_fim;
    private Button bt_eliminar;
    private Banco_de_dados banco_de_dados;
    private  int ano,mes,dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_expurgo);

        edit_data_ini=(EditText)findViewById(R.id.edit_data_ini);
        edit_data_fim=(EditText)findViewById(R.id.edit_data_fim);







        edit_data_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker=new DatePickerDialog(Tela_de_expurgo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edit_data_ini.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                },ano,mes,dia);
                    datepicker.setTitle("Selecione a  data de inicio:");
                    datepicker.show();

            }
        });



        edit_data_fim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker=new DatePickerDialog(Tela_de_expurgo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edit_data_fim.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);

                    }
                },ano,mes,dia);
                datepicker.setTitle("Selecione a  data de fim:");
                datepicker.show();

            }
        });









        bt_eliminar=(Button)findViewById(R.id.bt_eliminar);
        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //armaze dados do usuário
                String data_ini= edit_data_ini.getText().toString();
                String data_f=edit_data_fim.getText().toString();

                banco_de_dados=new Banco_de_dados(getBaseContext());

                try {
                    banco_de_dados.expurgar_compromissos(data_ini,data_f);
                    Toast.makeText(getApplicationContext(),"ok", Toast.LENGTH_SHORT).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}
