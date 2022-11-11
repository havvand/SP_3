import java.util.ArrayList;

public abstract class Media implements MediaType {
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

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "\n" + title + ", releaseYear =" + releaseYear + ", genre(s) =" + genre + ", rating =" + rating +
                "";
    }
}
