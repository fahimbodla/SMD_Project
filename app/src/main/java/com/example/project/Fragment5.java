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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment5 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment5,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final ArrayList<show> shows=new ArrayList<>();
        final ArrayList<String>l1=new ArrayList<>();
       final Adapter_Upcoming adapter_upcoming =new Adapter_Upcoming(getContext(),shows);
        recyclerView.setAdapter(adapter_upcoming);
        for(int i=598;i<628;i++) {
            String k=Integer.toString(i);
            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        l1.add(dataSnapshot1.getValue().toString());
                    }

                    if(l1.get(14).compareTo("series")==0) {
                        show move = new show(l1.get(13), l1.get(4), l1.get(7), l1.get(20), l1.get(12), l1.get(10), l1.get(8), l1.get(0));
                        shows.add(move);
                        adapter_upcoming.notifyDataSetChanged();
                    }
                    else
                    {
                        show move = new show(l1.get(16), l1.get(6), l1.get(9), l1.get(23), l1.get(15), l1.get(13), l1.get(10), l1.get(0));
                        shows.add(move);
                        adapter_upcoming.notifyDataSetChanged();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        return view;
    }
}
