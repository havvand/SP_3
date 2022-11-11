import java.util.ArrayList;

//import com.sun.deploy.util.StringUtils;

public class MediaData extends MainMenu {
    FileIO f = new FileIO();
    TextUI t = new TextUI();

    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    private ArrayList<Series> watchedSeries = new ArrayList<>();
    private static ArrayList<Movies> watchedMovies = new ArrayList<>();
    private ArrayList<Movies> favoritedMovies = new ArrayList<>();
    private ArrayList<Series> favoritedSeries = new ArrayList<>();


    public void initiateMovieList() {
        createMovies(f.readMovieData());
    }

    public void initateSeriesList() {
        createSeries(f.readSeriesData());
    }

    public void playButtonForMovie() {
        initiateMovieList();
        String i = u.getUserInputForSearch(YELB+"Which of the following movies would you like to watch"+RESET);
        for (Movies m : movies) {
            if (m.getTitle().equalsIgnoreCase(i)) {
                int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 to watch movie. " + "Press 2 to favorited movie" + RESET));
                if (input == 1) {
                    watchedMovies.add(m);
                    u.displayMessage(GREEN_BOLD+"You are now watching: " + m+RESET);
                    chooseMediaType();
                }
                else if (input == 2) {
                    favoritedMovies.add(m);
                    u.displayMessage(GREEN_BOLD+"You have favorited: " + m+RESET);
                    chooseMediaType();
                }
            }
        }
    }

    public void playButtonForSeries() {
        initateSeriesList();
        String i = u.getUserInputForSearch(YELB+"Which of the following series would like to watch?"+RESET);
        for (Series s : series) {
            if (s.getTitle().equalsIgnoreCase(i)) {
                int input = Integer.parseInt(u.getUserInput(YELB+"Press 1 to watch series. " + "Press 2 to favorite series"+RESET));
                if (input == 1) {
                    watchedSeries.add(s);
                    u.displayMessage(GREEN_BOLD+"You are now watching: " + s + RESET);
                    chooseMediaType();
                }
                if (input == 2){
                    favoritedSeries.add(s);
                    u.displayMessage(GREEN_BOLD+"You have favorited: " + s + RESET);
                    chooseMediaType();
                }
            }
        }
    }


    public ArrayList<Movies> searchInMovieCategory() {
        initiateMovieList();
        ArrayList<Movies> movieCategories = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a category"+RESET);
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
        initateSeriesList();
        String i = u.getUserInputForSearch(YELB+"Search for a category"+RESET);
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
        String i = u.getUserInputForSearch(YELB+"Search for a movie"+RESET);
        for (Movies m : movies) {
            if (m.getTitle().contains(i)) {
                searchedMovies.add(m);
                System.out.println(B_U+m+RESET);
            }
        }
        //System.out.println(searchedMovies + "UGLY");
        return searchedMovies;
    }

    public ArrayList<Series> searchForSeriesTitle() {
        initateSeriesList();
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a series"+RESET);
        for (Series s : series) {
            // if (StringUtils.co containsIgnoreCase(s.getTitle(), i){

            //}
            if (s.getTitle().contains(i)) {
                searchedSeries.add(s);
                System.out.println(B_U+s+RESET);
            }
        }
        //System.out.println(searchedSeries);
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
        u.displayMovieArrays(movies);
        //System.out.println(YELB + movies + REDB);
    }

    public void displaySeries() {
        initateSeriesList();
        u.displaySeriesArrays(series);
        //System.out.println(series);
    }
    public void displayWatchedSeries() {
        u.displayWatchedSeriesArrays(watchedSeries);
        //System.out.println(watchedSeries);
    }
    public void displayWatchedMovies() {
        u.displayWatchedMoviesArrays(watchedMovies);
        //System.out.println(watchedMovies);
    }
    public void displayFavoritedMovies() {
        u.displayFavMovArray(favoritedMovies);
        //System.out.println(favoritedMovies);
    }
    public void displayFavoritedSeries() {
        u.displayFavSerArrays(favoritedSeries);
        //System.out.println(favoritedSeries);
    }
}
