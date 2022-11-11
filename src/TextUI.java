import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

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
        System.out.println("*****************");
        System.out.println(msg);
        System.out.println("*****************");
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
}
