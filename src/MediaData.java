import java.util.ArrayList;

public class MediaData extends MainMenu {

    TextUI t = new TextUI();
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    public void searchForTitle(){

    }

    private static void createSeries(ArrayList<String> seriesData) {
        for (String s : seriesData) {
            String[] values = s.split(";");
            String title = values[0];
            int releaseYear = Integer.parseInt(values[1]);
            String genre = values[2];
            double rating = Double.parseDouble(values[3]);
            int amountOfEpisodesInSeason = Integer.parseInt(values[4]);
            Series s1 = new Series(title, releaseYear, genre, rating, amountOfEpisodesInSeason);
            series.add(s1);
        }
    }
    public static void createMovies(ArrayList<String> movieData) {
        for (String s : movieData) {
            String[] values = s.split(";");
            String title = values[0];
            int releaseYear = Integer.parseInt(values[1]);
            String genre = values[2];
            double rating = Double.parseDouble(values[3]);
            Movies m = new Movies(title, releaseYear, genre, rating);
            movies.add(m);

        }
    }

    public static ArrayList<Movies> getMovies() {
        return movies;
    }


}
