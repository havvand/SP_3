import java.util.ArrayList;
import java.util.Objects;

import com.sun.deploy.util.StringUtils;

public class MediaData extends MainMenu {
    FileIO f = new FileIO();

    TextUI t = new TextUI();
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();
    private ArrayList<Series> watchedSeries = new ArrayList<>();
    private ArrayList<Movies>watchedMovies = new ArrayList<>();
    private ArrayList<String> favoriteMovies = new ArrayList<>();
    private ArrayList<String> favoriteSeries = new ArrayList<>();

    public void initiateMovieList() {
        createMovies(f.readMovieData());
    }

    public void initiateSeriesList() {
        createSeries(f.readSeriesData());


    }

    public void playButtonForMovie() {
        initiateMovieList();
        String i = u.getUserInputForSearch("Which of the following movies would you like to watch");
        for (Movies m : movies){
            if (m.getTitle().equalsIgnoreCase(i)){
                watchedMovies.add(m);
                u.displayMessage("You are now watching: " + m);
                chooseMediaType();
            }
        }
    }

    public void playButtonForSeries() {
        initiateSeriesList();
        String i = u.getUserInputForSearch("Which of the following series would like to watch?");
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(i)) {
                watchedSeries.add(s);
                u.displayMessage("You are now watching: " + s);
                chooseMediaType();
            }
        }
    }


    public ArrayList<Movies> searchInMovieCategory() {
        initiateMovieList();
        ArrayList<Movies> movieCategories = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a category");
        for (Movies m : movies) {
            if (m.getGenre().contains(i)) {
                movieCategories.add(m);
            }
        }
        System.out.println(movieCategories);
        return movieCategories;
    }

    public ArrayList<Series> searchInSeriesCategory() {
        ArrayList<Series> seriesCategories = new ArrayList<>();
        initiateSeriesList();
        String i = u.getUserInputForSearch("Search for a category");
        for (Series s : series) {
            if (s.getGenre().contains(i)) {
                seriesCategories.add(s);
            }
        }
        System.out.println(seriesCategories);
        return seriesCategories;
    }

    public ArrayList<Movies> searchForMovieTitle() {
        initiateMovieList();
        ArrayList<Movies> searchedMovies = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a movie");
        for (Movies m : movies) {
            if (m.getTitle().contains(i)) {
                searchedMovies.add(m);
            }
        }
        System.out.println(searchedMovies);
        return searchedMovies;
    }

    public ArrayList<Series> searchForSeriesTitle() {
        initiateSeriesList();
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a series");
        for (Series s : series) {
            // if (StringUtils.co containsIgnoreCase(s.getTitle(), i){

            //}
            if (s.getTitle().contains(i)) {
                searchedSeries.add(s);
            }
        }
        System.out.println(searchedSeries);
        return searchedSeries;
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
            String rating = values[3];
            Movies m = new Movies(title, releaseYear, genre, rating);
            movies.add(m);
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
    public void displayWatchedSeries(){
        System.out.println(watchedSeries);
    }
    public void displayWatchedMovies(){
        System.out.println(watchedMovies);
    }
}
