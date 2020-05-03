package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class recentlywatched extends AppCompatActivity {
    ArrayList<show>  watch=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentlywatched);
        RecyclerView recyclerView=findViewById(R.id.recyclerrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
        Adapter_RecentlyWatched adapter_recentlyWatched=new Adapter_RecentlyWatched(this,watch);
        recyclerView.setAdapter(adapter_recentlyWatched);
    }
    private void getData()
    {
        if( getIntent().hasExtra("ADD"))
        {
            show shows =(show)getIntent().getParcelableExtra("ADD");
            watch.add(shows);
        }
        else if( getIntent().hasExtra("REMOVE"))
        {
            show shows =(show)getIntent().getParcelableExtra("REMOVE");
            watch.remove(shows);
        }
        else
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
    }
}
