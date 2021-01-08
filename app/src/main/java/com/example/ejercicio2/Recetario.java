package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejercicio2.model.Receta;

import java.util.ArrayList;
import java.util.Collections;

public class Recetario extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Receta> recetas;
    ListView lvRecetario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetario);

        //Ligar elementos de la vista
        lvRecetario = findViewById(R.id.lvRecetario);

        //Recuperar Array de recetas del Activity anterior
        Bundle bundle = getIntent().getExtras();

        //Verifica que bundle no este vacio
        if(bundle != null){
            //Recupera el Array de recetas del Activity anterior
            recetas = (ArrayList<Receta>) bundle.getSerializable("recetas");
            //Ordena alfabeticamente las recetas
            Collections.sort(recetas);

            //Genera adapatador con su conjunto de datos
            Adaptador adaptador = new Adaptador(this, recetas);
            //Agrega elementos al ListView
            lvRecetario.setAdapter(adaptador);
            //Agregar Listener al ListView
            lvRecetario.setOnItemClickListener(this);
        }

    }

    //Metodo para reconocer el elemento sobre el que se dio clic
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Mostrar Toast con el ID del elemento presionado
        Toast.makeText(this, getResources().getString(R.string.msjID) + id, Toast.LENGTH_SHORT).show();
    }
}