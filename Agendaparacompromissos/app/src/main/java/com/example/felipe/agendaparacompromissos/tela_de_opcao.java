package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tela_de_opcao extends AppCompatActivity {
    private TextView titulo;
    private Button bt_agendar;
    private Button bt_voltar;
    private ListView lista;
    private  Cursor cursor;
    private ArrayAdapter <String> adaptador;
    private ArrayList<String> compromisso=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_opcao);

        lista = (ListView) findViewById(R.id.lista_de_compromissos);
            int data_ini=0,data_f=0;

        Bundle bundle=getIntent().getExtras();
        if(bundle.containsKey("data_ini") && bundle.containsKey("data_f")){

             data_ini=bundle.getInt("data_ini");
             data_f=bundle.getInt("data_f");
        }


        //int a=Integer.parseInt(data_ini);
        //int b=Integer.parseInt(data_f);

       // Toast.makeText(getApplicationContext(),"Selecione um compromisso para alterar ou deletar.", Toast.LENGTH_SHORT).show();

        titulo=(TextView)findViewById(R.id.titulo);
        titulo.setText(" Lista de Eventos Agendados:");







        Banco_de_dados banco_de_dados = new Banco_de_dados(this);
        compromisso = banco_de_dados.consulta_compromissos(data_ini,data_f);

        if(compromisso==null){
            Toast.makeText(getApplicationContext(), "Não existe data dentro desse intervalo ou não tem compromisso cadastrado", Toast.LENGTH_SHORT).show();
        }
        else if(compromisso!=null) {

//exibe atraves do arrayadapter a consulta com base  no intervalo estabelecido pelo usuário
            adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, compromisso);
            lista.setAdapter(adaptador);//mostra na tela
//essea função  carregaDados() é responsavel por trazer todos os dados  do compromisso selecionado na consulta anterior
            cursor = banco_de_dados.carregaDados();


        }
//----------------------------------------------------------
       lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String codigo;

               cursor.moveToPosition(position);
               codigo = cursor.getString(cursor.getColumnIndexOrThrow(Manter_bd.Id));
               Intent intent = new Intent(tela_de_opcao.this, Tela_de_alteracao.class);
               intent.putExtra("codigo", codigo);
               startActivity(intent);
               onPause();
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
        setContentView(R.layout.activity_calendario);
    }
}
