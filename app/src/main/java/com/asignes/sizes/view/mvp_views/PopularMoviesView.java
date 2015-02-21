package com.asignes.sizes.view.mvp_views;

import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.view.MovieView;
import java.util.List;

public interface PopularMoviesView extends MovieView {
  void showMovies(List<TvMovie> movieList);

  void showLoading();

  void hideLoading();

  void showError(String error);

  void hideError();
}
