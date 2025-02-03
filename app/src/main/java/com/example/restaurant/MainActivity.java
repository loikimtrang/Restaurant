package com.example.restaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.restaurant.fragment.HotProductFragment;
import com.example.restaurant.fragment.NotificationFragment;
import com.example.restaurant.fragment.ProductFragment;
import com.example.restaurant.fragment.RevenueFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout frContent;
    LinearLayout navRevenue, navProducts, navHotProducts, navNotifications;
    ImageView imgRevenue, imgProducts, imgHotProducts, imgNotifications;
    TextView txtRevenue, txtProducts, txtHotProducts, txtNotifications;

    FragmentManager fragmentManager;

    private final int selectedColor = 0xFFFFFFFF; // Màu trắng khi được chọn
    private final int defaultColor = 0xFF888888; // Màu xám khi không được chọn

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        frContent = findViewById(R.id.frContent);
        navRevenue = findViewById(R.id.navRevenue);
        navProducts = findViewById(R.id.navProducts);
        navHotProducts = findViewById(R.id.navHotProducts);
        navNotifications = findViewById(R.id.navNotifications);

        imgRevenue = findViewById(R.id.imgRevenue);
        imgProducts = findViewById(R.id.imgProducts);
        imgHotProducts = findViewById(R.id.imgHotProducts);
        imgNotifications = findViewById(R.id.imgNotifications);

        txtRevenue = findViewById(R.id.txtRevenue);
        txtProducts = findViewById(R.id.txtProducts);
        txtHotProducts = findViewById(R.id.txtHotProducts);
        txtNotifications = findViewById(R.id.txtNotifications);

        fragmentManager.beginTransaction().replace(R.id.frContent, new RevenueFragment()).commit();
        updateSelectedTab(imgRevenue, txtRevenue);
        navRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RevenueFragment revenueFragment = new RevenueFragment();
                fragmentManager.beginTransaction().replace(R.id.frContent, revenueFragment).commit();
                updateSelectedTab(imgRevenue, txtRevenue);

            }
        });

        navProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductFragment productFragment = new ProductFragment();
                fragmentManager.beginTransaction().replace(R.id.frContent, productFragment).commit();
                updateSelectedTab(imgProducts, txtProducts);
            }
        });

        navHotProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotProductFragment hotProductFragment = new HotProductFragment();
                fragmentManager.beginTransaction().replace(R.id.frContent, hotProductFragment).commit();
                updateSelectedTab(imgHotProducts, txtHotProducts);
            }
        });

        navNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFragment notificationFragment = new NotificationFragment();
                fragmentManager.beginTransaction().replace(R.id.frContent, notificationFragment).commit();
                updateSelectedTab(imgNotifications, txtNotifications);
            }
        });
    }

    private void updateSelectedTab(ImageView selectedImg, TextView selectedTxt) {
        imgRevenue.setColorFilter(defaultColor);
        imgProducts.setColorFilter(defaultColor);
        imgHotProducts.setColorFilter(defaultColor);
        imgNotifications.setColorFilter(defaultColor);

        txtRevenue.setTextColor(defaultColor);
        txtProducts.setTextColor(defaultColor);
        txtHotProducts.setTextColor(defaultColor);
        txtNotifications.setTextColor(defaultColor);

        selectedImg.setColorFilter(selectedColor);
        selectedTxt.setTextColor(selectedColor);

    }
}
