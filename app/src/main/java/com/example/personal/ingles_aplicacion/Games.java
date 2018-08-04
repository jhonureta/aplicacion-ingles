package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Games extends AppCompatActivity {
    private CardView basic, family, add, linck;
    TextView uno;
    ProgressBar un;
    String esp= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_games);
            basic = (CardView) findViewById(R.id.basicID);
            family = (CardView) findViewById(R.id.family);
            add = (CardView) findViewById(R.id.add);
            linck = (CardView) findViewById(R.id.linck);
            un = (ProgressBar) findViewById(R.id.progres);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    un.setProgress(10);

                }
            },1000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    un.setProgress(20);

                }
            },1200);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    un.setProgress(30);

                }
            },1300);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    un.setProgress(40);

                }
            },1400);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    un.setProgress(50);

                }
            },1500);





            uno = (TextView) findViewById(R.id.completadobasic);


           /* new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (uno.getText().toString().equals("Completado")) {

                        Bundle bundle = getIntent().getExtras();
                      esp = bundle.getString("estado");


                        family.setEnabled(true);

                    }
                }
            }, 1000);*/

            uno.setText(esp);


            family.setEnabled(false);
            add.setEnabled(false);
            linck.setEnabled(false);


            basic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Games.this, introduccionuno.class);
                    startActivity(intent);
                    finish();
                }
            });

            family.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    startActivity(intent);
                    finish();
                }
            });
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
    }

