package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
public class search extends AppCompatActivity    {
    RecyclerView recyclerView;
    Adapter_Search adapter_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
         recyclerView=findViewById(R.id.recyclersearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        show movie1=new show("Sherlock","Mystery"," Movie","9","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie2=new show("Avengers","action"," Mvoie","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie3=new show("3 idiots","Mystery","7 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie4=new show("Munna Bhai MBBS","Comedy","12 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie5=new show("Game Over","Mystery","Se","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie6=new show("PK","Mystery","SHe","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie7=new show("Sanju","Mystery","SHee","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv1=new show("Game of Thrones","Fantasy","af","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv2=new show("Westworld","Mystrey","af","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv3=new show("Breaking Bad","Fantasy","9af","9.7","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv4=new show("Twin PEaks","Fantasy","af","0.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv5=new show("Lost","Fantasy","afa","9.8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv6=new show("Veep","Fantasy","9af4","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv7=new show("Narcos","Fantasy","9af4","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        ArrayList<show> shows=new ArrayList<>();
        shows.add(movie1);shows.add(movie2);shows.add(movie3);shows.add(movie4);shows.add(movie5);shows.add(movie6);shows.add(movie7);
        shows.add(tv1);shows.add(tv2);shows.add(tv3);shows.add(tv4);shows.add(tv5);shows.add(tv6);shows.add(tv7);

        Adapter_Search adapter_search =new Adapter_Search(this,shows);
        recyclerView.setAdapter(adapter_search);
    }


    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem menuItem= menu.findItem(R.id.searching);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter_search.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }*/


}
