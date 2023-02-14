package com.example.mvvmretrofitbindingmovieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.mvvmretrofitbindingmovieapp.R;
import com.example.mvvmretrofitbindingmovieapp.databinding.ActivityMovieDetailBinding;
import com.example.mvvmretrofitbindingmovieapp.model.MovieModel;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    private MovieModel movieModel;
    private ActivityMovieDetailBinding activityMovieDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityMovieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);

        Intent i = getIntent();

        if (i.hasExtra("movie")) {
            Parcelable parcelable = getIntent().getParcelableExtra("movie");
            movieModel = Parcels.unwrap(parcelable);
//            movieModel = getIntent().getParcelableExtra("movie");
            activityMovieDetailBinding.setMovie(movieModel);
//            Log.d("TAG", "onCreate: TITLE: "+movieModel.title);
            //getSupportActionBar().setTitle(movieModel.getTitle());

        }

    }
}