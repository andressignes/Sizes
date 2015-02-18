package com.asignes.sizes.domain;

import com.asignes.sizes.model.MediaDataSource;
import com.asignes.sizes.model.client.RestMovieSource;
import com.asignes.sizes.model.entities.PopularMoviesResponse;
import com.asignes.sizes.model.entities.PopularShowsResponse;
import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.model.entities.TvShow;
import com.asignes.sizes.utils.BusProvider;
import com.asignes.sizes.view.presenter.PopularMediaPresenter;
import com.squareup.otto.Subscribe;
import java.util.List;

public class GetMoviesUsecaseController implements GetPopularMediaUsecase {

  private final PopularMediaPresenter popularMediaPresenter;
  private final MediaDataSource dataSource;
  private final int mode;

  private List<TvShow> popularShows;
  private List<TvMovie> popularMovies;

  public GetMoviesUsecaseController(PopularMediaPresenter popularMediaPresenter, int mode) {

    this.popularMediaPresenter = popularMediaPresenter;
    this.dataSource = RestMovieSource.getInstance();

    this.mode = mode;

    BusProvider.getBusInstance().register(this);
  }

  @Override
  public void getPopularShows() {

    dataSource.getShows();
  }

  @Override
  public void getPopularMovies() {

    dataSource.getMovies();
  }

  @Subscribe @Override
  public void onPopularShowsReceived(PopularShowsResponse response) {

    this.popularShows = response.getResults();
  }

  @Subscribe @Override
  public void onPopularMoviesReceived(PopularMoviesResponse response) {

    this.popularMovies = response.getResults();
    sendShowsToPresenter();
  }

  @Override
  public void sendShowsToPresenter() {

    switch (mode) {

      case GetPopularMediaUsecase.TV_MOVIES:
        popularMediaPresenter.onPopularMoviesReceived(popularMovies);
        break;

      case GetPopularMediaUsecase.TV_SHOWS:
        popularMediaPresenter.onPopularShowsReceived(popularShows);
        break;
    }

    BusProvider.getBusInstance().unregister(this);
  }

  @Override
  public void execute() {

    switch (mode) {

      case GetPopularMediaUsecase.TV_MOVIES:
        getPopularMovies();
        break;

      case GetPopularMediaUsecase.TV_SHOWS:
        popularMediaPresenter.onPopularShowsReceived(popularShows);
        getPopularShows();
        break;
    }
  }
}