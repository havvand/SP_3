public abstract class Media implements MediaType {
    private String title;

    private String releaseYear;

    private String genre;

    private String rating;
    private String ID;

    public Media(String ID, String title, String releaseYear, String genre, String rating) {
        this.ID = ID;
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

    public String getRating() {
        return rating;
    }
    public String getID(){
        return ID;
    }

    @Override
    public String toString() {
        return "\n" + "ID: " + ID + "\nTitle: " + title + "\nRelease Year: " + releaseYear + "\nGenre: " + genre + "\nRating: " + rating +
                "";
    }
}
