package com.example.personal.ingles_aplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private Button btnLogout,btnGames;
    private TextView name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String extraName = intent.getStringExtra("name");
        String extraEmail = intent.getStringExtra("email");

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnGames = (Button) findViewById(R.id.startGames);

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);

        name.setText(extraName);
        email.setText(extraEmail);

        btnGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Games.class);
                startActivity(intent);
                finish();

            }
        });

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MainActivit.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
