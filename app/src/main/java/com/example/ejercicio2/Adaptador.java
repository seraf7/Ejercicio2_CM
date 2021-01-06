package com.example.ejercicio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        ImageView ivTipo = vista.findViewById(R.id.ivTipo);
        ImageView ivDificultad = vista.findViewById(R.id.ivDificultad);
        TextView tvReceta = vista.findViewById(R.id.tvReceta);
        TextView tvTiempo = vista.findViewById(R.id.tvTiempo);
        TextView tvPorcion = vista.findViewById(R.id.tvPorcion);
        TextView tvDificultad = vista.findViewById(R.id.tvDificultad);

        //Modificar elementos de la vista
        tvReceta.setText(datos.get(position).getNombre()+String.valueOf(datos.get(position).getId()));
        tvTiempo.setText(datos.get(position).getTiempo());
        tvPorcion.setText(String.valueOf(datos.get(position).getPorcion()));

        //Establecer campos para dificultad
        switch (datos.get(position).getDificultad()){
            case R.id.rbBaja:
                ivDificultad.setImageResource(R.drawable.ic_facil);
                tvDificultad.setText(vista.getResources().getString(R.string.lblBaja));
                break;
            case R.id.rbMedia:
                ivDificultad.setImageResource(R.drawable.ic_medio);
                tvDificultad.setText(vista.getResources().getString(R.string.lblMedia));
                break;
            case  R.id.rbAlta:
                ivDificultad.setImageResource(R.drawable.ic_dificil);
                tvDificultad.setText(vista.getResources().getString(R.string.lblAlta));
                break;
            default:
                break;
        }

        //Cambiar imagen de tipo
        switch (datos.get(position).getTipo()){
            case 0:     //Bebidas
                ivTipo.setImageResource(R.drawable.cocktail);
                break;
            case 1:     //Carnes
                ivTipo.setImageResource(R.drawable.steak);
                break;
            case 2:     //Ensaladas
                ivTipo.setImageResource(R.drawable.lettuce);
                break;
            case 3:     //Pescados
                ivTipo.setImageResource(R.drawable.fish);
                break;
            case 4:     //Postres
                ivTipo.setImageResource(R.drawable.cupcake);
                break;
            default:
                break;
        }

        return vista;
    }
}
