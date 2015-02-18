package com.asignes.sizes.domain;

import com.asignes.sizes.model.entities.PopularMoviesResponse;
import com.asignes.sizes.model.entities.PopularShowsResponse;

public interface GetPopularMediaUsecase extends Usecase {
  public static final int TV_SHOWS = 0;
  public static final int TV_MOVIES = 1;

  public void getPopularShows();

  public void getPopularMovies();

  public void onPopularShowsReceived(PopularShowsResponse response);

  public void onPopularMoviesReceived(PopularMoviesResponse response);

  public void sendShowsToPresenter();
}
