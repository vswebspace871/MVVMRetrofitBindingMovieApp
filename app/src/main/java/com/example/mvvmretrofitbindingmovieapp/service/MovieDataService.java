package com.example.mvvmretrofitbindingmovieapp.service;

import com.example.mvvmretrofitbindingmovieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    //End Point
    //https://api.themoviedb.org/3/
    // movie/popular?api_key=df3601fe8ba5a0a92c48822e04fe4800&language=en-US&page=1
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);




}
