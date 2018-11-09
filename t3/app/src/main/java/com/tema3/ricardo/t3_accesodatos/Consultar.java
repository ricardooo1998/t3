package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consultar extends AppCompatActivity {
    Button cancelar;
    Button todosAlumnos;
    Button alumnosCiclo;
    Button alumnosCurso;
    Button todosProfesores;
    Button todos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);


        cancelar = (Button) findViewById(R.id.cancelarConsulta);
        todosAlumnos = (Button) findViewById(R.id.todosEstudiantes);
        alumnosCiclo = (Button) findViewById(R.id.estudiantesCiclo);
        alumnosCurso = (Button) findViewById(R.id.estudiantesCurso);
        todosProfesores = (Button) findViewById(R.id.todosProfesores);
        todos = (Button) findViewById(R.id.todos);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        todosAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodosEstudiantes.class);
                startActivity(i);
            }
        });

        alumnosCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EstudiantesCiclo.class);
                startActivity(i);
            }
        });

        alumnosCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EstudiantesCurso.class);
                startActivity(i);
            }
        });

        todosProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodosProfesores.class);
                startActivity(i);
            }
        });

        todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Todos.class);
                startActivity(i);
            }
        });
    }
}
