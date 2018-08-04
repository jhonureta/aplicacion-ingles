package com.example.personal.ingles_aplicacion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity  implements Response.Listener<JSONObject>, Response.ErrorListener  {
    private Button btnAtrasR, btnRegistro;
    private ProgressBar loading;
    private EditText name, email, password, c_password;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    private static String URL_REGIST = "http://www.codigoinformatico.com/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.c_password);
        loading = (ProgressBar) findViewById(R.id.loading);
        request= Volley.newRequestQueue(this);

        btnAtrasR = (Button)findViewById(R.id.btnAtras);
        btnRegistro = (Button)findViewById(R.id.btnRegistro);



        btnAtrasR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivit.class);
                startActivity(intent);
                finish();
            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cargarwebservice();
            }
        });
    }


    /*private void Regist(){
        loading.setVisibility(View.VISIBLE);
        btnRegistro.setVisibility(View.GONE);

        final String nameS = this.name.getText().toString().trim();
        final String emailS = this.email.getText().toString().trim();
        final String passwordS = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                loading.setVisibility(View.GONE);
                                btnRegistro.setVisibility(View.VISIBLE);
                                name.setText("");
                                email.setText("");
                                password.setText("");
                                c_password.setText("");
                                Toast.makeText(Registro.this,"Registro Éxitoso! ",Toast.LENGTH_LONG).show();
                            }

                        }catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Registro.this,"Registro Fállido! "+e.toString(),
                                    Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            btnRegistro.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registro.this,"Registro Fállido!"+error.toString(),
                                Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);
                        btnRegistro.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",nameS);
                params.put("email",emailS);
                params.put("password",passwordS);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/


    public void cargarwebservice(){


        try {

            loading.setVisibility(View.VISIBLE);
                //https://clinicaprotoipo.000webhostapp.com/registro.php
                String url = "http://www.codigoinformatico.com/registro.php?email=" + email.getText().toString()
                        + "&name=" + name.getText().toString()+ "&password=" + password.getText().toString();
                url = url.replace(" ", "%20");
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
                request.add(jsonObjectRequest);


        }catch (Exception exe){
            Toast.makeText(this,exe.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("ERROR", error.toString());
    }

    /**
     * Called when a response is received.
     *
     * @param response
     */
    @Override
    public void onResponse(JSONObject response) {
        loading.setVisibility(View.GONE);
        Toast.makeText(this,"Se registrado correctamente", Toast.LENGTH_SHORT).show();

        name.setText("");
        email.setText("");
        password.setText("");

        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
