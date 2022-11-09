import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu extends Login {
    Scanner scanner = new Scanner(System.in);
    private MediaData md = new MediaData();

    public void startMenu() {
        chooseMediaType();
    }

    public void chooseMediaType() {
        int input = Integer.parseInt(u.getUserInput("\n" + "Feeling adventurous? To watch something new, press 1" + "\n To watch something saved or favorited press 2"));
        if (input == 1) {
            u.displayMessage("You have chosen to watch something new. Choose how you want to proceed: ");
            watchNewMedia();
        }
        if (input == 2) {
            u.displayMessage("You have chosen to watch something stored. Choose how you want to proceed");
            watchStoredMedia();
        }
    }

    public void watchNewMedia() {
        int input = Integer.parseInt(u.getUserInput("Press 1 for movies. " + "Press 2 for series"));
        if (input == 1) {
            movieOptions();
        }
        if (input == 2) {
            seriesOptions();
        }

    }

    public void watchStoredMedia() {
    }

    public void seriesOptions() {
        u.displayMessage("You have chosen to watch series. How do you want to proceed? ");
        int input = Integer.parseInt(u.getUserInput("Press 1 to see a list of series" + "\n" + "Press 2 to search for a series" + "\n" + "Press 3 to search for a category."));
        if (input == 1) {
            md.displaySeries();
        }
        if (input == 2) {
            md.searchForSeriesTitle();
        }
        if (input == 3) {
            md.searchInSeriesCategory();
        }
    }

    public void movieOptions() {
        u.displayMessage("You have chosen to watch movies. How do you want to proceed? ");
        int input = Integer.parseInt(u.getUserInput("Press 1 to see a list of movies" + "\n" + "Press 2 to search for a movie" + "\n" + "Press 3 to search for a category."));
        if (input == 1) {
            md.displayMovies();
            //ADD BUTTON TO SELECT A MOVIE AND PLAY IT
        }
        if (input == 2) {
            md.searchForMovieTitle();
            //ADD BUTTON TO SELECT A MOVIE AND PLAY IT
        }
        if (input == 3) {
            md.searchInMovieCategory();
            //ADD BUTTON TO SELECT A MOVIE AND PLAY IT
        }
    }
}

    /*
            input = Integer.parseInt(u.getUserInput("Press 1 for movies. " + "Press 2 for series"));
            if (input == 1) {
                u.displayMessage("You have chosen to watch movies. How do you want to proceed? ");
                input = Integer.parseInt(u.getUserInput("Press 1 to see a list of movies" +"\n" + "Press 2 to search for a movie" + "\n" + "Press 3 to search for a category."));
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
                else if (input == 2) {
                    u.displayMessage("You have chosen to watch series. How do you want to proceed? ");
                    input = Integer.parseInt(u.getUserInput("Press 1 to see a list of series \n Press 2 to search for a series \n Press 3 to search for a category."));
                    if (input == 1) {
                        md.displaySeries();
                    }
                    if (input == 2) {
                        md.searchForSeriesTitle();
                    }
                    if (input == 3) {
                        md.searchInSeriesCategory();
                    } else if (input == 2) {
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
            }
        }
    }
}
     */



