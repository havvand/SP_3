import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu extends Login {
    Scanner scanner = new Scanner(System.in);
    MediaData md = new MediaData();

    public static void startMenu(){

    }

    // hent data fra file
    // kald createMovies med data fra filen
    // return array fra create>Movie med alle Movies

    public void watchMedia(Account account, ArrayList<String> movieData, Movies m) {
        ArrayList<String> movieList = new ArrayList<>();
        int input = 0;
        input = Integer.parseInt(u.getUserInput("Press 1 for movies \\n\" + \"Press 2 for series"));
        if (input == 1) {
            input = Integer.parseInt(u.getUserInput("Press 1 to search for a movie \\n\" + \"Press 2 to search for a category" + "\n Press 3 to see a list of all movies"));


            if (input == 1) {
                String movieAnswer = (u.getUserInput("Search for a movie: "));
                for (movieAnswer:
                     md.createMovies(movieData) {
                if (md.createMovies(movieData).equals(movieAnswer);
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



/*
        public void addToFavorites(userAccount a, choice) {
            favoritMovie.add(choice)
        }
    }*/
}


