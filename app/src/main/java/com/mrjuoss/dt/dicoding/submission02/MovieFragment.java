package com.mrjuoss.dt.dicoding.submission02;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;

    private String[] dataMovie;
    private String[] dataRelease;
    private String[] dataDuration;
    private String[] dataGenre;
    private String[] dataOverview;
    private TypedArray dataPoster;
    private ArrayList<Movie> movies;

    private void prepare() {
        dataMovie = getResources().getStringArray(R.array.data_movie);
        dataRelease = getResources().getStringArray(R.array.data_movie_release);
        dataDuration = getResources().getStringArray(R.array.data_movie_duration);
        dataGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataOverview = getResources().getStringArray(R.array.data_movie_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i=0; i < dataMovie.length; i++) {
            Movie movie = new Movie();

            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataMovie[i]);
            movie.setRelease(dataRelease[i]);
            movie.setDuration(dataDuration[i]);
            movie.setGenre(dataGenre[i]);
            movie.setOverview(dataOverview[i]);

            movies.add(movie);
        }
    }

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = rootView.findViewById(R.id.rv_movies);

        rvMovie.setHasFixedSize(true);

        prepare();
        addItem();

        showRecyclerMovie();

        return rootView;
    }

    private void showRecyclerMovie() {
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(this.getContext());
        movieAdapter.setMovies(movies);
        rvMovie.setAdapter(movieAdapter);
    }

}
