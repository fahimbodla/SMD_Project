package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment5 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment5,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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
        Adapter_Upcoming adapter_upcoming =new Adapter_Upcoming(getContext(),shows);
        recyclerView.setAdapter(adapter_upcoming);
        return view;
    }
}
