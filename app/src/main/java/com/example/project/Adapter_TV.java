
package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_TV extends RecyclerView.Adapter<Adapter_TV.ViewHolder>
{
    Context context;
    ArrayList<show> tvs;

    public Adapter_TV(Context context, ArrayList<show> tvs) {
        this.context = context;
        this.tvs = tvs;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tv,parent,false);//R.layout.tv should be in
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            final show moviez=tvs.get(position);
            holder.tx1.setText(moviez.getName());
            holder.tx2.setText(moviez.getRating());
            holder.tx3.setText(moviez.getGenre());
        Picasso.with(context).load(moviez.img).fit().into(holder.img);
        holder.constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,moviedetails.class);
                intent.putExtra("movie",  moviez);
                intent.putExtra("moviename", moviez.getName());
                intent.putExtra("movierating", moviez.getRating());
                intent.putExtra("moviegenre", moviez.getGenre());
                intent.putExtra("moviedescription", moviez.getDescription());
                intent.putExtra("movieimg",  moviez.getImg());
                intent.putExtra("cast",moviez.getCast());
                intent.putExtra("moviedate",moviez.getDate());
                intent.putExtra("movietime",moviez.getTime());
                context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount() {
        return tvs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx1,tx2,tx3,tx4,tx5,tx6;
        ImageView img;
        ConstraintLayout constraintLayout1;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx1=(TextView)itemView.findViewById(R.id.tvname);
            tx2=(TextView)itemView.findViewById(R.id.tvgenre);
            tx3=(TextView)itemView.findViewById(R.id.tvrating);
            img=itemView.findViewById(R.id.tvPIC);
            constraintLayout1=itemView.findViewById(R.id.tv1);

        }
    }
}
