package com.asignes.sizes.view.presenter;

import android.util.Log;
import com.asignes.sizes.domain.GetMoviesUsecaseController;
import com.asignes.sizes.domain.GetPopularMediaUsecase;
import com.asignes.sizes.domain.Usecase;
import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.view.mvp_views.PopularMoviesView;
import java.util.List;

public class PopularShowsPresenterImpl implements PopularMediaPresenter {

  private final PopularMoviesView popularMoviesView;

  public PopularShowsPresenterImpl(PopularMoviesView popularMoviesView) {

    this.popularMoviesView = popularMoviesView;
  }

  @Override
  public void onResume() {

    Usecase getPopularShows =
        new GetMoviesUsecaseController(this, GetPopularMediaUsecase.TV_MOVIES);

    getPopularShows.execute();
  }

  @Override
  public void onPopularShowsReceived(List<TvMovie> movieList) {
    popularMoviesView.showMovies(movieList);
  }

  @Override
  public void onPopularMoviesReceived(List<TvMovie> popularMovies) {

    Log.d("[DEBUG]",
        "PopularShowsPresenterImpl onPopularMoviesReceived - movies: " + popularMovies);
  }
}
