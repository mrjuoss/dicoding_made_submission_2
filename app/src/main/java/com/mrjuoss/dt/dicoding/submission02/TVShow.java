package com.mrjuoss.dt.dicoding.submission02;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private int poster_tv_show;
    private String title_tv_show;
    private String release_tv_show;
    private String duration_tv_show;
    private String genre_tv_show;
    private String user_score_tv_show;
    private String overview_tv_show;

    public int getPoster_tv_show() {
        return poster_tv_show;
    }

    public void setPoster_tv_show(int poster_tv_show) {
        this.poster_tv_show = poster_tv_show;
    }

    public String getTitle_tv_show() {
        return title_tv_show;
    }

    public void setTitle_tv_show(String title_tv_show) {
        this.title_tv_show = title_tv_show;
    }

    public String getRelease_tv_show() {
        return release_tv_show;
    }

    public void setRelease_tv_show(String release_tv_show) {
        this.release_tv_show = release_tv_show;
    }

    public String getDuration_tv_show() {
        return duration_tv_show;
    }

    public void setDuration_tv_show(String duration_tv_show) {
        this.duration_tv_show = duration_tv_show;
    }

    public String getGenre_tv_show() {
        return genre_tv_show;
    }

    public void setGenre_tv_show(String genre_tv_show) {
        this.genre_tv_show = genre_tv_show;
    }

    public String getUser_score_tv_show() {
        return user_score_tv_show;
    }

    public void setUser_score_tv_show(String user_score_tv_show) {
        this.user_score_tv_show = user_score_tv_show;
    }

    public String getOverview_tv_show() {
        return overview_tv_show;
    }

    public void setOverview_tv_show(String overview_tv_show) {
        this.overview_tv_show = overview_tv_show;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster_tv_show);
        dest.writeString(this.title_tv_show);
        dest.writeString(this.release_tv_show);
        dest.writeString(this.duration_tv_show);
        dest.writeString(this.genre_tv_show);
        dest.writeString(this.user_score_tv_show);
        dest.writeString(this.overview_tv_show);
    }

    public TVShow() {
    }

    protected TVShow(Parcel in) {
        this.poster_tv_show = in.readInt();
        this.title_tv_show = in.readString();
        this.release_tv_show = in.readString();
        this.duration_tv_show = in.readString();
        this.genre_tv_show = in.readString();
        this.user_score_tv_show = in.readString();
        this.overview_tv_show = in.readString();
    }

    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
