package com.example.project;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Fragment3 extends Fragment {

    private StorageReference mStorageRef;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ArrayList<show> mov=new ArrayList<>();
    DatabaseReference myRef ;
    Adapter_Movie adapter_movie;
    final ArrayList<show> movies = new ArrayList<>();
    final ArrayList<show> copy = movies;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment3, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recyclermovies);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        final ArrayList<String> l1=new ArrayList<>();
        final Adapter_Movie adapter_movie = new Adapter_Movie(getContext(), mov, copy);
        recyclerView.setAdapter(adapter_movie);
        for(int i=0;i<499;i++) {
            String k=Integer.toString(i);
            myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
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
               int ko= l1.get(4).length()-1;
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
                mov.add(move);
                adapter_movie.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }


}

