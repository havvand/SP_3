public abstract class Media {
    private String ID;

    private String title;

    private String releaseYear;

    private String genre;

    private String rating;

    public Media(String ID, String title, String releaseYear, String genre, String rating) {
        this.ID = ID;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    public String getID() {
        return ID;
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
