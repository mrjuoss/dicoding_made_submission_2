package com.mrjuoss.dt.dicoding.submission02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TVShowDetailActivity extends AppCompatActivity {

    public final static String EXTRA_TV_SHOW = "extra_tv_show";

    ImageView imagePosterTVDetail;
    TextView textTitleTVDetail,
            textReleaseTVDetail,
            textGenreTVDetail,
            textDurationTVDetail,
            textOverviewTVDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("TV Show Detail");
        }

        imagePosterTVDetail = findViewById(R.id.image_detail_poster_tv);
        textTitleTVDetail = findViewById(R.id.text_detail_title_tv);
        textReleaseTVDetail = findViewById(R.id.text_detail_release_tv);
        textGenreTVDetail = findViewById(R.id.text_detail_genre_tv);
        textDurationTVDetail = findViewById(R.id.text_detail_duration_tv);
        textOverviewTVDetail = findViewById(R.id.text_detail_overview_tv);

        TVShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);
        imagePosterTVDetail.setImageResource(tvShow.getPoster_tv_show());
        textTitleTVDetail.setText(tvShow.getTitle_tv_show());
        textReleaseTVDetail.setText(tvShow.getRelease_tv_show());
        textDurationTVDetail.setText(tvShow.getDuration_tv_show());
        textGenreTVDetail.setText(tvShow.getGenre_tv_show());
        textOverviewTVDetail.setText(tvShow.getOverview_tv_show());
    }
}
