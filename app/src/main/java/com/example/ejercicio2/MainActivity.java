package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.ejercicio2.dialog.TimePickerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociacion de campos de texto
        etTiempo = findViewById(R.id.etTiempo);

        //Asociar un metodo Listener a etFecha
        etTiempo.setOnClickListener(this);
    }

    //Metodo para capturar el tiempo y mostrar TimePicker
    private void showTimePickerDialog(){
        //Declaracion de un nuevo fragment
        TimePickerFragment nuevoFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo de la cadena de tiempo
                String t = "%02d:%02d";
                //Recupera tiempo seleccionado
                final String tiempoFormateado = String.format(t, hourOfDay, minute);
                //Coloca tiempo en el EditText
                etTiempo.setText(tiempoFormateado);
            }
        });{
            nuevoFragment.show(getSupportFragmentManager(), "view");
        }
    }

    @Override
    public void onClick(View v) {
        //Reconoce el elemento donde se dio clic
        switch (v.getId()){
            case R.id.etTiempo:     //Para clic sobre etTiempo
                //Muestra el TimePicker
                showTimePickerDialog();
                break;
        }
    }
}