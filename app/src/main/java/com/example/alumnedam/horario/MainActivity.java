package com.example.alumnedam.horario;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText TBNombre;
    Spinner CBGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BTAceptar = (Button) findViewById(R.id.BTAceptar);
        BTAceptar.setOnClickListener(this);
        SharedPreferences configuracion = getSharedPreferences("configuracionHorario", 0);
        if(configuracion.getBoolean("guardado", false) != false){
            String nombre = configuracion.getString("nombre", "vicens");
            String grupo = configuracion.getString("grupo", "A1");
            saltarHorario(nombre, grupo);
        }

        TBNombre = (EditText) findViewById(R.id.TBNombre);
        CBGrupo = (Spinner) findViewById(R.id.CBGrupo);
        String [] grupos = {"A1","A2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, grupos);
        CBGrupo.setAdapter(adapter);

    }

    /**
     * Metodo que en caso de tener una configuracion guardada se salta la pantalla principal
     * @param nombre nombre del alumno
     * @param grupo grupo del alumno a comprobar el horario
     */
    public void saltarHorario(String nombre, String grupo){
        final Intent intent = new Intent(this, VentanaHorario.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("grupo", grupo);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BTAceptar){
            if(!TBNombre.getText().toString().equals("") && !CBGrupo.getSelectedItem().toString().equals("")){
                final Intent intent = new Intent(this, VentanaHorario.class);

                String nombre = TBNombre.getText().toString();
                String grupo = CBGrupo.getSelectedItem().toString();

                guardarConfiguracion(nombre, grupo);

                intent.putExtra("nombre", nombre);
                intent.putExtra("grupo", grupo);

                startActivity(intent);
            }
        }
    }

    /**
     * Metodo que guarda la configuracion para que la siguiente vez no tengas que pasar por la
     * pantalla principal y muestre directamente el horario
     * @param nombre nombre
     * @param grupo grupo a consultar el horario
     */
    private void guardarConfiguracion(String nombre, String grupo){
        SharedPreferences prefs = getSharedPreferences("configuracionHorario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", nombre);
        editor.putString("grupo", grupo);
        editor.putBoolean("guardado", true);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}
