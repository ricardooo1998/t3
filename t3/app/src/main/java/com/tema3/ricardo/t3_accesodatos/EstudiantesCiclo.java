package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EstudiantesCiclo extends AppCompatActivity {
    private MyDBAdapter dbAdapter;
    EditText buscarCiclo;
    Button buscar;
    Button cancelar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_ciclo);
        cancelar = (Button) findViewById(R.id.cancerlarCiclos);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultar.class);
                startActivity(i);
            }
        });

        buscar = (Button) findViewById(R.id.buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarAlumnosCiclo(buscar.getText().toString());
            }
        });
    }

    private void buscarAlumnosCiclo(String ciclo)
    {
        resultado = (TextView) findViewById(R.id.resultado);
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        ArrayList<String> alumnos = dbAdapter.estudiantesCiclo(ciclo);
        this.resultado.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            resultado.setText(resultado.getText()+" "+alumnos.get(cont)+"\n");
        }
    }
}
