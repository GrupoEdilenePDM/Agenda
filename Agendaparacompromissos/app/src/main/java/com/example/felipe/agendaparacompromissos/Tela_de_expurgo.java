package com.example.felipe.agendaparacompromissos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Tela_de_expurgo extends AppCompatActivity {

    private EditText edit_data_ini;
    private  EditText edit_data_fim;
    private Button bt_eliminar;
    private Button bt_pesquisar;
    private Banco_de_dados banco_de_dados;
    private int data_ini,data_fim;
    private int ano,mes,dia;
    private ListView lista_de_compromisso;
    private  ArrayList<String> compromisso=null;
   private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_expurgo);

        edit_data_ini=(EditText)findViewById(R.id.edit_data_ini);
        edit_data_fim=(EditText)findViewById(R.id.edit_data_fim);
        lista_de_compromisso = (ListView) findViewById(R.id.lista_de_comp);








        edit_data_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepicker = new DatePickerDialog(Tela_de_expurgo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String dia_str = Integer.toString(dayOfMonth);
                        String mes_str = Integer.toString(monthOfYear + 1);
                        String ano_str = Integer.toString(year);
                        edit_data_ini.setText(dia_str + "/" + mes_str + "/" + ano_str);

                        dia = dayOfMonth;
                        mes = (monthOfYear + 1);
                        ano = year;

                        //para comparar com a data do banco(aux)
                        if (dayOfMonth < 10 && monthOfYear < 10) {
                            String data_str;
                            data_str = ano + "" + 0 + "" + (mes) + "" + 0 + "" + dia;
                            //convertendo para adicionar ao banco
                            data_ini = Integer.parseInt(data_str);
                        } else if (monthOfYear < 10) {
                            String data_str;
                            data_str = ano + "" + 0 + "" + (mes) + "" + dia;
                            //convertendo para adicionar ao banco
                            data_ini = Integer.parseInt(data_str);
                        } else if (dayOfMonth < 10) {
                            String data_str;
                            data_str = ano + "" + (mes) + "" + 0 + "" + dia;
                            //convertendo para adicionar ao banco
                            data_ini = Integer.parseInt(data_str);
                        } else {
                            String data_str;
                            data_str = ano + "" + (mes) + "" + dia;
                            //convertendo para adicionar ao banco
                            data_ini = Integer.parseInt(data_str);
                        }
                    }
                }, ano, mes, dia);
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
                        String dia_str=Integer.toString(dayOfMonth);
                        String mes_str=Integer.toString(monthOfYear+1);
                        String ano_str=Integer.toString(year);
                        edit_data_fim.setText(dia_str+ "/" + mes_str + "/" + ano_str);

                        dia=dayOfMonth;
                        mes=(monthOfYear+1);
                        ano=year;

                        //para comparar com a data do banco(aux)
                        if(dayOfMonth<10 && monthOfYear<10){
                            String data_str;
                            data_str=ano+""+0+""+(mes)+""+0+""+dia;
                            //convertendo para adicionar ao banco
                            data_fim=Integer.parseInt(data_str);
                        }else if (monthOfYear<10){
                            String data_str;
                            data_str=ano+""+0+""+(mes)+""+dia;
                            //convertendo para adicionar ao banco
                            data_fim=Integer.parseInt(data_str);
                        }else if(dayOfMonth<10){
                            String data_str;
                            data_str=ano+""+(mes)+""+0+""+dia;
                            //convertendo para adicionar ao banco
                            data_fim=Integer.parseInt(data_str);
                        }else {
                            String data_str;
                            data_str = ano + "" + (mes) + "" + dia;
                            //convertendo para adicionar ao banco
                            data_fim = Integer.parseInt(data_str);
                        }

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
                int data_inicio= data_ini;
                int data_f=data_fim;
                String a=Integer.toString(data_inicio);
                String b=Integer.toString(data_f);


                banco_de_dados=new Banco_de_dados(getBaseContext());
                banco_de_dados.expurgar_compromissos(data_inicio, data_f);
                Toast.makeText(getApplicationContext(),"Datas deletadas de "+a+" até"+b, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),b, Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(Tela_de_expurgo.this, tela_de_opcao.class);
                startActivity(intent);
                onPause();*/

            }
        });

        bt_pesquisar=(Button)findViewById(R.id.bt_pesquisar);
        bt_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //armaze dados do usuário
                int data_inicio = data_ini;
                int data_f = data_fim;
                //String a = Integer.toString(data_inicio);
                //String b = Integer.toString(data_f);


                //banco_de_dados = new Banco_de_dados(getBaseContext());
                //compromisso = banco_de_dados.consulta_compromissos(data_inicio, data_f);
                //Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), b, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Tela_de_expurgo.this, tela_de_opcao.class);
                intent.putExtra("data_ini", data_inicio);
                intent.putExtra("data_f", data_f);
                startActivity(intent);
                finish();

            }
        });






    }
  //@Override
/*    public void onPause() {
        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        finish();
        setContentView(R.layout.activity_calendario);
    }*/
}
