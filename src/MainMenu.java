import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu extends Login {
    Scanner scanner = new Scanner(System.in);

    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    public void watchMedia(Account account, ArrayList<String> movieData, Movies m) {
        ArrayList<String> movieList = new ArrayList<>();
        int input = 0;
        input = Integer.parseInt(u.getUserInput("Press 1 for movies \\n\" + \"Press 2 for series"));
        if (input == 1) {
            input = Integer.parseInt(u.getUserInput("Press 1 to search for a movie \\n\" + \"Press 2 to search for a category" + "\n Press 3 to see a list of all movies"));


            if (input == 1) {
                String movieAnswer = (u.getUserInput("Search for a movie: "));
                for (movieAnswer:
                     createMovies(movieData)) {
                    if ( createMovies(movieData).equals(movieAnswer);
                    {
                        movieList.add(f.readMovieData().toString());
                    }
                }

                if (input == 3) {
                    u.displayMessage(f.readMovieData().toString()); // Hvis der kommer en fejl. Er det muligt at den skal convertes fra Arraylist til String. Vi har converetet Arraylist til
                    //System.out.println(f.readMovieData());
                }
            }
            if (input == 2) {
                input = Integer.parseInt(u.getUserInput("Press 1 to search for a movie \\n\" + \"Press 2 to search for a category" + "\n Press 3 to see a list of all movies"));
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

    // hent data fra file
    // kald createMovies med data fra filen
    // return array fra create>Movie med alle Movies
    private static void createMovies(ArrayList<String> movieData) {
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


        /*public void addToWatched


        public void addToFavorites(userAccount a, choice) {
            favoritMovie.add(choice)
        }
    }*/
}


