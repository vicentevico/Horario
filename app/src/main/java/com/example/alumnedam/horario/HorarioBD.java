package com.example.alumnedam.horario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VICENTE on 30/11/2016.
 */

public class HorarioBD extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreateHorario = "CREATE TABLE HORARIO (id_horario INTEGER, grupo TEXT, cod_asignatura TEXT, hora_inicio TEXT, hora_fin TEXT, dia INTEGER)";
    String sqlCreateAsignaturas = "CREATE TABLE ASIGNATURAS (cod_asignatura TEXT, nombre_asignaturas TEXT, cod_profe INTEGER)";
    String sqlCreateProfes = "CREATE TABLE PROFES (cod_profe INTEGER, nombre_profesor TEXT)";
    //String sqlCreateAlumno = "CREATE TABLE ALUMNO (cod_alumno INTEGER, nombre_alumno TEXT, grupo TEXT)";

    public HorarioBD(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateHorario);
        db.execSQL(sqlCreateAsignaturas);
        db.execSQL(sqlCreateProfes);

        insertarDatos(db);
        //db.execSQL(sqlCreateProfes);
        //db.execSQL(sqlCreateAlumno);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //borramos las tablas
        db.execSQL("DROP TABLE IF EXISTS HORARIO");
        db.execSQL("DROP TABLE IF EXISTS ASIGNATURAS");
        db.execSQL("DROP TABLE IF EXISTS PROFES");
        db.execSQL("DROP TABLE IF EXISTS ALUMNO");

        //creamos la nueva version de las tablas
        db.execSQL(sqlCreateHorario);
        db.execSQL(sqlCreateAsignaturas);
        db.execSQL(sqlCreateProfes);
        //db.execSQL(sqlCreateAlumno);
        insertarDatos(db);
    }

    /**
     * Metodo donde insertamos todos los datos en las tablas
     * @param db base de datos sqlite
     */
    private void insertarDatos(SQLiteDatabase db){
        //Insertamos datos en Profesor
        db.execSQL("INSERT INTO PROFES (cod_profe, nombre_profesor) VALUES (1, 'Josefa Gonzalez')");
        db.execSQL("INSERT INTO PROFES (cod_profe, nombre_profesor) VALUES (2, 'Jorge Rubio')");
        db.execSQL("INSERT INTO PROFES (cod_profe, nombre_profesor) VALUES (3, 'Jose A. Leo')");
        db.execSQL("INSERT INTO PROFES (cod_profe, nombre_profesor) VALUES (4, 'Lluis Perpiña')");
        db.execSQL("INSERT INTO PROFES (cod_profe, nombre_profesor) VALUES (5, 'Marta Planas')");

        //Insertamos datos en asignaturas
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M03', 'Programació bàsica', 1)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M05/M02/M06', 'Entorns de desenvolupament/Bases de dades/Accés a dades', 2)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M07', 'Desenvolupament de interficíes', 3)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M08', 'Programació multimèdia i dispositius mòbils', 4)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M09', 'Programació de serveis i processos', 1)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M10', 'Sistemes de gestió empresarial', 5)");
        db.execSQL("INSERT INTO ASIGNATURAS (cod_asignatura, nombre_asignaturas, cod_profe) VALUES ('M11', 'Tutoria', 2)");

        //Grupo A1
        //Asignatura M03 programacion
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M03', '15:00', '17:00', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M03', '19:20', '21:20', 3)");
        //Asignatura M07 Interficies
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M07', '15:00', '18:00', 1)");
        //Asignatura M10 ERP's
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M10', '17:00', '18:00', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M10', '18:20', '19:20', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M10', '15:00', '17:00', 5)");
        //Asignatura M11 Tutoria
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M11', '18:20', '19:20', 1)");
        //Asignatura M05/M02/M06  Entorns desenvolupamen/ Base dades / Acces dades
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M05/M02/M06', '19:20', '21:20', 2)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M05/M02/M06', '16:00', '17:00', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M05/M02/M06', '18:20', '21:20', 4)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M05/M02/M06', '19:20', '21:20', 5)");
        //Asignatura M09 Porgramacio de serveis i procesos
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M09', '17:00', '18:00', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M09', '18:20', '19:20', 3)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M09', '15:00', '16:00', 4)");
        //Asignatura M08 Android
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M08', '16:00', '18:00', 4)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M08', '17:00', '18:00', 5)");
        db.execSQL("INSERT INTO HORARIO (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (1, 'A1', 'M08', '18:20', '19:20', 5)");


        //Grupo A2
        //Asignatura M03 Programacion
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M03', '19:20', '21:20', 1)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M03', '16:00', '18:00', 4)");
        //Asignatura M05/M02/M06  Entorns desenvolupamen/ Base dades / Acces dades
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M05/M02/M06', '19:20', '21:20', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M05/M02/M06', '16:00', '17:00', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M05/M02/M06', '18:20', '21:20', 4)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M05/M02/M06', '19:20', '21:20', 5)");
        //Asignatura M07 Interficies
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M07', '15:00', '18:00', 1)");
        //Asignatura M08 Android
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M08', '15:00', '17:00', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M08', '17:00', '18:00', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M08', '18:20', '19:20', 3)");
        //Asignatura M09 Porgramacio de serveis i procesos
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M09', '19200', '20:20', 3)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M09', '17:00', '18:00', 5)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M09', '18:20', '19:20', 5)");
        //Asignatura M10 ERP's
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M10', '17:00', '18:00', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M10', '18:20', '19:20', 2)");
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M10', '15:00', '17:00', 5)");
        //Asignatura M11 Tutoria
        db.execSQL("INSERT INTO Horario (id_horario, grupo, cod_asignatura, hora_inicio, hora_fin, dia) " +
                "VALUES (2, 'A2', 'M11', '18:20', '19:20', 1)");
    }
}
