package com.example.personal.ingles_aplicacion;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class introducciontres extends AppCompatActivity {
    TextView grabar;
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    MediaPlayer gua, correcto, incorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducciontres);
        grabar = (TextView) findViewById(R.id.txtGrabarVoz);
        correcto = MediaPlayer.create(this,R.raw.correcto);
        incorrecto = MediaPlayer.create(this,R.raw.incorrecto);
        gua = MediaPlayer.create(this,R.raw.maria);
    }

    public void mostrar(View view){
        gua.start();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.
                                    EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);

                    grabar.setText(strSpeech2Text);
                }

                break;
            default:

                break;
        }
    }

    public void onClickImgBtnHablar(View v) {

        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

// Configura el Lenguaje (Español-México)
        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show();
        }

    }
    public void comprobar(View view){

        if(grabar.getText().toString().equals("ella es María")){
            correcto.start();
            correcto();
            Intent i = new Intent(this, introduccioncuatro.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        }else{
            incorrecto();
            incorrecto.start();
        }


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
        txt.setText("ERROR :( , HAS FALLADO EN EL ORDEN ");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
    }
}
