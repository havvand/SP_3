import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{

    String R = "\033[0m"; String GB = "\033[1;32m"; String RB = "\033[1;31m"; String YB = "\033[1;33m";

    public ArrayList<String> readMovieData() {
        File movieFile = new File("data/moviedata.csv");
        ArrayList<String> movieData = new ArrayList<>();
        try {
            Scanner input = new Scanner(movieFile);
            while (input.hasNextLine()) {
                movieData.add(input.nextLine());
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("Datafile not found");
            movieData = null;
        }

        return movieData;
    }

    public ArrayList<String> readSeriesData() {
        File seriesFile = new File("Data/seriesdata.csv");
        ArrayList<String> seriesData = new ArrayList<>();
        try {
            Scanner input = new Scanner(seriesFile);

            while (input.hasNextLine()) {
                seriesData.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile not found");
            seriesData = null;
        }
        return seriesData;
    }

    public ArrayList<String> readUserData() {
        File userFile = new File("Data/userdata.txt");
        ArrayList<String> userData = new ArrayList<>();
        try {
            Scanner input = new Scanner(userFile);

            while (input.hasNextLine())
            {
                userData.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile not found");
            userData = null;
        }
        return userData;
    }

    // Adds new users to the userdata text file
    public void writeUserData() {
        TextUI textUI = new TextUI();
        try {
            //Scanner reader = new Scanner("data/userdata.txt");
            FileWriter writer = new FileWriter("data/userdata.txt", true);
            writer.append("");
            writer.write(textUI.getUserInput(YB+"Username") + ", " + textUI.getUserInput(YB+"Password"+R) + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Checks if user exists in the userdata text file.
    public boolean readUserCredentials(String userLogin, String userPassword)
    {
        try
        {
            FileReader userFile = new FileReader("data/userdata.txt");
            Scanner reader = new Scanner(userFile);
            while (reader.hasNextLine())
            {
                String s = reader.nextLine();
                String[] userData = s.split(", ");
                String user = userData[0];
                String password = userData[1];

                if (userLogin.equals(user) && userPassword.equals(password))
                {
                    return true;
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Datafile not found");
            //userData = null;
        }
        return false;
    }
}



