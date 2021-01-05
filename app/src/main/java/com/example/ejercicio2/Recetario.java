package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejercicio2.model.Receta;

import java.util.ArrayList;

public class Recetario extends AppCompatActivity {

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
            //Toast.makeText(this, String.valueOf(recetas.size()), Toast.LENGTH_SHORT).show();

            //Genera adapatador con su conjunto de datos
            Adaptador adaptador = new Adaptador(this, recetas);
            //Agrega elementos al ListView
            lvRecetario.setAdapter(adaptador);
        }

    }
}