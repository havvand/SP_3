import java.util.ArrayList;

public class MediaData extends MainMenu {

    TextUI t = new TextUI();
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();



    public void searchInMovieCategory(){
        ArrayList<Movies> movieCategories = new ArrayList<>();
        String i = u.getUserInput("Search for a category");
        for (Movies m:movies){
            if(movies.contains(i)){
                movieCategories.add(m);
            }
        }
    }
    public void searchInSeriesCategory(){
        ArrayList<Series> seriesCategories = new ArrayList<>(;
        String i = u.getUserInput("Search for a category");
        for (Series s:series){
            if(series.contains(i)){
                seriesCategories.add(s);
            }
        }
    }
    public void searchForMovieTitle() {
        ArrayList<Movies> searchedMovies = new ArrayList<>();
        String i = u.getUserInput("Search for a movie");
        for (Movies m:movies) {
            if (movies.contains(i)){
                searchedMovies.add(m);
            }
        }
    }
    public void searchForSeriesTitle() {
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInput("Search for a series");
        for (Series s:series) {
            if (series.contains(i)){
                searchedSeries.add(s);
            }
        }
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
}
