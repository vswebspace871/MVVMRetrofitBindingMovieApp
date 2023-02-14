package com.example.mvvmretrofitbindingmovieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmretrofitbindingmovieapp.model.MovieModel;
import com.example.mvvmretrofitbindingmovieapp.model.MovieRepository;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
    }

    //LiveData
    public LiveData<List<MovieModel>> getAllMovies(){
         return movieRepository.getmoviesMutableLiveData();
    }
}
