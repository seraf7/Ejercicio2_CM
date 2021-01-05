package com.example.ejercicio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ejercicio2.model.Receta;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    Context contexto;
    ArrayList<Receta> datos;
    //Variable estatica de tipo inflater
    private static LayoutInflater inflater = null;

    //Constructor de la clase
    public Adaptador(Context contexto, ArrayList<Receta> recetas) {
        this.contexto = contexto;
        this.datos = recetas;
        //Objeto para agregar elementos a la vista
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { //Determina el numero de elementos a realizar
        //Devuelve el tamaño del Array
        return datos.size();
    }

    @Override
    public Object getItem(int position) {   //Permite reconocer un elemento particular
        //Devuelve posicion del elemento
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {   //Recupera ID de elemento especifico
        //Devuelve ID
        return datos.get(position).getId();
    }

    @Override   //Genera las vistas de cada celda
    public View getView(int position, View convertView, ViewGroup parent) {
        //Objeto que contiene la vista
        final View vista = inflater.inflate(R.layout.elemento_recetario, null);

        //Ligar elementos de la vista

        return vista;
    }
}
