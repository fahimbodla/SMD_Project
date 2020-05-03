package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class favourites extends AppCompatActivity {
    ArrayList<show>  favour=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        RecyclerView recyclerView=findViewById(R.id.recyclerfav);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
        Adapter_Favourite adapter_favourite=new Adapter_Favourite(this,favour);
        recyclerView.setAdapter(adapter_favourite);
    }
    private void getData()
    {
        if( getIntent().hasExtra("ADD"))
        {
            show shows =(show)getIntent().getParcelableExtra("ADD");
            favour.add(shows);
        }
        else if( getIntent().hasExtra("REMOVE"))
        {
            show shows =(show)getIntent().getParcelableExtra("REMOVE");
            favour.remove(shows);
        }
        else
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
    }

}
