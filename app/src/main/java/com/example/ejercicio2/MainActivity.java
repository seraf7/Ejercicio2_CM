package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.ejercicio2.dialog.TimePickerFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextInputEditText etTiempo;
    TextInputLayout tiTiempo;

    Spinner spTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociacion de elementos de la vista
        etTiempo = findViewById(R.id.etTiempo);
        tiTiempo = findViewById(R.id.tiTiempo);
        spTipo = findViewById(R.id.spTipo);

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

    //Metodo para obtener elemento seleccionado en el Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}