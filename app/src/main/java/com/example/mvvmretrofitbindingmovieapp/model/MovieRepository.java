package com.example.mvvmretrofitbindingmovieapp.model;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofitbindingmovieapp.R;
import com.example.mvvmretrofitbindingmovieapp.service.MovieDataService;
import com.example.mvvmretrofitbindingmovieapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieRepository {

    private ArrayList<MovieModel> moviesList = new ArrayList<>();

    private MutableLiveData<List<MovieModel>> moviesMutableLiveData = new MutableLiveData<>();

    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<MovieModel>> getmoviesMutableLiveData() {
        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<Result> call = movieDataService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if (result != null && result.getResults() != null){

                    moviesList = (ArrayList<MovieModel>) result.getResults();

                    moviesMutableLiveData.setValue(moviesList);

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return moviesMutableLiveData;
    }
}
