package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    private ArrayList animalList;

    MainActivityAdapter(ArrayList<Animal> animalList){
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.animal_layot, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal animalSetter = (Animal) animalList.get(position);
        holder.animalName.setText(animalSetter.getName());

        if(holder.animalName.getText()=="cat"){
            holder.animalImage.setImageResource(R.drawable.image_cat);
        }
        else if(holder.animalName.getText()=="dog"){
            holder.animalImage.setImageResource(R.drawable.image_dog);
        }
        else if(holder.animalName.getText()=="lion"){
            holder.animalImage.setImageResource(R.drawable.image_lion);
        }
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView animalImage;
        TextView animalName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage = itemView.findViewById(R.id.animalImage);
            animalName = itemView.findViewById(R.id.animalTextView);
        }
    }
}
