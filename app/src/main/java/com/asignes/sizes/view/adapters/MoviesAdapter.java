package com.asignes.sizes.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.asignes.sizes.R;
import com.asignes.sizes.model.entities.TvMovie;
import com.asignes.sizes.view.HackVGClickListener;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

  //    private final List<TvMovie> movieList;
  public HackVGClickListener hackVGClickListener;
  private Context context;

  public MoviesAdapter(List<TvMovie> movieList) {

    //        this.movieList = movieList;
  }

  public void sethackVGClickListener(HackVGClickListener hackVGClickListener) {
    this.hackVGClickListener = hackVGClickListener;
  }

  @Override
  public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

    View rowView =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);

    this.context = viewGroup.getContext();

    return new MovieViewHolder(rowView, hackVGClickListener);
  }

  @Override
  public void onBindViewHolder(MovieViewHolder holder, int position) {

    holder.titleTextView.setText("Movie " + position);
  }

  @Override
  public int getItemCount() {

    return 20;
  }
}

class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  private final HackVGClickListener onClick;
  TextView titleTextView;
  TextView authorTextView;
  ImageView coverImageView;

  public MovieViewHolder(View itemView, HackVGClickListener clickListener) {

    super(itemView);

    titleTextView = (TextView) itemView.findViewById(R.id.item_movie_title);
    coverImageView = (ImageView) itemView.findViewById(R.id.item_movie_cover);
    //        coverImageView.setOnClickListener(this);

    this.onClick = clickListener;
  }

  @Override
  public void onClick(View v) {

    onClick.onClick(v, getPosition());
  }
}
