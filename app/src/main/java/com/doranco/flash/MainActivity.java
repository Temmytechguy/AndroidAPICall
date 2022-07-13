package com.doranco.flash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.doranco.flash.adapters.FilmAdapter;
import com.doranco.flash.api.Api;
import com.doranco.flash.entities.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFilms = findViewById(R.id.recyclerViewFilms);
        recyclerViewFilms.setLayoutManager(new LinearLayoutManager(this));
        getFilms();


    }

    private void getFilms(){

        //initialisation de l'objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api apiFilm = retrofit.create(Api.class);

        //call the api
        Call<List<Film>> call = apiFilm.getListFilms();

        //Traitment de la reponse
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                Log.e("apiCall",response.body().toString());

                if (response.code()==200)
                {
                    configureAdapterRecyclerViewFilm(response.body());
                }
                else{
                    Log.e("apiCall", "Erreur dans l'appel " + response );

                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("apiCall", "Erreur dans l'appel ", t );
            }
        });

    }

    private void configureAdapterRecyclerViewFilm(List<Film> filmList)
    {
        FilmAdapter adapter = new FilmAdapter(this, filmList);

        recyclerViewFilms.setAdapter(adapter);
    }


}