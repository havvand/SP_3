import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);



    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Series> series = new ArrayList<>();

    public MainMenu() {
        public void startMenu (Account account){
            //System.out.println("1. login \n" + "2. Register user");
            displayMessage("Welcome to the jungle! \n" + "Do you want to watch a movie or a series?");
            int choice = scanner.nextInt();

            if (choice == 1) {

                readMovieData();
            } else if (choice == 2) {
                readSeriesData();
            }

        }
    }


    ArrayList<String> watchedMedia = new ArrayList<>();
    ArrayList<String> favoriteMedia = new ArrayList<>();


    public void watchMedia(Account account) {
        textUI u = new textUI();
        FileIO f = new FileIO();
        String choice = u.getUserInput("Press 1 for movies \\n\" + \"Press 2 for series");
        int answer = Integer.parseInt(choice);
        if (answer == 1) {

            u.displayMessage(f.readMovieData().toString()); // Hvis der kommer en fejl. Er det muligt at den skal convertes fra Arraylist til String. Vi har converetet Arraylist til
            //System.out.println(f.readMovieData());
        } else if (answer == 2) {
            System.out.println(f.readSeriesData());
        }
    }


    public void addToWatched


    public void addToFavorites(userAccount a) {
        favoritMovie.add(choice)
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
}


