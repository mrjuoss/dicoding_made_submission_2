package com.mrjuoss.dt.dicoding.submission02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    ImageView imagePosterMovieDetail;
    TextView textTitleMovieDetail,
             textReleaseMovieDetail,
             textGenreMovieDetail,
             textDurationMovieDetail,
             textOverviewMovieDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Movie Detail");
        }

        imagePosterMovieDetail = findViewById(R.id.image_detail_poster_movie);
        textTitleMovieDetail = findViewById(R.id.text_detail_title_movie);
        textReleaseMovieDetail = findViewById(R.id.text_detail_release_movie);
        textGenreMovieDetail = findViewById(R.id.text_detail_genre_movie);
        textDurationMovieDetail = findViewById(R.id.text_detail_duration_movie);
        textOverviewMovieDetail = findViewById(R.id.text_detail_overview_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        imagePosterMovieDetail.setImageResource(movie.getPoster());
        textTitleMovieDetail.setText(movie.getTitle());
        textReleaseMovieDetail.setText(movie.getRelease());
        textDurationMovieDetail.setText(movie.getDuration());
        textGenreMovieDetail.setText(movie.getGenre());
        textOverviewMovieDetail.setText(movie.getOverview());
    }
}
