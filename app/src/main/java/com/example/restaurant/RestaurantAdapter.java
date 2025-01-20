package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private Context context;
    private List<Restaurant> restaurants;

    public RestaurantAdapter(Context context) {
        this.context = context;
    }

    public void setData (List<Restaurant> list) {
        this.restaurants = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
         Restaurant restaurant = restaurants.get(position);
         if (restaurant == null) return;

         holder.tvName.setText(restaurant.getName());
         holder.tvTimeAccess.setText(restaurant.getTimeAccess());

         holder.cvRestaurant.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showDialog(restaurant);
             }
         });
    }

    private void showDialog(Restaurant restaurant) {
        new androidx.appcompat.app.AlertDialog.Builder(context)
                .setTitle(restaurant.getName())
                .setMessage(restaurant.getTimeAccess())
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }


    @Override
    public int getItemCount() {
        if (restaurants != null) return restaurants.size();
        return 0;
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {

        private CardView cvRestaurant;
        private TextView tvName, tvTimeAccess;
        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            cvRestaurant = itemView.findViewById(R.id.cvRestaurant);
            tvName = itemView.findViewById(R.id.tvName);
            tvTimeAccess = itemView.findViewById(R.id.tvTimeAccess);
        }
    }
}
