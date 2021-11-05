package com.pam.foodapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ListViewHolder> {
    private ArrayList<Food> foods;

    FoodsAdapter(ArrayList<Food> list) {
        this.foods = list;
    }

    @NonNull
    @Override
    public FoodsAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsAdapter.ListViewHolder holder, int position) {
        Food food = foods.get(position);

        holder.title.setText(food.title);
        holder.price.setText(food.price);
        holder.image.setBackground(food.image);
        holder.image.setImageDrawable(food.image);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title, description, price;
        public ListViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.food_image);
            title = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.food_price);
        }


        @Override
        public void onClick(View view) {
            int selected = getLayoutPosition();
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("id", selected);
            view.getContext().startActivity(intent);
        }
    }
}
