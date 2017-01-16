package com.example.alumnedam.horario;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class VentanaHorario extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_horario);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        HorarioBD usdbh = new HorarioBD(this, "DBHorario", null, 1);

        db = usdbh.getWritableDatabase();

        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String grupo = intent.getStringExtra("grupo");

        Calendar cal = Calendar.getInstance();

        int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minut = Calendar.getInstance().get(Calendar.MINUTE);
        String horaSistema= hora+":"+minut;

        int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        String diaSetmana = String.valueOf(dia - 1);

        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM HORARIO WHERE ('" + hora + ":" + minut + "' BETWEEN hora_inicio AND hora_fin) AND grupo = '" + grupo +"' AND dia = " + diaSetmana, null);
            if (c.moveToFirst()) {
                do {
                    String codAsignatura = c.getString(2);
                    String nomAsignatura = asignatura(codAsignatura);
                    String horaInicio = c.getString(3);
                    String horaFin = c.getString(4);

                    mostrarDatos(nomAsignatura, horaInicio, horaFin);
                } while (c.moveToNext());
            }
        }
    }
    /**
     * En aquest metode es fa la select del nom de l'asignatura
     * @param codAsignatura
     * @return nom de l'assignatura
     */
    public String asignatura(String codAsignatura) {
        String nom = "";
        Cursor c = db.rawQuery("SELECT nombre_asignaturas FROM ASIGNATURAS WHERE cod_asignatura ='" + codAsignatura + "'", null);
        if (c.moveToFirst()) {
            do {
                nom = c.getString(0);
            } while (c.moveToNext());
        }
        return nom;
    }

    /**
     * Metodo muestra en el layout los valores pasados por parametro
     * @param valorNombreAsignatura
     * @param valorHoraInicio
     * @param valorHoraFin
     */
    public void mostrarDatos(String valorNombreAsignatura, String valorHoraInicio, String valorHoraFin) {
        TextView nombreAsignatura = (TextView) findViewById(R.id.LBLValorAsignatura);
        nombreAsignatura.setText(valorNombreAsignatura);

        TextView horaInicio = (TextView) findViewById(R.id.LBLValorHoraInicio);
        horaInicio.setText(valorHoraInicio);

        TextView horaFin = (TextView) findViewById(R.id.LBLValorHoraFin);
        horaFin.setText(valorHoraFin);
    }
}
