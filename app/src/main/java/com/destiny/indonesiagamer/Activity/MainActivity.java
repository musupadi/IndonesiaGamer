package com.destiny.indonesiagamer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.destiny.indonesiagamer.Activity.ui.HomeFragment;
import com.destiny.indonesiagamer.Activity.ui.TokokuFragment;
import com.destiny.indonesiagamer.Activity.ui.UserFragment;
import com.destiny.indonesiagamer.R;
import com.destiny.indonesiagamer.SharedPreferance.DB_Helper;

public class MainActivity extends AppCompatActivity {
    LinearLayout LHome,LUser,LShop;
    TextView THome,TUser,TShop;
    ImageView IHome,IUser,IShop;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DB_Helper dbHelper = new DB_Helper(MainActivity.this);
        Cursor cursor = dbHelper.checkUser();
        if (cursor.getCount()<1){
            Intent intent = new Intent(MainActivity.this,SplashActivity.class);
            startActivity(intent);
            finish();
        }
        Declaration();
        Home();
        OnClick();
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }
    private void OnClick(){
        LHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });
        LShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tokoku();
            }
        });
        LUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User();
            }
        });
    }
    private void Default(){
        IHome.setImageResource(R.drawable.home);
        THome.setTextColor(Color.rgb(0,0,0));
        IUser.setImageResource(R.drawable.user);
        TUser.setTextColor(Color.rgb(0,0,0));
        IShop.setImageResource(R.drawable.tokoku);
        TShop.setTextColor(Color.rgb(0,0,0));
    }
    private void Home(){
        Default();
        IHome.setImageResource(R.drawable.home_active);
        THome.setTextColor(Color.rgb(255,0,0));
        fragment = new HomeFragment();
        ChangeFragment(fragment);
    }
    private void Tokoku(){
        Default();
        IShop.setImageResource(R.drawable.tokoku_active);
        TShop.setTextColor(Color.rgb(255,0,0));
        fragment = new TokokuFragment();
        ChangeFragment(fragment);
    }
    private void User(){
        Default();
        IUser.setImageResource(R.drawable.user_active);
        TUser.setTextColor(Color.rgb(255,0,0));
        fragment = new UserFragment();
        ChangeFragment(fragment);
    }
    private void Declaration(){
        //Linear
        LHome = findViewById(R.id.linearHome);
        LUser = findViewById(R.id.linearUser);
        LShop = findViewById(R.id.linearTokoku);
        //TextView
        THome = findViewById(R.id.tvHome);
        TUser = findViewById(R.id.tvUser);
        TShop = findViewById(R.id.tvToko);
        //ImageView
        IHome = findViewById(R.id.ivHome);
        IUser = findViewById(R.id.ivUser);
        IShop = findViewById(R.id.ivTokoku);
    }
}