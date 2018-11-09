package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarAlumno extends AppCompatActivity {
    private  MyDBAdapter dbAdapter = new MyDBAdapter(this);
    Button cancelar;
    Button registrarAlumno;
    EditText nombre;
    EditText edad;
    EditText ciclo;
    EditText curso;
    EditText media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);
        cancelar = (Button) findViewById(R.id.cancelarAlumno);
        registrarAlumno = (Button) findViewById(R.id.registrarAlumno);
        nombre = (EditText) findViewById(R.id.nombreAlumno);
        edad = (EditText) findViewById(R.id.edadAlumno);
        ciclo = (EditText) findViewById(R.id.cicloAlumno);
        curso = (EditText) findViewById(R.id.cursoAlumno);
        media = (EditText) findViewById(R.id.notaMediaAlumno);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(cancelar);
            }
        });

        registrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbAdapter.open();
                dbAdapter.insetarAlumnos(nombre.getText().toString(), edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString(), media.getText().toString());
            }
        });
    }

}
