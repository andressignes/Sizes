package com.asignes.sizes.view.presenter;

import com.asignes.sizes.model.entities.TvMovie;
import java.util.List;

public interface PopularMediaPresenter {

  public void onPopularShowsReceived(List<TvMovie> movieList);

  public void onResume();

  void onPopularMoviesReceived(List<TvMovie> popularMovies);
}
