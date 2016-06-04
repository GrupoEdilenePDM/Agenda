package com.example.felipe.agendaparacompromissos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manipulando_eventos extends AppCompatActivity {
    private Button bt_concluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulando_eventos);

        bt_concluir=(Button)findViewById(R.id.bt_concluir);


        bt_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manipulando_eventos.this, Tela_de_cadastro.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
