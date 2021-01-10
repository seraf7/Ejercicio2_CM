package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Nuevo Thread
        Thread timer =  new Thread(){
            //Definicion del metodo run
            public void run(){
                try{
                    //Matiene el splash 1s
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //Intent para ir al siguiente Activity
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    //Iniciar la nueva Activity
                    startActivity(intent);
                    //Finalizar el Splash y sacarlo de memoria
                    finish();
                }
            }
        };
        //Ejecutar el hilo definido
        timer.start();
    }
}