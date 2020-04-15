
package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.*;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder>
{
     String name,rating,genre,description;
    Context context;
    Uri uri;
    public Adapter2(Context context,String name, String rating, String genre, String description,Uri uri) {
        this.name = name;
        this.context=context;
        this.rating = rating;
        this.genre = genre;
        this.description = description;
        this.uri=uri;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.fragment2,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tx1.setText(name);
        holder.tx2.setText(genre);
        holder.tx3.setText(rating);
        holder.tx4.setText(description);
        holder.img.setImageURI(uri);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,moviedetails.class);
               context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx1,tx2,tx3,tx4;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx1=itemView.findViewById(R.id.name);
            tx2=itemView.findViewById(R.id.genre);
            tx3=itemView.findViewById(R.id.rating);
            tx4=itemView.findViewById(R.id.description);
            img=itemView.findViewById(R.id.moviePIC);
        }
    }
}
