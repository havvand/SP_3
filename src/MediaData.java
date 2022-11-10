import java.util.ArrayList;
import java.util.Objects;

public class MediaData extends MainMenu {
    FileIO f = new FileIO();

    TextUI t = new TextUI();
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    public  void initiateMovieList(){
        createMovies(f.readMovieData());
    }
    public void initiateSeriesList(){
        createSeries(f.readSeriesData());
    }


    public void searchInMovieCategory() {
        initiateMovieList();
        ArrayList<Movies> movieCategories = new ArrayList<>();
        String i = u.getUserInput("Search for a category");
        for (Movies m : movies) {
            if (m.getGenre().equalsIgnoreCase(i)) {
                movieCategories.add(m);
            }
            System.out.println(movieCategories);
        }
    }

    public void searchInSeriesCategory() {
        initiateSeriesList();
        ArrayList<Series> seriesCategories = new ArrayList<>();
        String i = u.getUserInput("Search for a category");
        for (Series s : series) {
            if (s.getGenre().equalsIgnoreCase(i)) {
                seriesCategories.add(s);
            }
        }
    }

    public void searchForMovieTitle() {
        initiateMovieList();
        ArrayList<Movies> searchedMovies = new ArrayList<>();
        String i = u.getUserInput("Search for a movie");
        for (Movies m:movies) {
            if (m.getTitle().equalsIgnoreCase(i)){
                searchedMovies.add(m);
                u.displayMessage("You have chosen: " + m);
            }
        }
    }

    public void searchForSeriesTitle() {
        initiateSeriesList();
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInput("Search for a series");
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(i)) {
                searchedSeries.add(s);
            }
        }
    }

    private void createSeries(ArrayList<String> seriesData) {
        for (String s : seriesData) {
            String[] values = s.split(";");
            String title = values[0];
            String releaseYear = values[1];
            String genre = values[2];
            String rating = values[3];
            String amountOfEpisodesInSeason = values[4];
            Series s1 = new Series(title, releaseYear, genre, rating, amountOfEpisodesInSeason);
            series.add(s1);
        }
    }

    public void createMovies(ArrayList<String> movieData) {
        for (String s : movieData) {
            String[] values = s.split(";");
            String title = values[0];
            String releaseYear = values[1];
            String genre = values[2];
            String rating =values[3];
            Movies m = new Movies(title, releaseYear, genre, rating);
            movies.add(m);
        }
    }

    public void chooseAction(){
        ArrayList<Media>savedMedia = new ArrayList<>();
        int input = Integer.parseInt(u.getUserInput("To save this film press 1. To favorite it press 2."));
        if (input == 1){

        }

    }
    public void watchSaved() {

    }

    public void watchFavorite() {

    }

    public void displayMovies() {
        initiateMovieList();
        System.out.println(movies);
    }

    public void displaySeries() {
        initiateSeriesList();
        System.out.println(series);
    }
}
