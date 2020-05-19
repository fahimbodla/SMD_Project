package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class favourites extends AppCompatActivity {
    ArrayList<show>  favour=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        RecyclerView recyclerView=findViewById(R.id.recyclerfav);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<String>l1=new ArrayList<>();
        final Adapter_Favourite adapter_favourite=new Adapter_Favourite(this,favour);
         DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Favourite");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        GenericTypeIndicator<HashMap<String, String>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, String>>() {};
                        Map<String, String> objectHashMap = dataSnapshot1.getValue(objectsGTypeInd);
                        ArrayList<String> objectArrayList = new ArrayList<String>(objectHashMap.values());
                        String date=objectArrayList.get(0);
                        String cast=objectArrayList.get(1);
                        String img=objectArrayList.get(2);
                        String genre=objectArrayList.get(3);
                        String name=objectArrayList.get(4);
                        String rating=objectArrayList.get(5);
                        String desription=objectArrayList.get(6);
                        String time=objectArrayList.get(7);
                        show sho=new show(name,genre,desription,rating,time,date,img,cast);
                        favour.add(sho);
                        adapter_favourite.notifyDataSetChanged();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        recyclerView.setAdapter(adapter_favourite);
    }


}
