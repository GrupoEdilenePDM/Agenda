package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class tela_de_opcao extends AppCompatActivity {
    private TextView titulo;
    private Button bt_agendar;
    private Button bt_voltar;
    private ListView lista_de_compromissos;
    private  Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_opcao);

        Toast.makeText(getApplicationContext(),"Selecione um compromisso para alterar ou deletar.", Toast.LENGTH_SHORT).show();

        titulo=(TextView)findViewById(R.id.titulo);
        titulo.setText(" Lista de Eventos Agendados:");






        Banco_de_dados banco_de_dados = new Banco_de_dados(getBaseContext());
        cursor = banco_de_dados.carregaDados();



      String[] nomeCampos = new String[] {Manter_bd.data_inicio,Manter_bd.hora_inicio, Manter_bd.descricao,Manter_bd.tipo_de_evento,Manter_bd.ocorrencias,Manter_bd.qntd_ocorrencias,Manter_bd.participantes,Manter_bd.temp,Manter_bd.temp2};
        int[] idViews = new int[] {R.id.v_data_inicio,R.id.v_horario_inicial, R.id.v_descricao,R.id.v_tipo_do_evento,R.id.spinner2,R.id.spinner3,R.id.participantes,R.id.radio,R.id.textView1};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,R.layout.activity_grid_layout,cursor,nomeCampos,idViews, 0);
        lista_de_compromissos = (ListView)findViewById(R.id.lista_de_compromissos);
        lista_de_compromissos.setAdapter(adaptador);

//----------------------------------------------------------
       lista_de_compromissos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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




        bt_voltar=(Button)findViewById(R.id.bt_voltar);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_de_opcao.this, Calendario.class);
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
