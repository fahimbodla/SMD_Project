
package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Home_TV extends RecyclerView.Adapter<Adapter_Home_TV.ViewHolder>
{
    Context context;
    ArrayList<show> movies;
  //  ArrayList<show> copy_movie;

    public Adapter_Home_TV(Context context, ArrayList<show> movies) {
        this.context = context;
        this.movies = movies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.home_movies,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

            final show moviez=movies.get(position);
            holder.tx1.setText(moviez.getName());
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
        TextView tx1;
        ImageView img;
        ConstraintLayout constraintLayout;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx1=(TextView)itemView.findViewById(R.id.movie);
            img=itemView.findViewById(R.id.img);
            constraintLayout=itemView.findViewById(R.id.homemovies1);
        }
    }
}
