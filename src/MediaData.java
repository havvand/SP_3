import java.util.ArrayList;
public class MediaData extends MainMenu {
    FileIO f = new FileIO();

    TextUI t = new TextUI();
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();
    private static ArrayList<Series> watchedSeries = new ArrayList<>();
    private static ArrayList<Movies> watchedMovies = new ArrayList<>();
    private static ArrayList<Movies> favoritedMovies = new ArrayList<>();

    private static ArrayList<Series> favoritedSeries = new ArrayList<>();


    public void initiateMovieList() {
        createMovies(f.readMovieData());
    }

    public void initateSeriesList() {
        createSeries(f.readSeriesData());
    }

    public void playButtonForMovie() {
        String i = u.getUserInputForSearch("Which of the following movies would you like to watch");
        for (Movies m : movies) {
            if (m.getTitle().equalsIgnoreCase(i)) {
                int input = Integer.parseInt(u.getUserInput("Press 1 to watch movie. " + "Press 2 to favorited movie"));
                if (input == 1) {
                    watchedMovies.add(m);
                    u.displayMessage("You are now watching: " + m);
                    chooseMediaType();
                }
                if (input == 2) {
                    favoritedMovies.add(m);
                    u.displayMessage("You have favorited: " + m);
                    chooseMediaType();
                }
            }
        }
    }

    public void playButtonForSeries() {
        String i = u.getUserInputForSearch("Which of the following series would like to watch?");
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(i)) {
                int input = Integer.parseInt(u.getUserInput("Press 1 to watch series. " + "Press 2 to favorite series"));
                if (input == 1) {
                    watchedSeries.add(s);
                    u.displayMessage("You are now watching: " + s);
                    chooseMediaType();
                }
                if (input == 2){
                    favoritedSeries.add(s);
                    u.displayMessage("You have favorited: " + s);
                    chooseMediaType();
                }
            }
        }
    }


    public ArrayList<Movies> searchInMovieCategory() {
        ArrayList<Movies> movieCategories = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a category");
        for (Movies m : movies) {
            if (m.getGenre().contains(i)) {
                movieCategories.add(m);
            }
        }
        if (movieCategories.size() > 0) {
            System.out.println(movieCategories);
            return movieCategories;
        } else {
            t.errorMessage();
        }
        return movieCategories;
    }

    public ArrayList<Series> searchInSeriesCategory() {
        ArrayList<Series> seriesCategories = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a category");
        for (Series s : series) {
            if (s.getGenre().contains(i)) {
                seriesCategories.add(s);
            }
        }
        if (seriesCategories.size() > 0 ){
            System.out.println(seriesCategories);
            return seriesCategories;
        }
        else {
            t.errorMessage();
        }
        return null;
    }

    public ArrayList<Movies> searchForMovieTitle() {
        ArrayList<Movies> searchedMovies = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a movie");
        for (Movies m : movies) {
            if (m.getTitle().contains(i)) {
                searchedMovies.add(m);
            }
        }
        if (searchedMovies.size() > 0){
            System.out.println(searchedMovies);
            return searchedMovies;
        }
        else {
            t.errorMessage();
        }
        return null;
    }

    public ArrayList<Series> searchForSeriesTitle() {
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a series");
        for (Series s : series) {

            if (s.getTitle().contains(i) && !searchedSeries.contains(s)){
                searchedSeries.add(s);
            }
        }
        if (searchedSeries.size() > 0 ){
            System.out.println(searchedSeries);
            return searchedSeries;
        }
        else {
            t.errorMessage();

        }
        return null;
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
    public void displayMovies() {
        u.displayMessage(movies.toString());
    }

    public void displaySeries() {
        u.displayMessage(series.toString());
    }
    public void displayWatchedSeries() {
        u.displayMessage(watchedSeries.toString());

    }
    public void displayWatchedMovies() {
        u.displayMessage(watchedMovies.toString());
    }
    public void displayFavoritedMovies() {
        u.displayMessage(favoritedMovies.toString());
    }
    public void displayFavoritedSeries() {
        u.displayMessage(favoritedSeries.toString());

    }
}
