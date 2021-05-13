package com.destiny.indonesiagamer.Activity.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.destiny.indonesiagamer.API.ApiRequest;
import com.destiny.indonesiagamer.API.RetroServer;
import com.destiny.indonesiagamer.Activity.Adapter.AdapterBanner;
import com.destiny.indonesiagamer.Activity.ui.Game.ListGameActivity;
import com.destiny.indonesiagamer.Model.DataModel;
import com.destiny.indonesiagamer.Model.ResponseModel;
import com.destiny.indonesiagamer.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;

    LinearLayout Game;

    //Slider

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private AdapterBanner adapterBanner;
    private Button btnBack, btnNext, btnPlay, btnPause, btnStop;
    private TextView[] mDots;
    private int CurrentPage;

    int SizeBanner = 0;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Game = view.findViewById(R.id.linearListGame);
        //Slider
        mSlideViewPager = view.findViewById(R.id.SlideViewPager);
        mDotLayout = view.findViewById(R.id.dotSlayout);
        Header(0);
        Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListGameActivity.class);
                startActivity(intent);
            }
        });
    }
    ViewPager.OnPageChangeListener viewList = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            CurrentPage = i;

            if (CurrentPage == 0) {

            } else if (i == mDots.length - 1) {

            } else {

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
//            final Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                public void run() {
//                    if (CurrentPage == 0) {
//                        forward=true;
//                        mSlideViewPager.setCurrentItem(CurrentPage + 1);
//                    } else if (CurrentPage == mDots.length - 1) {
//                        forward=false;
//                        mSlideViewPager.setCurrentItem(CurrentPage - 1);
//                    } else {
//                        if (forward){
//                            mSlideViewPager.setCurrentItem(CurrentPage + 1);
//                        }else{
//                            mSlideViewPager.setCurrentItem(CurrentPage - 1);
//                        }
//                    }
//                }
//            }, 5000);
        }
    };
    private void Header(final int position){
        mManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
//        recycler.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> KabarBerita = api.Game_Limit();
        KabarBerita.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    mItems=response.body().getData();
                    adapterBanner = new AdapterBanner(getActivity(),mItems);
                    mSlideViewPager.setAdapter(adapterBanner);
                    SizeBanner = mItems.size();
                    addDotsIndicator(position);
                    mSlideViewPager.addOnPageChangeListener(viewList);
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addDotsIndicator(int posistion) {
        try {
            mDots = new TextView[SizeBanner];
            mDotLayout.removeAllViews();
            for (int i = 0; i < mDots.length; i++) {
                mDots[i] = new TextView(getActivity());
                mDots[i].setText(Html.fromHtml("&#8226;"));
                mDots[i].setTextSize(35);
                mDots[i].setTextColor(getResources().getColor(R.color.Primary));

                mDotLayout.addView(mDots[i]);
            }
            if (mDots.length > 0) {
                mDots[posistion].setTextColor(getResources().getColor(R.color.Secondary));
            }
        }catch (Exception e){

        }
    }
}