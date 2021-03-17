package com.example.retrofitapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    Context context;
    ArrayList<Hero> arrayList;

    public DataAdapter(Context context, ArrayList<Hero> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_file, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Hero hero = arrayList.get(position);

        Picasso.get().load(hero.getImageurl()).into(holder.imageView);
        holder.name.setText(hero.getName());
        holder.realname.setText(hero.getRealname());
        holder.firstappearance.setText(hero.getFirstappearance());
        holder.createdby.setText(hero.getCreatedby());
        holder.publisher.setText(hero.getPublisher());
        holder.bio.setText(hero.getBio());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView tvID;
        ImageView imageView;
        TextView name, realname, team, firstappearance, createdby, publisher, bio;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            realname = itemView.findViewById(R.id.realname);
            firstappearance = itemView.findViewById(R.id.firstappearance);
            createdby = itemView.findViewById(R.id.createdby);
            publisher = itemView.findViewById(R.id.publisher);
            bio = itemView.findViewById(R.id.bio);
        }
    }
}
