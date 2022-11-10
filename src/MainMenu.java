import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu extends Login {
    Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        //watchMedia();
        MediaData md = new MediaData();
        //u.displayMessage("Welcome to the main menu. Here's a list of options: ");
        // md.searchForMovieTitle();
        //md.searchForSeriesTitle();
        md.searchInMovieCategory();
        // md.searchInSeriesCategory();
    }

    public void watchMedia(Account account) { // There is going to be an account sent in to this fuction
        MediaData md = new MediaData();
        int input = Integer.parseInt(u.getUserInput("/n Feeling adventurous? To watch something new, press 1" + "\n To watch something saved or favorited press 2"));
        if (input == 1) {
          moviesMenu();
        }
        if (input == 2) {
            input = Integer.parseInt(u.getUserInput("\n Nice! Now choose from previous watched movies/series, press 1." + "\n To watch from your favouritelist, press 2."));
        }
    }


    private void moviesMenu() {
        MediaData md = new MediaData();
        u.displayMessage("You have chosen to watch something new. Choose how you want to proceed: ");
        int input = Integer.parseInt(u.getUserInput("\n Press 1 for movies. " + "Press 2 for series"));
        if (input == 1) {
            u.displayMessage("You have chosen to watch movies. How do you want to proceed? ");
            input = Integer.parseInt(u.getUserInput("Press 1 to see a list of movies \n Press 2 to search for a movie \n Press 3 to search for a category."));
            if (input == 1) {
                md.displayMovies();
                //NEED TO BE ABLE TO PICK A MOVIE FROM ARRAY
            }
            if (input == 2) {
                md.searchForMovieTitle();
            }
            if (input == 3) {
                md.searchInMovieCategory();
            }
            if (input == 1) {
                md.displaySeries();
            }
            if (input == 2) {
                md.searchForSeriesTitle();
            }
            if (input == 3) {
                md.searchInSeriesCategory();
            }
            if (input == 2) {
                u.displayMessage("You have chosen to watch something saved or favorited. How do you want to proceed? ");
                input = Integer.parseInt(u.getUserInput("To watch something saved press 1 \n To watch something favorited press 2"));
                if (input == 1) {
                    md.watchSaved();
                }
                if (input == 2) {
                    md.watchFavorite();

                }
            }

        }
        if (input == 2){
            seriesMenu();
        }
    }
    private void seriesMenu(){
        MediaData md = new MediaData();

        u.displayMessage("You have chosen to watch series. How do you want to proceed? ");
      int  input = Integer.parseInt(u.getUserInput("Press 1 to see a list of series \n Press 2 to search for a series \n Press 3 to search for a category."));
    }
}







