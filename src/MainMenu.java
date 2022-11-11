import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    TextUI u = new TextUI();
    String RESET = "\033[0m"; String GREEN_BOLD = "\033[1;32m"; String REDB = "\033[1;31m"; String YELB = "\033[1;33m"; String B_U = "\033[4;34m";

    public void startMenu() {
        chooseMediaType();
    }

    public void chooseMediaType() {
        MediaData md = new MediaData();
        int input = Integer.parseInt(u.getUserInput(YELB + "Feeling adventurous? \n\nTo watch something new; \n"+GREEN_BOLD+"Press 1. \n" +YELB+ "To watch something saved or favorited; \n"+GREEN_BOLD+"Press 2." + RESET));
        if (input == 1) {
            u.displayMessage(YELB+"You have chosen to watch something new. Choose how you want to proceed: " + RESET);
            watchNewMedia();
        }
        if (input == 2) {
            u.displayMessage(YELB+"You have chosen to watch something stored. Choose how you want to proceed"+RESET);
            watchStoredMedia();
        }
    }

    public void watchNewMedia() {
        MediaData md = new MediaData();
        int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 "+YELB+"for movies. " +GREEN_BOLD+"Press 2 "+YELB+"for series"));
        if (input == 1) {
            movieOptions();
        }
        if (input == 2) {
            seriesOptions();
        }

    }

    public void watchStoredMedia() {
        MediaData md = new MediaData();
        int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 "+YELB+"for watched media. "+GREEN_BOLD+"Press 2 "+YELB+"for favorited media"));
        if (input == 1) {
            md.displayWatchedMovies();
            md.displayWatchedSeries();
            chooseMediaType();
        }
        if (input == 2) {
            md.displayFavoritedMovies();
            md.displayFavoritedSeries();
            chooseMediaType();
        }
    }

    public void seriesOptions() {
        MediaData md = new MediaData();
        u.displayMessage(YELB+"You have chosen to watch series. How do you want to proceed? "+ RESET);
        int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 to see a list of series" + "\n" + "Press 2 to search for a series" + "\n" + "Press 3 to search for a category."+RESET));
        if (input == 1) {
            md.displaySeries();
            md.playButtonForSeries();
        }
        if (input == 2) {
            md.searchForSeriesTitle();
            md.playButtonForSeries();
        }
        if (input == 3) {
            md.searchInSeriesCategory();
            md.playButtonForSeries();
        }
    }

    public void movieOptions() {
        MediaData md = new MediaData();
        u.displayMessage(YELB+"You have chosen to watch movies. How do you want to proceed? "+RESET);
        int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 to see a list of movies" + "\n" + "Press 2 to search for a movie" + "\n" + "Press 3 to search for a category."+RESET));
        if (input == 1) {
            md.displayMovies();
            md.playButtonForMovie();
            //ADD BUTTON TO SELECT A MOVIE AND PLAY IT
        }
        if (input == 2) {
            md.searchForMovieTitle();
            md.playButtonForMovie();
            //ADD BUTTON TO SELECT A MOVIE AND PLAY IT
        }
        if (input == 3) {
            md.searchInMovieCategory();
            md.playButtonForMovie();
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



