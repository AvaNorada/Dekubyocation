package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class VolcanicEruptionsTips extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcanic_eruptions);

        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(new VolcanicEruptionsAdapter(this));
        listView.setOnItemClickListener(this);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Volcanic Eruption");
        setSupportActionBar(toolbar);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent i = new Intent(this, VE_B.class);
                startActivity(i);
                break;
            case 1:
                Intent j = new Intent(this, VE_D.class);
                startActivity(j);
                break;
            case 2:
                Intent k = new Intent(this, VE_A.class);
                startActivity(k);
                break;
        }
    }
}