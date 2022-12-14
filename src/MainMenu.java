public class MainMenu
{
    TextUI u = new TextUI();
    public static int loginChoice = 0;

    // Colors for console-text!
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_U = "\033[4;34m";

    public void loginChoice()
    {
        int input = Integer.parseInt(u.getUserInput("Press 1 for online: | Press 2 for offline:"));

        if (input == 1)
        {
            MediaDB mediaDB = new MediaDB();
            System.out.println(loginChoice);
            mediaDB.establishConnection();
            input = Integer.parseInt(u.getUserInput("Press 1 to create new user:  | Press 2 to login with existing user: "));
            if(input == 1) {
                mediaDB.newUser();
                mediaDB.readUserCredentials();
            }
            if (input == 2) {
                mediaDB.readUserCredentials();
            }
            mediaDB.run();

        }
        if (input == 2)
        {
            AccountDataBase aOne = new AccountDataBase();
            loginChoice = 1;
            System.out.println(loginChoice);
            aOne.userAuthentication();


        }
    }


    public void startMenu() {
        chooseMediaType();
    }

    public void chooseMediaType() {
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
            md.playButtonForSeries(loginChoice);
        }
        if (input == 2) {
            md.searchForSeriesTitle();
            md.playButtonForSeries(loginChoice);
        }
        if (input == 3) {
            md.searchInSeriesCategory();
            md.playButtonForSeries(loginChoice);
        }
    }

    public void movieOptions() {
        MediaData md = new MediaData();
        u.displayMessage(YELB+"You have chosen to watch movies. How do you want to proceed? "+RESET);
        int input = Integer.parseInt(u.getUserInput(GREEN_BOLD+"Press 1 to see a list of movies" + "\n" + "Press 2 to search for a movie" + "\n" + "Press 3 to search for a category."+RESET));
        if (input == 1) {
            md.displayMovies();
            md.playButtonForMovie(loginChoice);
        }
        if (input == 2) {
            md.searchForMovieTitle();
            md.playButtonForMovie(loginChoice);
        }
        if (input == 3) {
            md.searchInMovieCategory();
            md.playButtonForMovie(loginChoice);
        }
    }
}