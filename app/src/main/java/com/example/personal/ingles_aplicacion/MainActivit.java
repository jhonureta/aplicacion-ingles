package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        FragmentManager fragment= getSupportFragmentManager();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        FragmentManager fragment= getSupportFragmentManager();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
            //fragment.beginTransaction().replace(R.id.content_main2, new listaproducto()).commit();
        }else if(id == R.id.listaproducto){
            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);
            finish();
        }else if(id == R.id.desarrollador){
            Intent intent = new Intent(this, desarrollador.class);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

}
