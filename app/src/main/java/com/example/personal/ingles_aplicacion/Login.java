package com.example.personal.ingles_aplicacion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private Button btnIngresar;
    private EditText email, password;
    private TextView registro;
    private ProgressBar progressBar;
    StringRequest stringRequest;
    private static String URL_LOGIN = "http://codigoinformatico.com/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = (Button)findViewById(R.id.btnLogin);
        registro = (TextView)findViewById(R.id.register);
        progressBar = (ProgressBar)findViewById(R.id.loading);

        email = (EditText)findViewById(R.id.l_email);
        password = (EditText)findViewById(R.id.l_password);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
                   log(mEmail, mPass);
                }else {
                    email.setError("Por favor ingresa un correo");
                    password.setError("Por favor ingresa una contraseña");
                }
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registro.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void log(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);
        btnIngresar.setVisibility(View.GONE);


        String url="http://codigoinformatico.com/ingreso.php?email="+ email+
                "&password=" + password;

        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                    //JSONObject jsonObject = new JSONObject(response);


                    if (response.trim().equals("bien")) {


                        Intent i = new Intent(getApplication(), Home.class);


                        Intent intent = new Intent(Login.this, Home.class);
                        correcto();
                        //Toast.makeText(getApplication(), email, Toast.LENGTH_SHORT).show();

                        startActivity(intent);


                        startActivity(i);
                        finish();


                    } else {
                        progressBar.setVisibility(View.GONE);


                        Toast.makeText(getApplication(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();


                    }

                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplication(),"No se ha podido conectar" + error,Toast.LENGTH_SHORT).show();

            }
        });
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplication()).addToRequestQueue(stringRequest);
    }


    private void LoginResponse(final String email, final String password){
        progressBar.setVisibility(View.VISIBLE);
        btnIngresar.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();

                                    /*Toast.makeText(Login.this,
                                            "Ingreso Satisfactorio. \nTu nombre:"
                                                    +name+"\nTu correo:"+email,
                                            Toast.LENGTH_LONG).show();
                                     */

                                    Intent intent = new Intent(Login.this,Home.class);
                                    intent.putExtra("name",name);
                                    intent.putExtra("email",email);
                                    startActivity(intent);

                                    progressBar.setVisibility(View.GONE);
                                    finish();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressBar.setVisibility(View.GONE);
                            btnIngresar.setVisibility(View.VISIBLE);
                            Toast.makeText(Login.this,"Error en el ingreso "+e.toString(),
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        btnIngresar.setVisibility(View.VISIBLE);
                        Toast.makeText(Login.this,"Error en el ingreso "+error.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void correcto() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View customToast = inflater.inflate(R.layout.toas_personalizado, null);
        TextView txt = (TextView) customToast.findViewById(R.id.txttoas);
        txt.setText("Bienvenido Usuario");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(customToast);
        toast.show();
    }
}
