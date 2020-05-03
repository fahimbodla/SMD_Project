

package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter_Search extends RecyclerView.Adapter<Adapter_Search.ViewHolder> //implements Filterable
{
    Context context;
    ArrayList<show> shows;
    ArrayList<show> shows1;
   // ArrayList<show> copy_movie;

    public Adapter_Search(Context context, ArrayList<show> shows ) {
        this.context = context;
        this.shows = shows;
        shows1=new ArrayList<>(shows);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.search,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            final show moviez=shows.get(position);
            holder.tx1.setText(moviez.getName());
            holder.tx2.setText(moviez.getRating());
            holder.tx3.setText(moviez.getGenre());
            holder.img.setImageResource(moviez.img);
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,moviedetails.class);
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
        return shows.size();
    }
    /*
    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<show> filteredList=new ArrayList<>();
            if(constraint.toString().isEmpty())
            {
                    filteredList.addAll(shows1);
            }
            else
            {

            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return  filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                shows.clear();
                shows.addAll((Collection<? extends show>) results.values);
                notifyDataSetChanged();
        }
        };
*/
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
            constraintLayout=itemView.findViewById(R.id.sea1);
        }
    }

}
