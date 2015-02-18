package com.asignes.sizes.model;

import com.asignes.sizes.model.entities.PopularMoviesResponse;
import com.asignes.sizes.model.entities.PopularShowsResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface TheMovieDBApi {

  @GET("/tv/popular") void getPopularShows(@Query("api_key") String apiKey,
      Callback<PopularShowsResponse> callback);

  @GET("/movie/popular") void getPopularMovies(@Query("api_key") String apiKey,
      Callback<PopularMoviesResponse> callback);
}

