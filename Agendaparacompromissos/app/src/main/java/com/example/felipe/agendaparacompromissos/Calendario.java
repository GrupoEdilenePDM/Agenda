package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendario extends AppCompatActivity {
    private CalendarView calendario;
    private Button bt_compromisso;
    private Button bt_agendar;
    private String data_compromisso;
    private  Calendar user;
    private Button bt_expulgar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario = (CalendarView) findViewById(R.id.calendario);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int ano, int mes, int dia) {
                Integer.toString(dia);
                int meses = mes + 1;
                Integer.toString(meses);
                Integer.toString(ano);

                user = new GregorianCalendar(ano,mes,(dia+1));//pega a  data desejada

                data_compromisso = dia + "/" + meses + "/" + ano;
                Toast.makeText(getApplicationContext(), data_compromisso, Toast.LENGTH_SHORT).show();
            }
        });



        bt_agendar=(Button)findViewById(R.id.bt_agendar);
        bt_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = null;


            //chamando a classe caledar para ver se a data ja se passou
                Calendar now = new GregorianCalendar();
                if (data_compromisso == null) { //se não selecionou uma data
                    Toast.makeText(getApplicationContext(), "Selecione uma data", Toast.LENGTH_SHORT).show();
                } else if (user.before(now)) {// se data selecionada ja se passou
                        Toast.makeText(getApplicationContext(), "Essa data ja se passou selecione uma atual ou posterior !!", Toast.LENGTH_SHORT).show();

                                             } else {// se a data for atual ou posterior chama a  outra tela
                                            Intent intent = new Intent(Calendario.this, Tela_de_cadastro.class);
                                            intent.putExtra("data_compromisso", data_compromisso);
                                            startActivity(intent);
                                            onPause();
                                                 }


                }
            }

            );
            bt_compromisso=(Button) findViewById(R.id.bt_compromisso);

            bt_compromisso.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                Intent intent = new Intent(Calendario.this, tela_de_opcao.class);
                intent.putExtra("data_compromisso",data_compromisso);
                startActivity(intent);
                onPause();
            }

            });

        bt_expulgar=(Button)findViewById(R.id.bt_expulgar);
        bt_expulgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Calendario.this, Tela_de_expurgo.class);
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

}