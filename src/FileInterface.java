import java.util.ArrayList;

public interface FileInterface {

    ArrayList<String> readMovieData();

    ArrayList<String> readSeriesData();

    void readUserData();

    void writeUserData();

    boolean readUserCredentials();


}
