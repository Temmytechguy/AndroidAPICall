package com.doranco.flash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.doranco.flash.R;
import com.doranco.flash.entities.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmAdapterViewHolder> {

    private Context context;
    private List<Film> filmList;

    /**
     * Construteur de l'adapeur
     * @param context
     * @Param filmlist
     */
    public FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.item_recycler_view_films,parent,false);
        return new FilmAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapterViewHolder holder, int position) {

        Film film = this.filmList.get(position);
        holder.textViewFilmId.setText(String.valueOf(film.getId()));
        holder.textViewFilmTitre.setText(film.getTitre());

        //telechargement et affichage de l'image
        Glide.with(this.context)
                .load(film.getImage())
                .into(holder.imageViewFilmImage);



    }

    @Override
    public int getItemCount() {
        return this.filmList.size();
    }

    /**
     * Cette classe permet de pouvoir identifierr chaque composants
     */
    public static class FilmAdapterViewHolder extends RecyclerView.ViewHolder
    {

        public ImageView imageViewFilmImage;
        public TextView textViewFilmTitre, textViewFilmId;

        public FilmAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewFilmImage = itemView.findViewById(R.id.imageViewFilmImage);
            this.textViewFilmTitre = itemView.findViewById(R.id.textViewFilmTitre);
            this.textViewFilmId = itemView.findViewById(R.id.textViewFilmId);

        }
    }
}
