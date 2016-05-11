package com.example.felipe.agendaparacompromissos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Kayo on 10/05/2016.
 */
public class Banco_de_dados {
    private Manter_bd manterbd;
    private  Bundle bundle;

    public Banco_de_dados(Context context) {//método construtor que recebe um objeto  da classe Manterbd
        manterbd = new Manter_bd(context);// esse objeto é instanciado para  receber como parâmetro a váriavel context que é o Activity
    }

    //se existe valor no parametro data_compromisso ,então o campo  valor_data recebe essa valor
    String data_compromisso=bundle.getString("data_compromisso");


    public String insere_dados_tabela(String data_inicio,String hora_inicio,String hora_fim,String local,String descricao,String participantes,String tipo_evento,String ocorrencias, String temp) {

        SQLiteDatabase db = manterbd.getWritableDatabase();// á variavel db recebe um método que da a permissão de escrita no banco
        ContentValues inserindo = new ContentValues();//váriavel que insere os valores da classe dos atributos da classe Livro no banco
        inserindo.put("data_inicio", data_inicio);
        inserindo.put("hora_inicio", hora_inicio);
        inserindo.put("hora_fim", hora_fim);
        inserindo.put("local", local);
        inserindo.put("descricao", descricao);
       // inserindo.put("participantes", participantes);
       // inserindo.put("tipo_evento", tipo_evento);
       // inserindo.put("ocorrencias", ocorrencias);
        //inserindo.put("temp", temp);
        long resultado;//essa variável armazenará o  resultado do banco, caso a inserção de certo ou não
        resultado = db.insert(Manter_bd.Tabela, null, inserindo);//inserindo no banco
        db.close();//fecha a conexão do bd depois de inserir
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


    public ArrayList<String> consulta_compromissos(){
        SQLiteDatabase db=manterbd.getReadableDatabase();
        //String sql_select="SELECT "+manterbd.Id+","+manterbd.Titulo+","+manterbd.Autor+","+manterbd.Paginas+"FROM "+manterbd.Tabela+";";
        String sql_select="SELECT _id,data_inicio,hora_inicio,hora_fim,local,descricao,participantes,tipo_eventos,ocorrencias,temp FROM compromisso;";
        Cursor cursor=db.rawQuery(sql_select,null);
        ArrayList<String>compromisso=null;
        if(cursor!=null && cursor.moveToFirst()){
            compromisso=new ArrayList<String>();
            do{

                compromisso.add(cursor.getString(0));
                compromisso.add(cursor.getString(1));
                compromisso.add(cursor.getString(2));
                compromisso.add(cursor.getString(3));
                compromisso.add(cursor.getString(4));
                compromisso.add(cursor.getString(5));
                compromisso.add(cursor.getString(6));
                compromisso.add(cursor.getString(7));
                compromisso.add(cursor.getString(8));
                compromisso.add(cursor.getString(9));
                compromisso.add(cursor.getString(10));





            }while (cursor.moveToNext());

        }


        return  compromisso;

    }
    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {manterbd.Id,manterbd.data_inicio,manterbd.hora_inicio,manterbd.hora_fim,manterbd.local,manterbd.descricao,manterbd.participantes,manterbd.tipo_evento,manterbd.ocorrencia,manterbd.temp};
        SQLiteDatabase db = manterbd.getReadableDatabase();
        cursor = db.query(manterbd.Tabela, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos = {manterbd.Id,manterbd.data_inicio,manterbd.hora_inicio,manterbd.hora_fim,manterbd.local,manterbd.descricao,manterbd.participantes,manterbd.tipo_evento,manterbd.ocorrencia,manterbd.temp};
        String where = Manter_bd.Id + "=" + id;
        SQLiteDatabase db = manterbd.getReadableDatabase();
        cursor = db.query(Manter_bd.Tabela,campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor; }




    public void alteraRegistro(int id,String data_inicio,String hora_inicio,String hora_fim,String local,String descricao,String participantes,String tipo_evento,String ocorrencias, String temp){
        ContentValues valores;
        String where;
        SQLiteDatabase db = manterbd.getWritableDatabase();
        where = Manter_bd.Id + "=" + id;
        valores = new ContentValues();
        valores.put(Manter_bd.data_inicio, data_inicio);
        valores.put(Manter_bd.hora_inicio, hora_inicio);
        valores.put(Manter_bd.hora_fim,hora_fim);
        valores.put(Manter_bd.local,local);
        valores.put(Manter_bd.descricao,descricao);
        valores.put(Manter_bd.participantes,participantes);
        valores.put(Manter_bd.tipo_evento,tipo_evento);
        valores.put(Manter_bd.ocorrencia,ocorrencias);
        valores.put(Manter_bd.temp,temp);
        db.update(Manter_bd.Tabela,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = Manter_bd.Id + "=" + id;
        SQLiteDatabase db = manterbd.getReadableDatabase();
        db.delete(Manter_bd.Tabela,where,null); db.close();
    }
}








