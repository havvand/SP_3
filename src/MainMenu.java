import java.util.ArrayList;
import java.util.Scanner;

    public class Mainmenu extends Login {
        Scanner scanner = new Scanner(System.in);

        public class Mainmenu {

            public void startMenu(Account account){
                //System.out.println("1. login \n" + "2. Register user");
                displayMessage("Welcome to the jungle! \n" + "Press 1 for a list of movies\n" + "Press 2 for a list of series" + "Press 3 to do a search");
                int choice = scanner.nextInt();

                if (choice == 1){

                    readMovieData();
                }
                else if (choice == 2){
                    readSeriesData();
                }
                else if (choice == 3){
                    //Search engine here
            }


            ArrayList<String> watchedMedia = new ArrayList<>();
            ArrayList<String> favoriteMedia = new ArrayList<>();




            public void watchMedia(Account account) {
                textUI u = new textUI();
                FileIO f = new FileIO();
                String choice = u.getUserInput("Press 1 for movies \\n\" + \"Press 2 for series");
                int answer = Integer.parseInt(choice);
                if (answer == 1){

                    u.displayMessage(f.readMovieData().toString()); // Hvis der kommer en fejl. Er det muligt at den skal convertes fra Arraylist til String. Vi har converetet Arraylist til
                    //System.out.println(f.readMovieData());
                }
                else if (answer == 2){
                    System.out.println(f.readSeriesData());
                }
            }


            public void addToWatched


            public void addToFavorites(userAccount a, choice) {
                favoritMovie.add(choice)
            }
        }
    }
}
