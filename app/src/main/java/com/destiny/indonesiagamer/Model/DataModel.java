package com.destiny.indonesiagamer.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    //User
    @SerializedName("id_user")
    @Expose
    public String id_user;

    @SerializedName("level_user")
    @Expose
    public String level_user;

    @SerializedName("nama_user")
    @Expose
    public String nama_user;

    @SerializedName("username")
    @Expose
    public String username;

    @SerializedName("password")
    @Expose
    public String password;

    @SerializedName("jk_user")
    @Expose
    public String jk_user;

    @SerializedName("id_rekening")
    @Expose
    public String id_rekening;

    @SerializedName("photo_user")
    @Expose
    public String photo_user;

    @SerializedName("status_user")
    @Expose
    public String status_user;

    @SerializedName("rating_user")
    @Expose
    public String rating_user;

    //Game
    @SerializedName("id_game")
    @Expose
    public String id_game;

    @SerializedName("nama_game")
    @Expose
    public String nama_game;

    @SerializedName("deskripsi_game")
    @Expose
    public String deskripsi_game;

    @SerializedName("platform_game")
    @Expose
    public String platform_game;

    @SerializedName("genre_game")
    @Expose
    public String genre_game;

    @SerializedName("gambar_game")
    @Expose
    public String gambar_game;

    @SerializedName("trailer_game")
    @Expose
    public String trailer_game;

    @SerializedName("website_game")
    @Expose
    public String website_game;

    @SerializedName("skor")
    @Expose
    public String skor;


    //Getter Setter
    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getLevel_user() {
        return level_user;
    }

    public void setLevel_user(String level_user) {
        this.level_user = level_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJk_user() {
        return jk_user;
    }

    public void setJk_user(String jk_user) {
        this.jk_user = jk_user;
    }

    public String getId_rekening() {
        return id_rekening;
    }

    public void setId_rekening(String id_rekening) {
        this.id_rekening = id_rekening;
    }

    public String getPhoto_user() {
        return photo_user;
    }

    public void setPhoto_user(String photo_user) {
        this.photo_user = photo_user;
    }

    public String getStatus_user() {
        return status_user;
    }

    public void setStatus_user(String status_user) {
        this.status_user = status_user;
    }

    public String getRating_user() {
        return rating_user;
    }

    public void setRating_user(String rating_user) {
        this.rating_user = rating_user;
    }

    public String getId_game() {
        return id_game;
    }

    public void setId_game(String id_game) {
        this.id_game = id_game;
    }

    public String getNama_game() {
        return nama_game;
    }

    public void setNama_game(String nama_game) {
        this.nama_game = nama_game;
    }

    public String getDeskripsi_game() {
        return deskripsi_game;
    }

    public void setDeskripsi_game(String deskripsi_game) {
        this.deskripsi_game = deskripsi_game;
    }

    public String getPlatform_game() {
        return platform_game;
    }

    public void setPlatform_game(String platform_game) {
        this.platform_game = platform_game;
    }

    public String getGenre_game() {
        return genre_game;
    }

    public void setGenre_game(String genre_game) {
        this.genre_game = genre_game;
    }

    public String getGambar_game() {
        return gambar_game;
    }

    public void setGambar_game(String gambar_game) {
        this.gambar_game = gambar_game;
    }

    public String getTrailer_game() {
        return trailer_game;
    }

    public void setTrailer_game(String trailer_game) {
        this.trailer_game = trailer_game;
    }

    public String getWebsite_game() {
        return website_game;
    }

    public void setWebsite_game(String website_game) {
        this.website_game = website_game;
    }

    public String getSkor() {
        return skor;
    }

    public void setSkor(String skor) {
        this.skor = skor;
    }
}
