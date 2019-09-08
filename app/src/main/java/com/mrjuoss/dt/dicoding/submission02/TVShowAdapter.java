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

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {
    private Context context;
    private ArrayList<TVShow> tvShows;

    public TVShowAdapter(Context context) {
        this.context = context;
        tvShows = new ArrayList<>();
    }

    public void setTvShows(ArrayList<TVShow> tvShows) {
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view_tv_show, parent, false);
        return new TVShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {

        final TVShow tvShow = tvShows.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPoster_tv_show())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPosterTV);

        holder.textTitleTV.setText(tvShow.getTitle_tv_show());
        holder.textReleaseTV.setText(tvShow.getRelease_tv_show());
        holder.textGenreTV.setText(tvShow.getGenre_tv_show());
        holder.textOverviewTV.setText(tvShow.getOverview_tv_show());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tVShowDetailIntent = new Intent(view.getContext(), TVShowDetailActivity.class);
                tVShowDetailIntent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW, tvShow);
                view.getContext().startActivity(tVShowDetailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class TVShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPosterTV;
        TextView textTitleTV, textReleaseTV, textGenreTV, textOverviewTV;

        public TVShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPosterTV = itemView.findViewById(R.id.image_poster_tv);
            textTitleTV = itemView.findViewById(R.id.text_title_tv);
            textGenreTV = itemView.findViewById(R.id.text_genre_tv);
            textReleaseTV = itemView.findViewById(R.id.text_release_tv);
            textOverviewTV = itemView.findViewById(R.id.text_overview_tv);
        }
    }
}
