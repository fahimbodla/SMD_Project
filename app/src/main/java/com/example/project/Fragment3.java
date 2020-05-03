package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment3 extends Fragment {

    @Nullable

    Adapter_Movie adapter_movie;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment3,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclermovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        show movie1=new show("Sherlock","Mystery"," Movie","9","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie2=new show("Avengers","action"," Mvoie","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie3=new show("3 idiots","Mystery","7 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie4=new show("Munna Bhai MBBS","Comedy","12 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie5=new show("Game Over","Mystery","Se","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie6=new show("PK","Mystery","SHe","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie7=new show("Sanju","Mystery","SHee","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        ArrayList<show>movies=new ArrayList<>();
        movies.add(movie1);movies.add(movie2);movies.add(movie3);movies.add(movie4);movies.add(movie5);movies.add(movie6);movies.add(movie7);
        ArrayList<show>copy=movies;
        Adapter_Movie adapter_movie=new Adapter_Movie(getContext(),movies,copy);
        recyclerView.setAdapter(adapter_movie);

        return view;
    }


    }

