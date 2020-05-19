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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    @Nullable
    DatabaseReference myRef ;
    ArrayList<String>l1=new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment4,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclertv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final ArrayList<show> tvs=new ArrayList<>();
        final Adapter_TV adapter_tv=new Adapter_TV(getContext(),tvs);
        recyclerView.setAdapter(adapter_tv);
        for(int i=500;i<597;i++) {
            String k=Integer.toString(i);
            myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        l1.add(dataSnapshot1.getValue().toString());
                    }
                    show move = new show(l1.get(14), l1.get(4), l1.get(7), l1.get(19), l1.get(13), l1.get(11),l1.get(8),l1.get(0));
                    tvs.add(move);
                    adapter_tv.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        return view;
    }


}
