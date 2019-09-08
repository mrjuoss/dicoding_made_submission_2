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

import static android.os.Looper.prepare;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    private String[] dataTVShow;
    private String[] dataReleaseTVShow;
    private String[] dataDurationTVShow;
    private String[] dataGenreTVShow;
    private String[] dataOverviewTVShow;
    private TypedArray dataPosterTVShow;
    private ArrayList<TVShow> tvShows;

    private RecyclerView rvTVShow;


    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);

        rvTVShow = view.findViewById(R.id.rv_tv_show);

        rvTVShow.setHasFixedSize(true);

        prepareTVShow();
        addItemTVShow();

        showRecyclerTVShow();

        return view;
    }

    private void prepareTVShow() {
        dataTVShow = getResources().getStringArray(R.array.data_tv_show);
        dataReleaseTVShow = getResources().getStringArray(R.array.data_tv_show_release);
        dataDurationTVShow = getResources().getStringArray(R.array.data_tv_show_duration);
        dataGenreTVShow = getResources().getStringArray(R.array.data_tv_show_genre);
        dataOverviewTVShow = getResources().getStringArray(R.array.data_tv_show_overview);
        dataPosterTVShow = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItemTVShow() {
        tvShows = new ArrayList<>();

        for (int i=0; i < dataTVShow.length; i++) {
            TVShow tvShow = new TVShow();

            tvShow.setPoster_tv_show(dataPosterTVShow.getResourceId(i+19, -1));
            tvShow.setTitle_tv_show(dataTVShow[i]);
            tvShow.setRelease_tv_show(dataReleaseTVShow[i]);
            tvShow.setDuration_tv_show(dataDurationTVShow[i]);
            tvShow.setGenre_tv_show(dataGenreTVShow[i]);
            tvShow.setOverview_tv_show(dataOverviewTVShow[i]);

            tvShows.add(tvShow);
        }
    }

    private void showRecyclerTVShow() {
        rvTVShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TVShowAdapter tvShowAdapter = new TVShowAdapter(this.getContext());
        tvShowAdapter.setTvShows(tvShows);
        rvTVShow.setAdapter(tvShowAdapter);
    }

}
