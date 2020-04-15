package com.example.project;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment2,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.movies);
        String name,rating,genre,description;
        name=rating=genre=description="HUM";
        Uri uri=Uri.parse("C:\\Users\\HEWLETT PACKARD\\AndroidStudioProjects\\Project\\app\\src\\main\\res\\drawable\\ic_launcher_background.xml");
        Adapter2 adapter2=new Adapter2(this.getContext(),name,rating,genre,description,uri);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
}
