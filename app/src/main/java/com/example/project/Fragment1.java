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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment1,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.homemovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final ArrayList<show> movies=new ArrayList<>();
        ArrayList<show>copy=movies;
        final Adapter_Home_Movies adapter_home_movies=new Adapter_Home_Movies(getContext(),movies);
        recyclerView.setAdapter(adapter_home_movies);
        final ArrayList<String>l1=new ArrayList<>();
        for(int i=0;i<499;i++) {
            String k=Integer.toString(i);
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        l1.add(dataSnapshot1.getValue().toString());
                    }
                    if(l1.get(6).length()==0) {
                        l1.set(6,l1.get(12));
                    }
                    String k1=l1.get(4).substring(0,l1.get(4).length()-1);
                    l1.set(4,k1);
                    String k2=l1.get(4).substring(1,l1.get(4).length());
                    l1.set(4,k2);
                    String k3=l1.get(3).substring(2);
                    l1.set(3,k3);
                    String k4=l1.get(0).substring(0,l1.get(0).length()-1);
                    l1.set(0,k4);
                    String k5=l1.get(0).substring(1,l1.get(0).length());
                    l1.set(0,k5);
                    show move = new show(l1.get(6), l1.get(4), l1.get(11), l1.get(5), l1.get(3), l1.get(10),l1.get(8),l1.get(0));
                    movies.add(move);
                    adapter_home_movies.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        RecyclerView recyclerView1=view.findViewById(R.id.hometv);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        final ArrayList<show> tvs=new ArrayList<>();
         final Adapter_Home_TV adapter_home_tv=new Adapter_Home_TV(getContext(),tvs);
        recyclerView1.setAdapter(adapter_home_tv);
        for(int i=500;i<597;i++) {
            String k=Integer.toString(i);
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        l1.add(dataSnapshot1.getValue().toString());
                    }
                    show move = new show(l1.get(14), l1.get(4), l1.get(7), l1.get(19), l1.get(13), l1.get(11),l1.get(8),l1.get(0));
                    tvs.add(move);
                    adapter_home_tv.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        return view;

    }
}
