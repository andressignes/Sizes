package com.asignes.sizes.view.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.asignes.sizes.R;
import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.view.HackVGClickListener;
import com.asignes.sizes.view.adapters.MoviesAdapter;
import com.asignes.sizes.view.mvp_views.PopularMoviesView;
import com.asignes.sizes.view.presenter.PopularMediaPresenter;
import com.asignes.sizes.view.presenter.PopularShowsPresenterImpl;
import java.util.List;

public class PopularMoviesActivity extends Activity
    implements PopularMoviesView, HackVGClickListener {
  private final static int COLUMNS = 2;
  PopularMediaPresenter popularMediaPresenter;

  @InjectView(R.id.recycler_popular_movies) RecyclerView popularMoviesRecycler;
  @InjectView(R.id.activity_main_progress) ProgressBar progress;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    popularMoviesRecycler.setLayoutManager(new GridLayoutManager(this, COLUMNS));
    popularMoviesRecycler.setAdapter(new MoviesAdapter(null));

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
    progress.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    progress.setVisibility(View.GONE);
  }

  @Override
  public void showError(String error) {

  }

  @Override
  public void hideError() {

  }

  @Override public void onClick(View v, int position) {

  }
}
