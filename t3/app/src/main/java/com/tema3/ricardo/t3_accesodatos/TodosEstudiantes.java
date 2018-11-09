package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodosEstudiantes extends AppCompatActivity {
    private  MyDBAdapter dbAdapter = new MyDBAdapter(this);
    Button cancelar;
    TextView todosEstudiantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_estudiantes);

        cancelar = (Button) findViewById(R.id.cancelarTodosEstudiantes);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultar.class);
                startActivity(i);
            }
        });
        todosEstudiantes = (TextView) findViewById(R.id.todosAlumnos);
        dbAdapter.open();

        ArrayList<String> alumnos = dbAdapter.todosAlumnos();
        todosEstudiantes.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            todosEstudiantes.setText(todosEstudiantes.getText()+" "+alumnos.get(cont)+"\n");
        }
    }
}
