package com.destiny.indonesiagamer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.destiny.indonesiagamer.API.ApiRequest;
import com.destiny.indonesiagamer.API.RetroServer;
import com.destiny.indonesiagamer.Model.ResponseModel;
import com.destiny.indonesiagamer.R;
import com.destiny.indonesiagamer.SharedPreferance.DB_Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText Username,Password;
    LinearLayout Login,Register;
    DB_Helper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DB_Helper(LoginActivity.this);
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.linearLogin);
        Register = findViewById(R.id.linearRegister);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginLogic();
            }
        });
    }
    private void LoginLogic(){
        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("Sedang Mencoba Login");
        pd.show();
        pd.setCancelable(false);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        final Call<ResponseModel> Data =api.login(Username.getText().toString(),Password.getText().toString());
        Data.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pd.hide();
                if (response.body().getData().size()>0){
                    dbHelper.SaveUser(Username.getText().toString(),
                            response.body().getData().get(0).getNama_user(),
                            response.body().getData().get(0).getPhoto_user(),
                            response.body().getData().get(0).getId_user(),
                            response.body().getData().get(0).getId_rekening(),
                            response.body().getData().get(0).getLevel_user());
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }else{
                    Toast.makeText(LoginActivity.this, "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pd.hide();
                Toast.makeText(LoginActivity.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}