package com.example.restaurant.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurant.R;
import com.example.restaurant.Restaurant;
import com.example.restaurant.RestaurantAdapter;

import java.util.ArrayList;
import java.util.List;

public class RevenueFragment extends Fragment {
    private RecyclerView rcvRestaurant;
    private RestaurantAdapter restaurantAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_revenue, container, false);

        rcvRestaurant = view.findViewById(R.id.rcvRestaurant);
        restaurantAdapter = new RestaurantAdapter(getContext());  // or getActivity() if required

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvRestaurant.setLayoutManager(linearLayoutManager);

        restaurantAdapter.setData(getListRestaurant());
        rcvRestaurant.setAdapter(restaurantAdapter);

        return view;
    }

    private List<Restaurant> getListRestaurant() {
        List<Restaurant> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Restaurant(Integer.toString(i), "Truy cập lần cuối: 06.25.2021 15:00:00"));
        }
        return list;
    }
}
