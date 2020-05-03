
package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

public class show implements Parcelable {
    String name,genre,description,rating;
    String time,date;
    int img;

    public show(String name, String genre, String description, String rating, String time, String date, int img) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.time = time;
        this.date = date;
        this.img = img;
    }

    protected show(Parcel in) {
        name = in.readString();
        genre = in.readString();
        description = in.readString();
        rating = in.readString();
        time = in.readString();
        date = in.readString();
        img = in.readInt();
    }

    public static final Creator<show> CREATOR = new Creator<show>() {
        @Override
        public show createFromParcel(Parcel in) {
            return new show(in);
        }

        @Override
        public show[] newArray(int size) {
            return new show[size];
        }
    };

    public static Creator<show> getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(genre);
        dest.writeString(description);
        dest.writeString(rating);
        dest.writeString(time);
        dest.writeString(date);
        dest.writeInt(img);
    }
}
