package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario2 extends AppCompatActivity {
    private CalendarView calendario;
    private String data_compromisso;
    private Button bt_compromisso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario2);

        calendario = (CalendarView) findViewById(R.id.calendario);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int ano, int mes, int dia) {
                Integer.toString(dia);
                int meses = mes + 1;
                Integer.toString(meses);
                Integer.toString(ano);


                data_compromisso = dia + "/" + meses + "/" + ano;
                Toast.makeText(getApplicationContext(), data_compromisso, Toast.LENGTH_SHORT).show();
            }
        });

        bt_compromisso=(Button) findViewById(R.id.bt_compromisso);

        bt_compromisso.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
              if(data_compromisso==null){
                  Toast.makeText(getApplicationContext(), "Escolha uma data", Toast.LENGTH_SHORT).show();
              }  else{

                Intent intent = new Intent(Calendario2.this, Tela_de_expurgo.class);
                intent.putExtra("data_inicio", data_compromisso);
                startActivity(intent);
                finish();}
            }

        });



    }
}
