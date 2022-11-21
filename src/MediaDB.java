import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

public class MediaDB
{
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    TextUI u = new TextUI();
    // Declaring a variable of type Connection (from java.sql).
    private Connection connection;
    ArrayList<Media> movies = new ArrayList<>();
    ArrayList<Media> series = new ArrayList<>();

    // Method to
    public void
    run()
    {
        establishConnection();
        readMovieData();
        readSeriesData();

    }

    public void readMovieData()
    {
        String userInput = u.getUserInputForSearch("Which of the following movies would you like to watch - type in full title.");
        String query = MessageFormat.format( "select * from movies where title like \"{0}%\"", userInput);
        //String query = "select * from movies where title like \"g%\";";
        //System.out.println(query);
        try
        {
            // Makes an object (Statement statement) that sends SQL statements to the SQL-database (initialized as connection.createStatement() (a java.sql.Connection method)).
            PreparedStatement statement = connection.prepareStatement(query);
            // Using the variable statement to execute the String query which contains the SQL-statement(code for SQL-instructions).
            statement.execute(query);

            // Makes an object results (ResultSet result), which contains the current result from the query.
            ResultSet results = statement.executeQuery();

            // Iterating through the database rows using results.next() (a java.sql method). Adding each row to a variable.
            // Declaring and initializing a new Media object for movies, with the returned results as parameters and adding them to an ArrayList.
            while(results.next())
            {
                String ID = (results.getString("ID"));
                String title = (results.getString("title"));
                String genre = (results.getString("genre"));
                String releaseYear = (results.getString("releaseYear"));
                String rating = (results.getString("rating"));

                MediaType media = new Movies(ID, title, releaseYear, genre, rating );
                Movies movie = (Movies)media;
                this.movies.add(movie);
            }
            statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        printMovies();
        System.out.println("END");
    }

    public void readSeriesData()
    {
        String userInput = u.getUserInputForSearch("Which of the following series would you like to watch - type in full title.");
        String query = MessageFormat.format( "select * from series where title like \"{0}%\"", userInput);
        //String query = "select * from movies where title like \"g%\";";
        //System.out.println(query);
        try
        {
            // Makes an object (Statement statement) that sends SQL statements to the SQL-database (initialized as connection.createStatement() (a java.sql.Connection method)).
            Statement statement = this.connection.createStatement();
            // Using the variable statement to execute the String query which contains the SQL-statement(code for SQL-instructions).
            statement.execute(query);

            // Makes an object results (ResultSet result), which contains the current result from the query.
            ResultSet results = statement.getResultSet();

            // Iterating through the database rows using results.next() (a java.sql method). Adding each row to a variable.
            // Declaring and initializing a new Media object for movies, with the returned results as parameters and adding them to an ArrayList.
            while(results.next())
            {
                String ID = (results.getString("ID"));
                String title = (results.getString("title"));
                String genre = (results.getString("genre"));
                String releaseYear = (results.getString("releaseYear"));
                String rating = (results.getString("rating"));
                String amountOfEpisodesInSeason = (results.getString("amountOfEpisodesInSeason"));

                MediaType media = new Series(ID, title, releaseYear, genre, rating, amountOfEpisodesInSeason);
                Series series = (Series)media;
                this.series.add(series);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        printSeries();
        System.out.println("END");
    }

    private void printMovies()
    {
        for (Media m : this.movies)
        {
            System.out.println("Title: "+ m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating());
        }
    }
    private void printSeries()
    {
        for (Media m : this.series)
        {
            System.out.println("Title: "+ m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating() + "\nEpisodes ");
        }
    }

    // Method to make connection to mysql database.
    public void establishConnection()
    {
        // Declaring and initializing the variables to use in DriverManager.getConnection()
        String url = "jdbc:mysql://localhost/sp3_database?" + "autoReconnect=true&useSSL=false"; ;
        String username = "root";
        String password = "Ostefar";
        try
        {
            // Initializing the variable connection with DriverManager (from java.sql)
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database " + GREEN_BOLD + "established!" + RESET);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}