public abstract class Media {
    private String title;

    private String releaseYear;

    private String genre;

    private String rating;

    public Media(String title, String releaseYear, String genre, String rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() { return rating; }

    public String getAmountOfEpisodesInSeason() { return ""; }

    @Override
    public String toString() {
        return "\n" + "Title: " + title + "\nRelease Year: " + releaseYear + "\nGenre: " + genre + "\nRating: " + rating +
                "";
    }
}
