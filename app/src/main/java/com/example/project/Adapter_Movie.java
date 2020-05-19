
package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.*;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;

public class Adapter_Movie extends RecyclerView.Adapter<Adapter_Movie.ViewHolder>

{
    Context context;
    ArrayList<show> movies;
    ArrayList<show> copy_movie;
    public Adapter_Movie(Context context, ArrayList<show> movies, ArrayList<show> copy_movie) {
        this.context = context;
        this.movies = movies;
        this.copy_movie = copy_movie;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.movies,parent,false);
return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            final show moviez=movies.get(position);
            holder.tx1.setText(moviez.getName());
            holder.tx2.setText(moviez.getRating());
            holder.tx3.setText(moviez.getGenre());
             Picasso.with(context).load(moviez.img).fit().into(holder.img);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,moviedetails.class);
                    intent.putExtra("movie",  moviez);
                    intent.putExtra("moviename", moviez.getName());
                    intent.putExtra("movierating", moviez.getRating());
                    intent.putExtra("moviegenre", moviez.getGenre());
                    intent.putExtra("moviedescription", moviez.getDescription());
                    intent.putExtra("movieimg",  moviez.getImg());
                    intent.putExtra("moviedate",moviez.getDate());
                    intent.putExtra("movietime",moviez.getTime());
                    intent.putExtra("cast",moviez.getCast());
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx1,tx2,tx3,tx4,tx5,tx6;
        ImageView img;
        ConstraintLayout constraintLayout;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx1=(TextView)itemView.findViewById(R.id.name);
            tx2=(TextView)itemView.findViewById(R.id.rating);
            tx3=(TextView)itemView.findViewById(R.id.genre);
            img=itemView.findViewById(R.id.movPIC);
            constraintLayout=itemView.findViewById(R.id.movie1);
        }
    }

}
