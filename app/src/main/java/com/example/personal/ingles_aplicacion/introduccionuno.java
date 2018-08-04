package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class introduccionuno extends AppCompatActivity {
    CheckBox ecua, braz, alem, fran;
    ProgressBar barra;
    CardView add;
    MediaPlayer alemania,brazil,ecuador,francia,correcto,incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccionuno);
        ecua =(CheckBox) findViewById(R.id.ecuador);
        braz =(CheckBox) findViewById(R.id.brazil);
        alemania = MediaPlayer.create(this,R.raw.germany);
        brazil = MediaPlayer.create(this,R.raw.brazil);
        barra = (ProgressBar) findViewById(R.id.progressBar2);
        ecuador = MediaPlayer.create(this,R.raw.ecuador);
        francia = MediaPlayer.create(this,R.raw.francia);
        correcto = MediaPlayer.create(this,R.raw.correcto);
        add = (CardView) findViewById(R.id.agendar);
        incorrecto = MediaPlayer.create(this,R.raw.incorrecto);
        alem =(CheckBox) findViewById(R.id.alemania);
        fran =(CheckBox) findViewById(R.id.francia);

    }

    public void correcto() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customToast = inflater.inflate(R.layout.toas_personalizado, null);
        TextView txt = (TextView) customToast.findViewById(R.id.txttoas);
        txt.setText("FELICITACIONES, HAS ACERTADO!!!");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
    }


    public void incorrecto() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customToast = inflater.inflate(R.layout.toas_error, null);
        TextView txt = (TextView) customToast.findViewById(R.id.txttoas);
        txt.setText("ERROR :( , LA RESPUESTA ERA ECUADOR ");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
    }
    public void digitar(View view){
        ecua.setChecked(true);
        if(ecua.isChecked()){
            fran.setChecked(false);
            braz.setChecked(false);
            alem.setChecked(false);
            ecuador.start();
        }
    }
    public  void digitar2(View view){
        braz.setChecked(true);
        if(braz.isChecked()){
            ecua.setChecked(false);
            alem.setChecked(false);
            fran.setChecked(false);
            brazil.start();
        }
    }
    public  void digitar3(View view){
        alem.setChecked(true);
        if(alem.isChecked()){
            ecua.setChecked(false);
            braz.setChecked(false);
            fran.setChecked(false);
            alemania.start();

        }
    }

    public  void digitar4(View view){
        fran.setChecked(true);
        if(fran.isChecked()){
            ecua.setChecked(false);
            braz.setChecked(false);
            alem.setChecked(false);
            francia.start();

        }
    }
    public void checkear(View view){

        if(ecua.isChecked()) {
            correcto.start();
            correcto();
            barra.setProgress(30);
            Intent i = new Intent(this, introducciondos.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else{
            incorrecto.start();
            incorrecto();
        }
    }

    public void setAlemania(View view){
        alemania.start();
    }

    public  void click1(View view){
        if(ecua.isChecked()){
            fran.setChecked(false);
            braz.setChecked(false);
            alem.setChecked(false);
            ecuador.start();
        }
    }

    public  void click2(View view){
        if(braz.isChecked()){
            ecua.setChecked(false);
            alem.setChecked(false);
            fran.setChecked(false);
            brazil.start();
        }
    }
    public  void click3(View view){
        if(alem.isChecked()){
            ecua.setChecked(false);
            braz.setChecked(false);
            fran.setChecked(false);
            alemania.start();

        }
    }

    public  void click4(View view){
        if(fran.isChecked()){
            ecua.setChecked(false);
            braz.setChecked(false);
            alem.setChecked(false);
            francia.start();

        }
    }
}
