package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EstudiantesCurso extends AppCompatActivity {
    private MyDBAdapter dbAdapter;
    Button buscar;
    Button cancelar;
    TextView resultados = (TextView) findViewById(R.id.resultadosCurso);
    EditText buscarCurso = (EditText) findViewById(R.id.buscarCurso);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_curso);

        cancelar = (Button) findViewById(R.id.cancelarCurso);
        buscar = (Button) findViewById(R.id.buttonBuscar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(), Consultar.class);
                startActivity(i);
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarCurso(buscarCurso.getText().toString());
            }
        });
    }

    private void buscarCurso(String curso){
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        ArrayList<String> alumnos = dbAdapter.estudiantesCurso(curso);
        this.resultados.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            resultados.setText(buscarCurso.getText()+" "+alumnos.get(cont)+"\n");
        }
    }

}
