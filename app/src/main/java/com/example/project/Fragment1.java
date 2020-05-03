package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment1,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.homemovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        show movie1=new show("Sherlock","Mystery"," Movie","9","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie2=new show("Avengers","action"," Mvoie","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie3=new show("3 idiots","Mystery","7 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie4=new show("Munna Bhai MBBS","Comedy","12 ","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie5=new show("Game Over","Mystery","Se","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie6=new show("PK","Mystery","SHe","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show movie7=new show("Sanju","Mystery","SHee","8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        ArrayList<show> movies=new ArrayList<>();
        movies.add(movie1);movies.add(movie2);movies.add(movie3);movies.add(movie4);movies.add(movie5);movies.add(movie6);movies.add(movie7);
        ArrayList<show>copy=movies;
        Adapter_Home_Movies adapter_home_movies=new Adapter_Home_Movies(getContext(),movies);
        recyclerView.setAdapter(adapter_home_movies);

        RecyclerView recyclerView1=view.findViewById(R.id.hometv);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        show tv1=new show("Game of Thrones","Fantasy","af","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv2=new show("Westworld","Mystrey","af","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv3=new show("Breaking Bad","Fantasy","9af","9.7","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv4=new show("Twin PEaks","Fantasy","af","0.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv5=new show("Lost","Fantasy","afa","9.8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv6=new show("Veep","Fantasy","9af4","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv7=new show("Narcos","Fantasy","9af4","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        ArrayList<show> tvs=new ArrayList<>();
        tvs.add(tv1);tvs.add(tv2);tvs.add(tv3);tvs.add(tv4);tvs.add(tv5);tvs.add(tv6);tvs.add(tv7);
         Adapter_Home_TV adapter_home_tv=new Adapter_Home_TV(getContext(),tvs);
        recyclerView1.setAdapter(adapter_home_tv);
        return view;

    }
}
