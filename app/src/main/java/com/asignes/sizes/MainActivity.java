package com.asignes.sizes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.asignes.sizes.view.mvp_views.PopularMoviesView;
import com.asignes.sizes.view.presenter.PopularMediaPresenter;
import com.asignes.sizes.view.presenter.PopularShowsPresenterImpl;

public class MainActivity extends Activity implements PopularMoviesView {

  PopularMediaPresenter popularMediaPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    popularMediaPresenter = new PopularShowsPresenterImpl(this);
  }

  @Override protected void onResume() {
    super.onResume();
    popularMediaPresenter.onResume();
  }

  @Override public Context getContext() {
    return this;
  }
}
