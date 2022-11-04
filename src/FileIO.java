import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

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
            seriesData = null;
        }
        return seriesData;
    }
}
