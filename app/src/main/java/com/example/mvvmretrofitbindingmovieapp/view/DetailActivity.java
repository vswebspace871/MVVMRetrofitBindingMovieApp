package com.example.mvvmretrofitbindingmovieapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.mvvmretrofitbindingmovieapp.R;
import com.example.mvvmretrofitbindingmovieapp.model.MovieModel;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    private MovieModel movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Parcelable parcelable = getIntent().getParcelableExtra("movie");

        movieModel = Parcels.unwrap(parcelable);

        Log.e("TAG", "onCreate: TITLE: "+movieModel.title);


//        Intent i = getIntent();

        /*if (i.hasExtra("movie")) {

            movieModel = getIntent().getParcelableExtra("movie");
//            activityMovieDetailBinding.setMovie(movieModel);
            Log.d("TAG", "onCreate: TITLE: "+movieModel.title);
            //getSupportActionBar().setTitle(movieModel.getTitle());

        }*/
    }
}