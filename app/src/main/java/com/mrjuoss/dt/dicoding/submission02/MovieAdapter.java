package com.mrjuoss.dt.dicoding.submission02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view_movie, parent, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapterViewHolder holder, int position) {
        final Movie movie = movies.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPoster);

        holder.textTitle.setText(movie.getTitle());
        holder.textRelease.setText(movie.getRelease());
        holder.textGenre.setText(movie.getGenre());
        holder.textOverview.setText(movie.getOverview());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent movieDetailIntent = new Intent(view.getContext(), MovieDetailActivity.class);
                movieDetailIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
                view.getContext().startActivity(movieDetailIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView textTitle, textRelease, textGenre, textOverview;

        public MovieAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.image_poster);
            textTitle = itemView.findViewById(R.id.text_title);
            textGenre = itemView.findViewById(R.id.text_genre);
            textRelease = itemView.findViewById(R.id.text_release);
            textOverview = itemView.findViewById(R.id.text_overview);
        }
    }

}
