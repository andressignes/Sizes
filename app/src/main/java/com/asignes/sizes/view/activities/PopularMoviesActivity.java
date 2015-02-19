package com.asignes.sizes.view.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.asignes.sizes.R;
import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.view.mvp_views.PopularMoviesView;
import com.asignes.sizes.view.presenter.PopularMediaPresenter;
import com.asignes.sizes.view.presenter.PopularShowsPresenterImpl;
import java.util.List;

public class PopularMoviesActivity extends Activity implements PopularMoviesView {
  private final static int COLUMNS = 2;
  PopularMediaPresenter popularMediaPresenter;

  @InjectView(R.id.recycler_popular_movies) RecyclerView popularMoviesRecycler;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    popularMoviesRecycler.setLayoutManager(new GridLayoutManager(this, COLUMNS));
    popularMoviesRecycler.setAdapter(new MovieAdapter(null));

    popularMediaPresenter = new PopularShowsPresenterImpl(this);
  }

  @Override protected void onResume() {
    super.onResume();
    popularMediaPresenter.onResume();
  }

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public void showMovies(List<TvMovie> movieList) {

  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showError(String error) {

  }

  @Override
  public void hideError() {

  }
}
