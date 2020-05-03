package com.example.project;

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

public class Fragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment4,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclertv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        show tv1=new show("Game of Thrones","Fantasy","af","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv2=new show("Westworld","Mystrey","af","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv3=new show("Breaking Bad","Fantasy","9af","9.7","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv4=new show("Twin PEaks","Fantasy","af","0.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv5=new show("Lost","Fantasy","afa","9.8","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv6=new show("Veep","Fantasy","9af4","7.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        show tv7=new show("Narcos","Fantasy","9af4","9.4","2h 35m ","1/1/2021",R.drawable.ic_insert_photo_black_24dp);
        ArrayList<show> tvs=new ArrayList<>();
        tvs.add(tv1);tvs.add(tv2);tvs.add(tv3);tvs.add(tv4);tvs.add(tv5);tvs.add(tv6);tvs.add(tv7);
        Adapter_TV adapter_tv=new Adapter_TV(getContext(),tvs);
        recyclerView.setAdapter(adapter_tv);
        return view;
    }


}
