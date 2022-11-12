import java.util.ArrayList;

//import com.sun.deploy.util.StringUtils;

public class MediaData extends MainMenu {
    FileIO f = new FileIO();
    TextUI t = new TextUI();

    private static ArrayList<Media> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    private static ArrayList<Series> watchedSeries = new ArrayList<>();
    private static ArrayList<Media> watchedMovies = new ArrayList<>();
    private static ArrayList<Media> favoritedMovies = new ArrayList<>();
    private static ArrayList<Series> favoritedSeries = new ArrayList<>();


    public void initiateMovieList()
    {
        createMovies(f.readMovieData());
    }

    public void initateSeriesList()
    {
        createSeries(f.readSeriesData());
    }

    public void playButtonForMovie()
    {
        String i = u.getUserInputForSearch(YELB+"Which of the following movies would you like to watch"+RESET);
        for (Media m : movies) {
            if (m.getTitle().equalsIgnoreCase(i))
            {
                int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 to watch movie. " + "Press 2 to favorited movie" + RESET));

                if (input == 1)
                {
                    watchedMovies.add(m);
                    u.displayMessage(GREEN_BOLD+"You are now watching: " + m+RESET);
                    chooseMediaType();
                }
                if (input == 2)
                {
                    favoritedMovies.add(m);
                    u.displayMessage(GREEN_BOLD+"You have favorited: " + m+RESET);
                    chooseMediaType();
                }
            }
        }
    }

    public void playButtonForSeries()
    {
        String i = u.getUserInputForSearch("Which of the following series would like to watch?");
        for (Series s : series)
        {
            if (s.getTitle().equalsIgnoreCase(i))
            {
                int input = Integer.parseInt(u.getUserInput(YELB+"Press 1 to watch series. " + "Press 2 to favorite series"+RESET));
                if (input == 1)
                {
                    watchedSeries.add(s);
                    u.displayMessage(GREEN_BOLD+"You are now watching: " + s + RESET);
                    chooseMediaType();
                }
                if (input == 2)
                {
                    favoritedSeries.add(s);
                    u.displayMessage(GREEN_BOLD+"You have favorited: " + s + RESET);
                    chooseMediaType();
                }
            }
        }
    }


    public void searchInMovieCategory()
    {
        ArrayList<Media> movieCategories = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a category"+RESET);

        for (Media m : movies)
        {
            if (m.getGenre().contains(i))
            {
                movieCategories.add(m);
            }
        }

        if (movieCategories.size() > 0)
        {
            t.displayMovieArrays(movieCategories);
        } else {
            t.errorMessage();
        }
    }

    public void searchInSeriesCategory()
    {
        ArrayList<Series> seriesCategories = new ArrayList<>();
        String i = u.getUserInputForSearch("Search for a category");
        for (Series s : series) {
            if (s.getGenre().contains(i))
            {
                seriesCategories.add(s);
                System.out.println(B_U + s + RESET);
            }
        }
        if (seriesCategories.size() > 0 )
        {
            t.displaySeriesArrays(seriesCategories);
        }
        else
        {
            t.errorMessage();
        }
    }

    public void searchForMovieTitle()
    {
        ArrayList<Media> searchedMovies = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a movie"+RESET);
        for (Media m : movies)
        {
            if (m.getTitle().contains(i))
            {
                searchedMovies.add(m);
            }
        }
        if (searchedMovies.size() > 0)
        {
           t.displayMovieArrays(searchedMovies);
        }
        else
        {
            t.errorMessage();
        }
    }

    public void searchForSeriesTitle()
    {
        ArrayList<Series> searchedSeries = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a series"+RESET);
        for (Series s : series)
        {

            if (s.getTitle().contains(i) && !searchedSeries.contains(s))
            {
                searchedSeries.add(s);
            }
        }
        if (searchedSeries.size() > 0 )
        {
            t.displaySeriesArrays(searchedSeries);
        }
        else
        {
            t.errorMessage();

        }
    }

    private void createSeries(ArrayList<String> seriesData)
    {
        for (String s : seriesData)
        {
            String[] values = s.split(";");
            String title = values[0];
            String releaseYear = values[1];
            String genre = values[2];
            String rating = values[3];
            String amountOfEpisodesInSeason = values[4];
            Media media = new Series(title, releaseYear, genre, rating, amountOfEpisodesInSeason);
            Series s1 = (Series)media;
            series.add(s1);
        }
    }

    public void createMovies(ArrayList<String> movieData)
    {
        for (String s : movieData)
        {
            String[] values = s.split(";");
            String title = values[0];
            String releaseYear = values[1];
            String genre = values[2];
            String rating = values[3];
            Media media = new Movies(title, releaseYear, genre, rating);
            Movies m = (Movies)media;
            movies.add(m);
        }
    }
    public void displayMovies()
    {
        u.displayMovieArrays(movies);
        //System.out.println(YELB + movies + REDB);
    }

    public void displaySeries()
    {
        u.displaySeriesArrays(series);
        //System.out.println(series);
    }
    public void displayWatchedSeries()
    {
        u.displaySeriesArrays(watchedSeries);
        //System.out.println(watchedSeries);
    }
    public void displayWatchedMovies()
    {
        u.displayMovieArrays(watchedMovies);
        //System.out.println(watchedMovies);
    }
    public void displayFavoritedMovies()
    {
        u.displayMovieArrays(favoritedMovies);
        //System.out.println(favoritedMovies);
    }
    public void displayFavoritedSeries()
    {
        u.displaySeriesArrays(favoritedSeries);
        //System.out.println(favoritedSeries);
    }
}