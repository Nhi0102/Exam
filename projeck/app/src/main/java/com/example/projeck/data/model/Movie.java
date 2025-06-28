package com.example.projeck.data.model;


import java.util.List;

public class Movie {
    private String movieId;
    private String title;
    private String description;
    private String genre;
    private String posterUrl;
    private String status;  // Bạn có trường này nữa!
    private List<Showtime> showtimes; // QUAN TRỌNG: dùng Showtime thay vì Map

    public Movie() {} // Constructor rỗng bắt buộc cho Firebase

    // Getters & Setters

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Showtime> getShowtimes() { return showtimes; }
    public void setShowtimes(List<Showtime> showtimes) { this.showtimes = showtimes; }
}

