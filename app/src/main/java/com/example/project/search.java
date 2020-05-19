package com.example.project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("deprecation")
public class search extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_Search adapter_search;
    ArrayList<show> list = new ArrayList<>();
    SearchView searchView;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final ArrayList<String> l1 = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclersearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getParent(), LinearLayoutManager.VERTICAL, false));
        adapter_search=new Adapter_Search(getParent(),list);
        recyclerView.setAdapter(adapter_search);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.searching);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchs(s);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void searchs(final String s) {
        DatabaseReference myRef;
        final ArrayList<String> l1 = new ArrayList<>();
        for (int i = 0; i < 499; i++) {
            String k = Integer.toString(i);
            myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        l1.add(dataSnapshot1.getValue().toString());
                    }
                    double k = Double.parseDouble(l1.get(5));
                    if (l1.get(6).length() == 0) {
                        l1.set(6, l1.get(12));
                    }
                    String k1 = l1.get(4).substring(0, l1.get(4).length() - 1);
                    l1.set(4, k1);
                    String k2 = l1.get(4).substring(1, l1.get(4).length());
                    l1.set(4, k2);
                    String k3 = l1.get(3).substring(2);
                    l1.set(3, k3);
                    show move = new show(l1.get(6), l1.get(4), l1.get(11), l1.get(5), l1.get(3), l1.get(10), l1.get(8), l1.get(0));
                    if (l1.get(6).compareTo(s) == 0) {
                        list.add(move);
                        adapter_search.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        for (int i = 500; i < 597; i++) {
            String k = Integer.toString(i);
            myRef = FirebaseDatabase.getInstance().getReference().child("Data").child(k);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    l1.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        l1.add(dataSnapshot1.getValue().toString());
                    }
                    show move = new show(l1.get(14), l1.get(4), l1.get(7), l1.get(19), l1.get(13), l1.get(11), l1.get(8), l1.get(0));
                    if (l1.get(19).compareTo("N/A") != 0) {
                        if (l1.get(6).compareTo(s) == 0) {
                            list.add(move);
                            adapter_search.notifyDataSetChanged();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}