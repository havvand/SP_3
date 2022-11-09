import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO{


    public ArrayList<String> readMovieData() {
        File movieFile = new File("data/moviedata.txt");
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
        File seriesFile = new File("data/seriesdata.txt");
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

    public static void writeUserData(ArrayList<Account> accountDatabases){
        try {
            FileWriter writer = new FileWriter("data/userdata.txt");
            writer.write( "name, password\n");

            for (Account a : accountDatabases) {
                writer.write(a.getUsername() + ", " + a.getPassword()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    }


