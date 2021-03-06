package com.example.felipe.agendaparacompromissos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Kayo on 10/05/2016.
 */
public class Banco_de_dados {

    private Manter_bd manterbd;
    private Bundle bundle;
    private Context ctx;
    private Calendar user;

    public Banco_de_dados(Context context) {//método construtor que recebe um objeto  da classe Manterbd
        manterbd = new Manter_bd(context);
        ctx = context;
    }


    public String insere_dados_tabela(String data_inicio, String hora_inicio, String hora_fim, String local, String descricao, String tipo_de_evento, String participantes, String ocorrencias, String qntd_ocorrencias, String temp, String temp2,int aux) {

        SQLiteDatabase db = manterbd.getWritableDatabase();// á variavel db recebe um método que da a permissão de escrita no banco
        ContentValues inserindo = new ContentValues();//váriavel que insere os valores da classe dos atributos da classe Livro no banco
        inserindo.put(Manter_bd.data_inicio, data_inicio);
        inserindo.put(Manter_bd.hora_inicio, hora_inicio);
        inserindo.put(Manter_bd.hora_fim, hora_fim);
        inserindo.put(Manter_bd.local, local);
        inserindo.put(Manter_bd.descricao, descricao);
        inserindo.put(Manter_bd.tipo_de_evento, tipo_de_evento);
        inserindo.put(Manter_bd.participantes, participantes);
        inserindo.put(Manter_bd.ocorrencias, ocorrencias);
        inserindo.put(Manter_bd.qntd_ocorrencias, qntd_ocorrencias);
        inserindo.put(Manter_bd.temp, temp);
        inserindo.put(Manter_bd.temp2, temp2);
        inserindo.put("aux", aux);


        Long resultado;//essa variável armazenará o  resultado do banco, caso a inserção de certo ou não
        resultado = db.insert(Manter_bd.Tabela, null, inserindo);//inserindo no banco
        db.close();//fecha a conexão do bd depois de inserir
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    /*public String insere_dados2_tabela(String participantes, String ocorrencias, String qntd_ocorrencias,int radio) {
        SQLiteDatabase db = manterbd2.getWritableDatabase();// á variavel db recebe um método que da a permissão de escrita no banco
        ContentValues inserindo2 = new ContentValues();//váriavel que insere os valores da classe dos atributos da classe Livro no banco
        inserindo2.put(Manter_bd.participantes,participantes);
        inserindo2.put(Manter_bd.ocorrencias,ocorrencias);
        inserindo2.put(Manter_bd.qntd_ocorrencias,qntd_ocorrencias);
        inserindo2.put(Manter_bd.temp,radio);
        Long resultado1;//essa variável armazenará o  resultado do banco, caso a inserção de certo ou não
        resultado1 = db.insert("compromissos", null, inserindo2);//inserindo no banco
        db.close();//fecha a conexão do bd depois de inserir
        if (resultado1 == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }*/


    public ArrayList<String> consulta_compromissos(int data_ini,int data_fim){
        SQLiteDatabase db=manterbd.getReadableDatabase();
        String sql_select="SELECT data_inicio FROM compromissos  WHERE aux >= '"+data_ini+"' and aux <= '"+data_fim+"' ";
       // String sql_select="SELECT _id,data_inicio,hora_inicio,hora_fim,local,descricao from compromisso";
        //participantes,tipo_eventos,ocorrencias,temp FROM compromisso;";
        ArrayList<String>compromisso=null;

        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor!=null && cursor.moveToFirst()){
            compromisso=new ArrayList<String>();
            do{


                compromisso.add(cursor.getString(0));
                /*compromisso.add(cursor.getString(3));
                compromisso.add(cursor.getString(4));
                compromisso.add(cursor.getString(5));
                compromisso.add(cursor.getString(6));
                compromisso.add(cursor.getString(7));
                compromisso.add(cursor.getString(8));
                compromisso.add(cursor.getString(9));
                compromisso.add(cursor.getString(10));
                compromisso.add(cursor.getString(11));
                compromisso.add(cursor.getString(12));*/


            }while (cursor.moveToNext());

        }


        return  compromisso;

    }


   public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {manterbd.Id, manterbd.data_inicio, manterbd.hora_inicio, manterbd.hora_fim, manterbd.local, manterbd.descricao, manterbd.tipo_de_evento, manterbd.ocorrencias, manterbd.qntd_ocorrencias, manterbd.participantes, manterbd.temp, manterbd.temp2,manterbd.aux};
        SQLiteDatabase db = manterbd.getReadableDatabase();
        cursor = db.query(manterbd.Tabela, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos = {manterbd.Id, manterbd.data_inicio, manterbd.hora_inicio, manterbd.hora_fim, manterbd.local, manterbd.descricao, manterbd.tipo_de_evento};
        String where = Manter_bd.Id + "=" + id;
        SQLiteDatabase db = manterbd.getReadableDatabase();
        cursor = db.query(Manter_bd.Tabela, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaDadoById2(int id) {
        Cursor cursor;
        String[] campos = {manterbd.Id, manterbd.participantes, manterbd.ocorrencias, manterbd.qntd_ocorrencias, manterbd.temp, manterbd.temp2,manterbd.aux};
        String where = Manter_bd.Id + "=" + id;
        SQLiteDatabase db = manterbd.getReadableDatabase();
        cursor = db.query(Manter_bd.Tabela, campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public void alteraRegistro(int id, String data_inicio, String hora_inicio, String hora_fim, String local, String descricao, String tipo_de_evento, String participantes, String ocorrencias, String repeticoes, String temp, String temp2) {
        ContentValues valores;
        String where;
        SQLiteDatabase db = manterbd.getWritableDatabase();
        where = Manter_bd.Id + "=" + id;
        valores = new ContentValues();
        valores.put(Manter_bd.data_inicio, data_inicio);
        valores.put(Manter_bd.hora_inicio, hora_inicio);
        valores.put(Manter_bd.hora_fim, hora_fim);
        valores.put(Manter_bd.local, local);
        valores.put(Manter_bd.descricao, descricao);
        valores.put(Manter_bd.tipo_de_evento, tipo_de_evento);
        valores.put(Manter_bd.participantes, participantes);
        valores.put(Manter_bd.ocorrencias, ocorrencias);
        valores.put(Manter_bd.qntd_ocorrencias, repeticoes);
        valores.put(Manter_bd.temp, temp);
        valores.put(Manter_bd.temp2, temp2);

        db.update(Manter_bd.Tabela, valores, where, null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = Manter_bd.Id + "=" + id;
        SQLiteDatabase db = manterbd.getReadableDatabase();
        db.delete(Manter_bd.Tabela, where, null);
        db.close();
    }


    public void expurgar_compromissos(int data_ini, int data_fim) {

       String where = " DELETE FROM compromissos WHERE aux >= '"+data_ini+"' and aux <= '"+data_fim+"'";
        SQLiteDatabase db = manterbd.getReadableDatabase();
        db.execSQL(where);
         db.close();
    }

    public void pesquisar_compromissos(int data_ini,int data_fim){
        String where = " SELECT data_ini FROM compromissos WHERE aux >= '"+data_ini+"' and aux <= '"+data_fim+"'";
        SQLiteDatabase db = manterbd.getReadableDatabase();
        db.execSQL(where);
        db.close();

    }


}













