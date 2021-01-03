package com.example.ejercicio2.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TimePickerFragment  extends DialogFragment {

    //Definicion de un Listener
    private TimePickerDialog.OnTimeSetListener listener;

    //Definicion de Fragment con Listener asociado
    public static TimePickerFragment newInstance(TimePickerDialog.OnTimeSetListener listener){
        //Instancia de un objeto TimePicker
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setListener(listener);
        return fragment;
    }

    //Metodo para establecer el listener
    public void setListener(TimePickerDialog.OnTimeSetListener listener){
        this.listener = listener;
    }

    //Sobreescribe metodo para la creacion del Dialog
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Valor inicial para el reloj
        int deafult = 0;

        //Crea instancia del TimePicker con formato 24 hrs y la devuelve
        return new TimePickerDialog(getActivity(), listener, deafult, deafult, true);
    }
}
