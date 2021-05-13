package com.destiny.indonesiagamer.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.destiny.indonesiagamer.Activity.ui.Game.DeskripsiGame;
import com.destiny.indonesiagamer.Method.Destiny;
import com.destiny.indonesiagamer.Model.DataModel;
import com.destiny.indonesiagamer.R;
import com.destiny.indonesiagamer.SharedPreferance.DB_Helper;

import java.util.List;

public class AdapterListGame extends RecyclerView.Adapter<AdapterListGame.HolderData> {
    private List<DataModel> mList;
    private Context ctx;

    DB_Helper dbHelper;
    Boolean onClick=false;
    RecyclerView recyclerView;
    Destiny destiny;
    public AdapterListGame(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_game,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        destiny = new Destiny();
        final DataModel dm = mList.get(posistion);
        holderData.Nama.setText(dm.getNama_game());
        holderData.Platform.setText(dm.getPlatform_game());
        holderData.Deskripsi.setText(destiny.SmallDescription(dm.getDeskripsi_game()));
        Glide.with(ctx)
                .load(destiny.BASE_URL()+dm.getGambar_game())
                .into(holderData.Image);
        double Skor = Double.parseDouble(dm.getSkor());
        if (Skor<1.0){
            holderData.Star1.setImageResource(R.drawable.kosong_star);
            holderData.Star2.setImageResource(R.drawable.kosong_star);
            holderData.Star3.setImageResource(R.drawable.kosong_star);
            holderData.Star4.setImageResource(R.drawable.kosong_star);
            holderData.Star5.setImageResource(R.drawable.kosong_star);
        }else if(Skor >=1.0 && Skor<2.0){
            holderData.Star1.setImageResource(R.drawable.star);
            holderData.Star2.setImageResource(R.drawable.kosong_star);
            holderData.Star3.setImageResource(R.drawable.kosong_star);
            holderData.Star4.setImageResource(R.drawable.kosong_star);
            holderData.Star5.setImageResource(R.drawable.kosong_star);
        }else if(Skor >=2.0 && Skor<3.0){
            holderData.Star1.setImageResource(R.drawable.star);
            holderData.Star2.setImageResource(R.drawable.star);
            holderData.Star3.setImageResource(R.drawable.kosong_star);
            holderData.Star4.setImageResource(R.drawable.kosong_star);
            holderData.Star5.setImageResource(R.drawable.kosong_star);
        }else if(Skor >=3.0 && Skor<4.0){
            holderData.Star1.setImageResource(R.drawable.star);
            holderData.Star2.setImageResource(R.drawable.star);
            holderData.Star3.setImageResource(R.drawable.star);
            holderData.Star4.setImageResource(R.drawable.kosong_star);
            holderData.Star5.setImageResource(R.drawable.kosong_star);
        }else if(Skor >=4.0 && Skor<5.0){
            holderData.Star1.setImageResource(R.drawable.star);
            holderData.Star2.setImageResource(R.drawable.star);
            holderData.Star3.setImageResource(R.drawable.star);
            holderData.Star4.setImageResource(R.drawable.star);
            holderData.Star5.setImageResource(R.drawable.kosong_star);
        }else{
            holderData.Star1.setImageResource(R.drawable.star);
            holderData.Star2.setImageResource(R.drawable.star);
            holderData.Star3.setImageResource(R.drawable.star);
            holderData.Star4.setImageResource(R.drawable.star);
            holderData.Star5.setImageResource(R.drawable.star);
        }
        holderData.NStar.setText(dm.getSkor());
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, DeskripsiGame.class);
                i.putExtra("NAMA", dm.getNama_game());
                i.putExtra("DESKRIPSI",dm.getDeskripsi_game());
                i.putExtra("PLATFORM",dm.getPlatform_game());
                i.putExtra("GAMBAR",destiny.BASE_URL()+dm.getGambar_game());
                i.putExtra("YOUTUBE",dm.getTrailer_game());
                i.putExtra("WEBSITE",dm.getWebsite_game());
                i.putExtra("GENRE",dm.getGenre_game());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Nama,Platform,Deskripsi;
        ImageView Star1,Star2,Star3,Star4,Star5;
        TextView NStar;
        LinearLayout card;
        public HolderData(View v){
            super(v);
            Image = v.findViewById(R.id.ivGambar);
            Nama = v.findViewById(R.id.tvNamaGame);
            Platform = v.findViewById(R.id.tvPlatform);
            Deskripsi = v.findViewById(R.id.tvDeskripsi);
            Star1 = v.findViewById(R.id.ivStar1);
            Star2 = v.findViewById(R.id.ivStar2);
            Star3 = v.findViewById(R.id.ivStar3);
            Star4 = v.findViewById(R.id.ivStar4);
            Star5 = v.findViewById(R.id.ivStar5);
            NStar = v.findViewById(R.id.tvStar);
            card = v.findViewById(R.id.card_view);
        }
    }
}
