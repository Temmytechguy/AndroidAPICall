package com.doranco.flash.api;

import com.doranco.flash.entities.Film;

import java.util.List;

import  retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("v3/55eaaf8b-cc51-4506-b576-d2fa974dde44")
    Call<List<Film>> getListFilms();
}
