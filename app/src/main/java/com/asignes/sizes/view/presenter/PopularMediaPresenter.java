package com.asignes.sizes.view.presenter;

import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.model.entities.TvShow;
import java.util.List;

public interface PopularMediaPresenter {

  public void onPopularShowsReceived(List<TvShow> shows);

  public void onResume ();

  void onPopularMoviesReceived(List<TvMovie> popularMovies);
}
