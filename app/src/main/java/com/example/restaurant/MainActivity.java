package com.example.restaurant;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvRestaurant;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcvRestaurant = findViewById(R.id.rcvRestaurant);
        restaurantAdapter = new RestaurantAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvRestaurant.setLayoutManager(linearLayoutManager);

        restaurantAdapter.setData(getListRestaurant());

        rcvRestaurant.setAdapter(restaurantAdapter);
    }

    private List<Restaurant> getListRestaurant() {
        List<Restaurant> list = new ArrayList<>();

        for (int i =0; i< 20; i++) {
            list.add(new Restaurant(Integer.toString(i), "Truy cập lần cuối: 06.25.2021 15:00:00"));
        }
        return list;
    }

}