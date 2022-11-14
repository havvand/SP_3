import java.util.ArrayList;

//import com.sun.deploy.util.StringUtils;

public class MediaData extends MainMenu {
    FileIO f = new FileIO();
    TextUI t = new TextUI();

    private static ArrayList<Media> movies = new ArrayList<>();
    private static ArrayList<Media> series = new ArrayList<>();

    private static ArrayList<Media> watchedSeries = new ArrayList<>();
    private static ArrayList<Media> watchedMovies = new ArrayList<>();
    private static ArrayList<Media> favoritedMovies = new ArrayList<>();
    private static ArrayList<Media> favoritedSeries = new ArrayList<>();


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
        String i = u.getUserInputForSearch(YELB+"Which of the following movies would you like to watch - type in full title."+RESET);
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
            } else t.errorMessage();
        }
    }

    public void playButtonForSeries()
    {
        String i = u.getUserInputForSearch(YELB + "Which of the following series would like to watch?" + RESET);
        for (Media s : series)
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
            } else t.errorMessage();
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
            t.printArray(movieCategories);
        } else {
            t.errorMessage();
        }
    }

    public void searchInSeriesCategory()
    {
        ArrayList<Media> seriesCategories = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB + "Search for a category" + RESET);
        for (Media s : series) {
            if (s.getGenre().contains(i))
            {
                seriesCategories.add(s);
                System.out.println(B_U + s + RESET);
            }
        }
        if (seriesCategories.size() > 0 )
        {
            t.printArray(seriesCategories);
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
           t.printArray(searchedMovies);
        }
        else
        {
            t.errorMessage();
        }
    }

    public void searchForSeriesTitle()
    {
        ArrayList<Media> searchedSeries = new ArrayList<>();
        String i = u.getUserInputForSearch(YELB+"Search for a series"+RESET);
        for (Media s : series)
        {

            if (s.getTitle().contains(i) && !searchedSeries.contains(s))
            {
                searchedSeries.add(s);
            }
        }
        if (searchedSeries.size() > 0 )
        {
            t.printArray(searchedSeries);
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
        u.printArray(movies);
        //System.out.println(YELB + movies + REDB);
    }

    public void displaySeries()
    {
        u.printArray(series);
        //System.out.println(series);
    }
    public void displayWatchedSeries()
    {
        u.printArray(watchedSeries);
        //System.out.println(watchedSeries);
    }
    public void displayWatchedMovies()
    {
        u.printArray(watchedMovies);
        //System.out.println(watchedMovies);
    }
    public void displayFavoritedMovies()
    {
        u.printArray(favoritedMovies);
        //System.out.println(favoritedMovies);
    }
    public void displayFavoritedSeries()
    {
        u.printArray(favoritedSeries);
        //System.out.println(favoritedSeries);
    }
}