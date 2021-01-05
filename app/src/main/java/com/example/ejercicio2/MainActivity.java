package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ejercicio2.dialog.TimePickerFragment;
import com.example.ejercicio2.model.Receta;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextInputLayout tiReceta;
    TextInputLayout tiTiempo;
    TextInputLayout tiPorcion;

    TextInputEditText etReceta;
    TextInputEditText etTiempo;
    TextInputEditText etPorcion;

    Spinner spTipo;
    RadioGroup rgDificultad;

    ArrayList<Receta> recetas;
    Receta tmpReceta;

    String tmpNombre;
    String tmpTiempo;
    int tmpPorcion;
    int tmpTipo;
    int tmpDificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia del Array de Recetas
        recetas = new ArrayList<>();

        //Asociacion de elementos de la vista
        etReceta = findViewById(R.id.etReceta);
        tiReceta = findViewById(R.id.tiReceta);
        etTiempo = findViewById(R.id.etTiempo);
        tiTiempo = findViewById(R.id.tiTiempo);
        etPorcion = findViewById(R.id.etPorcion);
        tiPorcion = findViewById(R.id.tiPorcion);
        spTipo = findViewById(R.id.spTipo);
        rgDificultad = findViewById(R.id.rgDificultad);

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
            case R.id.btnAgregar:   //Boton para agregar receta
                agregarReceta();
                //Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRecetario: //Boton para mostrar recetas
                verRecetario();
                //Toast.makeText(this, "Recetas", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    //Metodo para obtener elemento seleccionado en el Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Asigna posicion del elemento seleccionado
        tmpTipo = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Metodo para agregar Receta
    public void agregarReceta(){
        //Revision del llenado de campos
        if(!validar()){
            Toast.makeText(this, getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
            return;
        }

        //Obtencion de valores del formulario
        tmpNombre = etReceta.getText().toString();
        tmpTiempo = etTiempo.getText().toString();
        tmpPorcion = Integer.parseInt(etPorcion.getText().toString());

        //Crea un nuevo Objeto Receta y agregar al array
        tmpReceta = new Receta(tmpNombre, tmpTiempo, tmpPorcion, tmpTipo, tmpDificultad);
        recetas.add(tmpReceta);
        Toast.makeText(this, String.valueOf(Receta.getIndice()), Toast.LENGTH_SHORT).show();

        limpiarFormulario();
    }

    //Metodo para ir al recetario
    public void verRecetario(){
        //Intent para indicar el siguiente Activity
        Intent intent = new Intent(this, Recetario.class);

        //Instacia de Bundle
        Bundle bundle = new Bundle();
        //Almacenar el Array
        bundle.putSerializable("recetas", recetas);
        //Enviar bundle al intent
        intent.putExtras(bundle);

        //Iniciar Activity de recetario
        startActivity(intent);
    }

    //Metodo para comprobar Dificultad seleccionada
    public boolean comprobarDificultad(){
        //Obtiene ID del RadioButton
        tmpDificultad = rgDificultad.getCheckedRadioButtonId();
        if(tmpDificultad == -1){  //No se ha seleccionado ninguna dificultad
            return false;
        }
        return true;
    }

    //Validacion de los campos del formulario
    public boolean validar(){
        //Revision del campo Receta
        if(etReceta.getText().toString().equals("")){
            //Marca de error en el campo
            tiReceta.setError(getResources().getString(R.string.errReceta));
            return false;
        }else{
            tiReceta.setError(null);
        }
        //Revision del campo Tiempo
        if(etTiempo.getText().toString().equals("") || etTiempo.getText().toString().equals(getResources().getString(R.string.dfTiempo))){
            tiTiempo.setError(getResources().getString(R.string.errTiempo));
            return false;
        }else{
            tiTiempo.setError(null);
        }
        //Revision del campo Porcion
        if(etPorcion.getText().toString().equals("")){
            tiPorcion.setError(getResources().getString(R.string.errPorcion));
            return false;
        }else{
            tiPorcion.setError(null);
        }
        //Revision de Dificultad
        if(!comprobarDificultad()){
            //Toast.makeText(this, getResources().getString(R.string.errDificultad), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //Metodo para reestablecer todos los campos del formulario
    public void limpiarFormulario(){
        etReceta.setText("");
        etTiempo.setText("");
        etPorcion.setText("");
        rgDificultad.clearCheck();
        spTipo.setSelection(0);
    }
}