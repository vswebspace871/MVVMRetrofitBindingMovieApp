package com.example.mvvmretrofitbindingmovieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmretrofitbindingmovieapp.R;
import com.example.mvvmretrofitbindingmovieapp.databinding.MovieListItemBinding;
import com.example.mvvmretrofitbindingmovieapp.model.MovieModel;
import com.example.mvvmretrofitbindingmovieapp.view.DetailActivity;
import com.example.mvvmretrofitbindingmovieapp.view.MovieDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<MovieModel> movieArrayList = new ArrayList<>();

    public MovieAdapter(Context context, ArrayList<MovieModel> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item,
                parent,
                false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        MovieModel movieModel = movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movieModel);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding movieListItemBinding;


        public MovieViewHolder(MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();


                    if (position != RecyclerView.NO_POSITION) {

                        MovieModel selectedMovie = movieArrayList.get(position);

                        //create a Parcel
                        Parcelable parcelable = Parcels.wrap(selectedMovie);

                        Intent i = new Intent(context, MovieDetailActivity.class);
                        i.putExtra("movie", parcelable);
                        context.startActivity(i);
                    }
                }
            });
        }

    }
}
