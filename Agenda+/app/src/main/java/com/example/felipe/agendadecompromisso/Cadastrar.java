package com.example.felipe.agendadecompromisso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {
    private TextView valor_data;
    private TextView valor_h_i;
    private EditText hora_fim;
    private EditText local;
    private EditText descricao;
    private EditText participantes;
    private Button bt_cadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        valor_data=(TextView)findViewById(R.id.valor_data);
        hora_fim=(EditText)findViewById(R.id.editText2);
        local=(EditText)findViewById(R.id.editText3);
        descricao=(EditText)findViewById(R.id.editText4);
    participantes=(EditText)findViewById(R.id.editText5);

        valor_h_i=(TextView)findViewById(R.id.valor_h_i);
        valor_h_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hora vai vir aqui", Toast.LENGTH_SHORT).show();
            }
        });




        Bundle bundle=getIntent().getExtras();
        //se existe valor no parametro data_compromisso ,então o campo  valor_data recebe essa valor
            String data_compromisso=bundle.getString("data_compromisso");
            valor_data.setText(data_compromisso);


        bt_cadastrar=(Button)findViewById(R.id.bt_cadastrar);
            bt_cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            });
    }

    private void numberPickerDialog(){
        NumberPicker numero=new NumberPicker(this);
        numero.setMaxValue(24);
        numero.setMinValue(1);
        NumberPicker.OnValueChangeListener  numero_escolhido= new  NumberPicker.OnValueChangeListener();
        {


        };

    }
}
