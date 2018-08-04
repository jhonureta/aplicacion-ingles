package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class introducciondos extends AppCompatActivity {
    TextView text,text2, subtext1,subtext2,subtext3,subtext4,text3,text4;

    int con = 0;
    int con2 = 0;
    int con3 = 0;
    int con4 = 0;
    float x =0;
    float y = 0;
    ProgressBar barra;
    MediaPlayer gua, correcto, incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducciondos);
        text = (TextView) findViewById(R.id.texto);
        text2 = (TextView) findViewById(R.id.texto2);
        text3 = (TextView) findViewById(R.id.texto3);
        text4 = (TextView) findViewById(R.id.texto4);
        gua = MediaPlayer.create(this,R.raw.guayaquil);
        barra = (ProgressBar) findViewById(R.id.progressBar2);
        barra.setProgress(30);
        gua.start();
        correcto = MediaPlayer.create(this,R.raw.correcto);
        incorrecto = MediaPlayer.create(this,R.raw.incorrecto);
        subtext1 = (TextView) findViewById(R.id.arriv1);
        subtext2 = (TextView) findViewById(R.id.arriv2);
        subtext3 = (TextView) findViewById(R.id.arriv3);
        subtext4 = (TextView) findViewById(R.id.arriv4);

    }


    public void mostrar(View view){
        gua.start();


    }

    public void posicion(View view){
        try{

            if(subtext1.getText().toString().equals("")){
                subtext1.setText(text.getText());
                text.setText("");

            }else{

                if(subtext2.getText().toString().equals("")){
                    subtext2.setText(text.getText());
                    text.setText("");
                }else{

                    if(subtext3.getText().toString().equals("")){

                        subtext3.setText(text.getText());
                        text.setText("");
                    }else{

                        if(subtext4.getText().toString().equals("")){
                            subtext4.setText(text.getText());
                            text.setText("");
                        }

                    }


                }
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }



    }
    public void posicion2(View view){

        try{


            if(subtext1.getText().toString().equals("")){
                subtext1.setText(text2.getText());
                text2.setText("");
            }else{

                if(subtext2.getText().toString().equals("")){
                    subtext2.setText(text2.getText());
                    text2.setText("");
                }else{

                    if(subtext3.getText().toString().equals("")){

                        subtext3.setText(text2.getText());
                        text2.setText("");
                    }else{

                        if(subtext4.getText().toString().equals("")){
                            subtext4.setText(text2.getText());
                            text2.setText("");
                        }

                    }


                }
            }



        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void posicion3(View view){

        try{


            if(subtext1.getText().toString().equals("")){
                subtext1.setText(text3.getText());
                text3.setText("");
            }else{

                if(subtext2.getText().toString().equals("")){
                    subtext2.setText(text3.getText());
                    text3.setText("");
                }else{

                    if(subtext3.getText().toString().equals("")){

                        subtext3.setText(text3.getText());
                        text3.setText("");
                    }else{

                        if(subtext4.getText().toString().equals("")){
                            subtext4.setText(text3.getText());
                            text3.setText("");
                        }

                    }


                }
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void posicion4(View view){

        try{


            if(subtext1.getText().toString().equals("")){
                subtext1.setText(text4.getText());
                text4.setText("");
            }else{

                if(subtext2.getText().toString().equals("")){
                    subtext2.setText(text4.getText());
                    text4.setText("");
                }else{

                    if(subtext3.getText().toString().equals("")){

                        subtext3.setText(text4.getText());
                        text4.setText("");
                    }else{

                        if(subtext4.getText().toString().equals("")){
                            subtext4.setText(text4.getText());
                            subtext4.setText("");
                        }

                    }


                }
            }





        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public  void  regresar1(View view){
        text.setText(" nací ");
        text2.setText(" Yo ");
        text3.setText(" Guayaquil ");
        text4.setText(" en ");
        subtext1.setText("");
        subtext2.setText("");
        subtext3.setText("");
        subtext4.setText("");



    }


    public  void verificar(View view){
        if(subtext1.getText().toString().equals(" Yo ")&& subtext2.getText().equals(" nací ")&&subtext3.getText().toString().equals(" en ")&&subtext4.getText().toString().equals(" Guayaquil ")){
            correcto();
            correcto.start();
            barra.setProgress(50);
            Intent i = new Intent(this, introducciontres.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            //overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);
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
