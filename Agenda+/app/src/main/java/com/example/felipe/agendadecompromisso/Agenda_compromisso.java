package com.example.felipe.agendadecompromisso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class Agenda_compromisso extends AppCompatActivity {
      private   CalendarView calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_compromisso);

        calendario=(CalendarView)findViewById(R.id.calendario);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int ano, int mes, int dia) {
                Integer.toString(dia);
                Integer.toString(mes);
                Integer.toString(ano);
                String data_compromisso=dia+"/"+mes+"/"+ano;
                Toast.makeText(getApplicationContext(),data_compromisso,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Agenda_compromisso.this, Cadastrar.class);
                intent.putExtra("data_compromisso", data_compromisso);
                startActivity(intent);
                finish();

            }
        });


    }
}
