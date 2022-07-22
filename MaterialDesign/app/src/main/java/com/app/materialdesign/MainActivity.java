package com.app.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvTitle;
    TextView tvClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Hello Java");
        tvClick = findViewById(R.id.tv_clcik);

        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Textview clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //tvTitle.setTextSize(40);

      /*  actionBar = getSupportActionBar();
        actionBar.setTitle("Dashboard");
        actionBar.setSubtitle("dashboard");
        actionBar.setDisplayHomeAsUpEnabled(true);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation:
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show();
        return super.onSupportNavigateUp();
    }
}