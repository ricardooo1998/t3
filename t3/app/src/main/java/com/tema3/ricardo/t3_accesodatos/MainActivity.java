package com.tema3.ricardo.t3_accesodatos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected final static String MisPrefs = "Mis Preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guardar = findViewById(R.id.guardarPrefs);
        Button mostrar = findViewById(R.id.mostrarPrefs);
        Button registrarAlumno = findViewById(R.id.registrarAlumno);
        Button registrarProfesor = findViewById(R.id.registrarProfesor);
        Button consultar = findViewById(R.id.consultar);
        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText nombreUsuario = (EditText) findViewById(R.id.nombreUsuario);
        final EditText fecha = (EditText) findViewById(R.id.fechaNacimiento);
        final RadioButton hombre = (RadioButton) findViewById(R.id.hombre);
        final RadioButton mujer = (RadioButton) findViewById(R.id.mujer);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nombre.getText().toString();
                String nU = nombreUsuario.getText().toString();
                String f = fecha.getText().toString();
                String sexo;

                if (hombre.isChecked())
                {
                    sexo = "Hombre";
                }

                else
                {
                    if (mujer.isChecked())
                    {
                        sexo = "Mujer";
                    }
                    else
                    {
                        sexo = "Error";
                    }
                }

                SharedPreferences misPreferencias = getSharedPreferences(MisPrefs, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = misPreferencias.edit();

                editor.putString("nombre", n);
                editor.putString("nombreUsuario", nU);
                editor.putString("fecha", f);
                editor.putString("sexo", sexo);
                editor.commit();
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences misPreferencias = getSharedPreferences(MisPrefs, Activity.MODE_PRIVATE);
                String n = misPreferencias.getString("nombre", "");
                String nU = misPreferencias.getString("nombreUsuario", "");
                String f = misPreferencias.getString("fecha", "");
                String s = misPreferencias.getString("sexo", "");
                Toast mensaje = Toast.makeText(getApplicationContext(),"Nombre: "+n+", Nombre de Usuario: "+nU+", Fecha de Nacimiento: "+f+ ", Sexo: "+s, Toast.LENGTH_SHORT);
                mensaje.show();
            }
        });

        registrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alumno = new Intent(getApplicationContext(), RegistrarAlumno.class);
                startActivity(alumno);
            }
        });

        registrarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profesor = new Intent(getApplicationContext(), RegistrarProfesor.class);
                startActivity(profesor);
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultar = new Intent(getApplicationContext(), Consultar.class);
                startActivity(consultar);
            }
        });
    }
}
