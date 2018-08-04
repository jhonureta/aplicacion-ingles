package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class introduccioncuatro extends AppCompatActivity {
    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho;
    int cons = 0;
    String comparar;
    String comparar2;
    ImageView fin;


    private boolean caraUp = false;
    private Image im1;
    private Image im2;
    private Button[] pbtn = new Button[2];
    private boolean primerc = false;
    MediaPlayer yo, hola, dia, aplauso;
    String variable1= "Completado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccioncuatro);
        uno = (Button) findViewById(R.id.txt1);
        dos = (Button) findViewById(R.id.txt2);
        tres = (Button) findViewById(R.id.txt3);
        cuatro = (Button) findViewById(R.id.txt4);
        fin = (ImageView)findViewById(R.id.finalizar);



        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), homecopia.class);
                i.putExtra("estado", "Completado");
                startActivity(i);

            }
        });


        seis = (Button) findViewById(R.id.txt6);
        siete = (Button) findViewById(R.id.txt7);

        yo = MediaPlayer.create(this, R.raw.i);
        dia = MediaPlayer.create(this, R.raw.dia);
        hola = MediaPlayer.create(this, R.raw.hola);
        aplauso = MediaPlayer.create(this, R.raw.bien);
    }

    private void btnEnabled(Button btn) {
        cons++;
        if (cons == 1) {
            btn.setEnabled(false);

            pbtn[0] = btn;

        }
        if (cons == 2) {

            btn.setEnabled(false);

            pbtn[1] = btn;

        }

    }

    private void compare() {


        if (cons == 2) {
            cons = 0;
            if (pbtn[0].getText().toString().equals("DIA") && pbtn[1].getText().toString().equals("DAY") || pbtn[0].getText().toString().equals("DAY") && pbtn[1].getText().toString().equals("DIA") || pbtn[0].getText().toString().equals("HOLA") && pbtn[1].getText().toString().equals("HELLO") || pbtn[0].getText().toString().equals("HELLO") && pbtn[1].getText().toString().equals("HOLA") || pbtn[0].getText().toString().equals("YO") && pbtn[1].getText().toString().equals("I") || pbtn[0].getText().toString().equals("I") && pbtn[1].getText().toString().equals("YO")) {

                correcto();

                if (pbtn[0].getText().toString().equals("DIA") && pbtn[1].getText().toString().equals("DAY") || pbtn[0].getText().toString().equals("DAY") && pbtn[1].getText().toString().equals("DIA")) {
                    dia.start();
                } else {
                    if (pbtn[0].getText().toString().equals("HOLA") && pbtn[1].getText().toString().equals("HELLO") || pbtn[0].getText().toString().equals("HELLO") && pbtn[1].getText().toString().equals("HOLA")) {
                        hola.start();
                    } else {
                        if (pbtn[0].getText().toString().equals("YO") && pbtn[1].getText().toString().equals("I") || pbtn[0].getText().toString().equals("I") && pbtn[1].getText().toString().equals("YO")) {
                            yo.start();
                        }

                    }

                }


            } else {
                cons = 0;
                incorrecto();
                pbtn[0].setEnabled(true);
                pbtn[1].setEnabled(true);


            }


        }


    }

    public void comparar1(View view){
        try {
            btnEnabled(uno);
            compare();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void comparar2(View view){
       try {
           btnEnabled(dos);
           compare();
       }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void comparar3(View view){
        try {
            btnEnabled(tres);
            compare();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void comparar4(View view){
        try {
            btnEnabled(cuatro);
            compare();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void comparar6(View view){
        try {
            btnEnabled(seis);
            compare();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void comparar7(View view){
        try {
            btnEnabled(siete);
            compare();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void correcto() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customToast = inflater.inflate(R.layout.toas_personalizado, null);
        TextView txt = (TextView) customToast.findViewById(R.id.txttoas);
        txt.setText(" MUY BIEN, HAS ACERTADO! ");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
       // aplauso.start();
    }
    public void incorrecto() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customToast = inflater.inflate(R.layout.toas_error, null);
        TextView txt = (TextView) customToast.findViewById(R.id.txttoas);
        txt.setText("ERROR NO ES LA UNION CORRECTA ");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
    }


}
