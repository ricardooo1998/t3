package com.tema3.ricardo.t3_accesodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrarProfesor extends AppCompatActivity {

    private  MyDBAdapter dbAdapter = new MyDBAdapter(this);
    Button cancelar;
    Button registrarProfesor;
    EditText nombre;
    EditText edad;
    EditText ciclo;
    EditText curso;
    EditText despacho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);
        nombre = (EditText) findViewById(R.id.nombreProfesor);
        edad = (EditText) findViewById(R.id.edadProfesor);
        ciclo = (EditText) findViewById(R.id.cicloProfesor);
        curso = (EditText) findViewById(R.id.cursoProfesor);
        despacho = (EditText) findViewById(R.id.despachoProfesor);

        cancelar = (Button) findViewById(R.id.cancelarProfesor);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        registrarProfesor = (Button) findViewById(R.id.registrarProfesor);
        registrarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insetarProfesor(nombre.getText().toString(), edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString(), despacho.getText().toString());
            }
        });


    }
}
