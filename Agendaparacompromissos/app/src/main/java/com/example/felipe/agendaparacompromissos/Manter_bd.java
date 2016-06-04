package com.example.felipe.agendaparacompromissos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Kayo on 10/05/2016.
 */
public class Manter_bd extends SQLiteOpenHelper {
        //váriaveis privada e estáticas para toda  a classe
        public static final String nome_bd="Agenda";
        public static final int versao_bd=1;// é importante para decidir a versão da base de dados com a ajuda do método onUpgradepublic static final String Id="_id";
        public  static  final String Tabela="compromissos";
        public static final String Id="_id";
        public static final String data_inicio="data_inicio";
        public static  final String hora_inicio="hora_inicio";
        public static  final String hora_fim="hora_fim";
        public static  final String local="local";
        public static  final String descricao="descricao";
         public static  final String tipo_de_evento="tipo_de_evento";
        public static  final String participantes="participantes";
        public static  final String ocorrencias="ocorrencias";
      public static  final String qntd_ocorrencias="qntd_ocorrencias";
       public static  final String temp="temp";
         public static  final String temp2="temp2";
        public  static  final String aux="aux";




        public Manter_bd(Context context) {
            super(context, nome_bd, null, versao_bd);
        }//esse construtor vai passar para a supler classe os atributos como nome  e  versão do banco



    @Override
        public void onCreate(SQLiteDatabase db) {//esse método cria a base dados com o nome estabelecido acima , caso não exista essa base de dados.

        String criando_bd="CREATE TABLE compromissos( "+
                            Id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                            "data_inicio TEXT,"+
                            hora_inicio+" TEXT,"+
                            hora_fim+" TEXT,"+
                            local+" TEXT,"+
                            descricao+" TEXT,"+
                            tipo_de_evento+" TEXT,"+
                           " participantes TEXT,"+
                            "ocorrencias TEXT,"+
                            "qntd_ocorrencias TEXT,"+
                             "temp TEXT,"+
                               "temp2 TEXT,"+
                                "aux INTEGER);";
        //PEGO O PARÂMETRO PARA CHAMAR UM FUNÇÃO
            db.execSQL(criando_bd);//essa função executa o comando sql que cria o banco

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String exclui_bd="DROP TABLE IF EXISTS"+Tabela;
            db.execSQL(exclui_bd);//deleta a tabela livro
            onCreate(db);//cria de novo a tabela

            //o  método execSQL() não possui retorno por isso pode ser usado  dentro de  métodos  void
        }



}





