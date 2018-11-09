package com.tema3.ricardo.t3_accesodatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;

public class MyDBAdapter {

    private static final String DATABASE_NAME="dbtema3.db";
    private static final String TABLA_ALUMNOS="alumno";
    private static final String TABLA_PROFESOR="profesor";
    private static final int DATABASE_VERSION=1;

    private static final String NOMBRE_ALUMNO="nombre";
    private static final String EDAD_ALUMNO="edad";
    private static final String CICLO_ALUMNO="ciclo";
    private static final String CURSO_ALUMNO="curso";
    private static final String MEDIA_ALUMNO="media";


    private static final String NOMBRE_PROFESOR="nombre";
    private static final String EDAD_PROFESOR="edad";
    private static final String CICLO_PROFESOR="ciclo";
    private static final String CURSO_PROFESOR="curso";
    private static final String DESPACHO_PROFESOR="despacho";

    private static final String DATABASE_CREATE_ALUMNOS = "CREATE TABLE "+TABLA_ALUMNOS+" (_id integer primary key autoincrement, a_nombre text, a_edad text, a_ciclo text, a_curso text);";
    private static final String DATABASE_CREATE_PROFESORES = "CREATE TABLE "+TABLA_PROFESOR+" (_id integer primary key autoincrement, p_nombre text, p_edad text, p_ciclo text, p_curso text, p_despacho text);";
    private static final String DATABASE_DROP_ALUMNOS = "DROP TABLE IF EXISTS "+TABLA_ALUMNOS+";";
    private static final String DATABASE_DROP_PROFESORES = "DROP TABLE IF EXISTS "+TABLA_PROFESOR+";";

    private final Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;

    public MyDBAdapter(Context c) {
        this.context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open()
    {
        try
        {
            db= dbHelper.getWritableDatabase();
        }
        catch (SQLiteException e)
        {
            db = dbHelper.getReadableDatabase();
        }
    }

    public void insetarProfesor(String nombre, String edad, String ciclo , String curso, String despacho)
    {
        ContentValues cv = new ContentValues();
        cv.put(NOMBRE_PROFESOR, nombre);
        cv.put(EDAD_PROFESOR, edad);
        cv.put(CICLO_ALUMNO, ciclo);
        cv.put(CURSO_PROFESOR, curso);
        cv.put(DESPACHO_PROFESOR, despacho);
        db.insert(TABLA_PROFESOR, null, cv);
    }

    public void insetarAlumnos (String nombre, String edad, String ciclo , String curso, String media)
    {
        ContentValues cv = new ContentValues();
        cv.put(NOMBRE_ALUMNO, nombre);
        cv.put(EDAD_ALUMNO, edad);
        cv.put(CICLO_ALUMNO, ciclo);
        cv.put(CURSO_ALUMNO, curso);
        cv.put(MEDIA_ALUMNO, media);
        db.insert(TABLA_ALUMNOS, null, cv);
    }

    public ArrayList<String> todosAlumnos(){
        ArrayList<String> alumnos = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_CREATE_ALUMNOS,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }


    public ArrayList<String> estudiantesCiclo(String ciclo){
        ArrayList<String> alumnos = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_CREATE_ALUMNOS,null,"a_ciclo='"+CICLO_ALUMNO+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }
    public ArrayList<String> estudiantesCurso(String curso){
        ArrayList<String> alumnos = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_CREATE_ALUMNOS,null,"a_curso='"+curso+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }
    public ArrayList<String> todosProfesores(){
        ArrayList<String> profesores = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_CREATE_PROFESORES,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                profesores.add(cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" ");
            }while (cursor.moveToNext());
        }
        return profesores;
    }




    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE_ALUMNOS);
            db.execSQL(DATABASE_CREATE_PROFESORES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP_ALUMNOS);
            db.execSQL(DATABASE_DROP_PROFESORES);
            onCreate(db);
        }

    }
}
