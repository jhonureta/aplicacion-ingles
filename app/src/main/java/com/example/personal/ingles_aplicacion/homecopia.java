package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class homecopia extends AppCompatActivity {
    private CardView basic, family, add, linck;
    TextView uno;
    String esp= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecopia);

        try {
            setContentView(R.layout.activity_games);
            basic = (CardView) findViewById(R.id.basicID2);
            family = (CardView) findViewById(R.id.family2);
            add = (CardView) findViewById(R.id.add2);
            linck = (CardView) findViewById(R.id.linck2);
            uno = (TextView) findViewById(R.id.completadobasic2);
            Intent i = getIntent();
            Bundle bundle = i.getExtras();
            String  esp = bundle.getString("estado");
            uno.setText(esp);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (uno.getText().toString().equals("Completado")) {




                        family.setEnabled(true);

                    }
                }
            }, 1000);

            uno.setText(esp);


            family.setEnabled(false);
            add.setEnabled(false);
            linck.setEnabled(false);


            basic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(homecopia.this, introduccionuno.class);
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

