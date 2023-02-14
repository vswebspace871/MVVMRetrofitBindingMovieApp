package com.example.mvvmretrofitbindingmovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.mvvmretrofitbindingmovieapp.adapter.MovieAdapter;
import com.example.mvvmretrofitbindingmovieapp.databinding.ActivityMainBinding;
import com.example.mvvmretrofitbindingmovieapp.model.MovieModel;
import com.example.mvvmretrofitbindingmovieapp.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MovieModel> moviesList;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainViewModel mainViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setTitle("MOVIE APP");

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        getPopularMovies();

        swipeRefreshLayout = activityMainBinding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.teal_700);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //swipe refresh karne par kya function hoga wo yaha aayega
                getPopularMovies();
            }


        });




    }

    private void getPopularMovies() {
        mainViewModel.getAllMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
               moviesList = (ArrayList<MovieModel>) movieModels;
               showOnRecyclerVIew();

            }
        });


    }

    private void showOnRecyclerVIew() {
        recyclerView = activityMainBinding.recyclerView;

        movieAdapter = new MovieAdapter(this, moviesList);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();

    }
}