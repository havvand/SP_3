import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);
    String RESET = "\033[0m";
    String GREEN_BOLD = "\033[1;32m";
    String REDB = "\033[1;31m";
    String YELB = "\033[1;33m";
    String B_U = "\033[4;34m";
//RECEIVES A MESSAGE AND DISPLAYS IT TO THE USER. PROMPTS THE USER FOR ONE INPUT VALUE AND RETURNS THE INPUT

    public String getUserInput(String msg) {
        this.displayMessage(msg);
        String input = scan.nextLine();
        return input;
    }

    public String getUserInputForSearch(String msg) {
        this.displayMessage(msg);
        String input = scan.nextLine();
        String capLetter = String.valueOf(input.toUpperCase().charAt(0)); //T
        input = input.substring(1, input.length());
        return capLetter + input;
    }

    //RECEIVES A MESSAGE AND DISPLAYS IT TO THE USER. PROMPTS THE USER FOR MULTIPLE INPUT VALUES. RETURNS ARRAY OF INPUTS.
    public ArrayList<String> getUserInput(String msg, int iterations) {
        ArrayList<String> values = new ArrayList<>();
        int i = 0;
        String input = "";
        while (i < iterations) {
            displayMessage(msg);
            input = scan.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            values.add(input);
            i++;
        }
        return values;
    }

    //RECEIVES A MESSAGE AND DISPLAYS IT TO THE USER. DISPLAYS AN ARRAY OF OPTIONS.
//PROMPTS THE USER FOR ONE INPUT VALUE. RETURNS THE INPUT.
    public int getUserInput(String msg, ArrayList<String> options) {
        System.out.println(msg);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ". " + options.get(i));
        }
        int choice = scan.nextInt();
        return choice;
    }

    public void displayMessage(String msg) {
        int stringNoSpaces = msg.replace(" ", "").length();
        int stringLength = msg.length() - (msg.length() - stringNoSpaces);
        String dash = "-";
        System.out.println(YELB + repeatString(stringLength, dash) + RESET);
        System.out.println(msg);
        System.out.println(YELB + repeatString(stringLength, dash) + RESET);
    }

    public void errorMessage() {
        MainMenu mm = new MainMenu();
        System.out.println("NOOOO! Gosh darnit.. " + "\n Our library does not have what you're looking for.");
        int input = Integer.parseInt(getUserInput("\n Now you have to choose..." + "\n Press 1 for movies." + "\n Press 2 for series." + "\n Press 3 saved or previously watched media."));
        if (input == 1){
            mm.movieOptions();
        }
        if (input == 2){
            mm.seriesOptions();
        }
        if (input == 3){
            mm.watchStoredMedia();
        }
    }

    // Method to repeate a string. Used to make text-box fit the length of the displayed text.
    public String repeatString(int i, String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++)
            sb.append(s);
        return sb.toString();
    }

    public void displayMovieArrays(ArrayList<Movies> objects) {
        StringBuilder sb = new StringBuilder();
        for (Movies a : objects)
            System.out.println(B_U + a + RESET);
        //return a;
    }

    public void displaySeriesArrays(ArrayList<Series> objects) {
        StringBuilder sb = new StringBuilder();
        for (Series a : objects)
            System.out.println(B_U + a + RESET);
        //return a;
    }

    public void displayWatchedSeriesArrays(ArrayList<Series> objects) {
        StringBuilder sb = new StringBuilder();
        for (Series a : objects)
            System.out.println(B_U + a + RESET);
    }

    public void displayWatchedMoviesArrays(ArrayList<Movies> objects) {
        StringBuilder sb = new StringBuilder();
        for (Movies a : objects)
            System.out.println(B_U + a + RESET);
    }

    public void displayFavMovArray(ArrayList<Movies> objects) {
        StringBuilder sb = new StringBuilder();
        for (Movies a : objects)
            System.out.println(B_U + a + RESET);
    }

    public void displayFavSerArrays(ArrayList<Series> objects) {
        StringBuilder sb = new StringBuilder();
        for (Series a : objects)
            System.out.println(B_U + a + RESET);
    }
}
