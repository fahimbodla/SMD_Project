
package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_RecentlyWatched extends RecyclerView.Adapter<Adapter_RecentlyWatched.ViewHolder>
{
    Context context;
    ArrayList<show> movies;

    public Adapter_RecentlyWatched(Context context, ArrayList<show> movies ){
        this.context = context;
        this.movies = movies;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.recentlywatched,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            final show moviez=movies.get(position);
            holder.tx1.setText(moviez.getName());
            holder.tx2.setText(moviez.getRating());
            holder.tx3.setText(moviez.getGenre());
            holder.img.setImageResource(moviez.img);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,moviedetails.class);
                    intent.putExtra("movie",  moviez);
                    intent.putExtra("moviename", moviez.getName());
                    intent.putExtra("movierating", moviez.getRating());
                    intent.putExtra("moviegenre", moviez.getGenre());
                    intent.putExtra("moviedescription", moviez.getDescription());
                    intent.putExtra("movieimg", moviez.getImg());
                    intent.putExtra("moviedate",moviez.getDate());
                    intent.putExtra("movietime",moviez.getTime());
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
            tx2=(TextView)itemView.findViewById(R.id.genre);
            tx3=(TextView)itemView.findViewById(R.id.rating);
            img=itemView.findViewById(R.id.movPIC);
            constraintLayout=itemView.findViewById(R.id.rec);
        }
    }
}
