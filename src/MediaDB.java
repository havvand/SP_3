import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

public class MediaDB {
    TextUI u = new TextUI();
    public static String userId;
    public static String movieId;
    public static String seriesId;
    // Declaring a variable of type Connection (from java.sql).
    protected static Connection connection;
    public static ArrayList<Media> movies = new ArrayList<>();
    public static ArrayList<Media> series = new ArrayList<>();

    // Method to
    public void     run() {
        establishConnection();
        runMovies();

    }

    public void runMovies() {
        String userInput = u.getUserInputForSearch("Which of the following movies would you like to watch - type in full title.");
        String query = MessageFormat.format("select * from movies where title like \"{0}%\"", userInput);
        //String query = "select * from movies where title like \"g%\";";
        System.out.println(query);
        System.out.println(movies);
        //System.out.println(query);
        try {
            // Makes an object (Statement statement) that sends SQL statements to the SQL-database (initialized as connection.createStatement() (a java.sql.Connection method)).
            Statement statement = this.connection.createStatement();
            // Using the variable statement to execute the String query which contains the SQL-statement(code for SQL-instructions).
            statement.execute(query);

            // Makes an object results (ResultSet result), which contains the current result from the query.
            ResultSet results = statement.getResultSet();

            // Iterating through the database rows useing results.next() (a java.sql method). Adding each row to a variable.
            // Declaring and initializing a new Media object for movies, with the returned results as parameters and adding them to an ArrayList.
            while (results.next()) {
                String ID = (results.getString("movieId"));
                String title = (results.getString("title"));
                String genre = (results.getString("genre"));
                String releaseYear = (results.getString("releaseYear"));
                String rating = (results.getString("rating"));

                Media media = new Movies(ID, title, releaseYear, genre, rating);
                Movies movie = (Movies) media;
                this.movies.add(movie);
                //movieId = movie.getID();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printMovies();
    }
    public void runSeries() {
        String userInput = u.getUserInputForSearch("Which of the following series would you like to watch - type in full title.");
        String query = MessageFormat.format("select * from series where title like \"{0}%\"", userInput);
        //String query = "select * from movies where title like \"g%\";";
        System.out.println(query);
        System.out.println(series);
        //System.out.println(query);
        try {
            // Makes an object (Statement statement) that sends SQL statements to the SQL-database (initialized as connection.createStatement() (a java.sql.Connection method)).
            Statement statement = this.connection.createStatement();
            // Using the variable statement to execute the String query which contains the SQL-statement(code for SQL-instructions).
            statement.execute(query);

            // Makes an object results (ResultSet result), which contains the current result from the query.
            ResultSet results = statement.getResultSet();

            // Iterating through the database rows useing results.next() (a java.sql method). Adding each row to a variable.
            // Declaring and initializing a new Media object for movies, with the returned results as parameters and adding them to an ArrayList.
            while (results.next()) {
                String ID = (results.getString("seriesId"));
                String title = (results.getString("title"));
                String genre = (results.getString("genre"));
                String releaseYear = (results.getString("releaseYear"));
                String rating = (results.getString("rating"));
                String amountOfEpisodesInSeason = (results.getString("amountOfEpisodesInSeason"));

                Media media = new Series(ID, title, releaseYear, genre, rating, amountOfEpisodesInSeason);
                Series serie = (Series) media;
                this.series.add(serie);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printSeries();
    }

    private void printMovies() {
        for (Media m : this.movies) {
            System.out.println("ID: "+m.getID()+ "\nTitle: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating());
        }
    }
    private void printSeries() {
        for (Media m : this.series) {
            System.out.println("ID: "+m.getID()+ "\nTitle: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating());
        }
    }

    // Method to make connection to mysql database.
    public void establishConnection() {
        // Declaring and initializing the variables to use in DriverManager.getConnection()
        String url = "jdbc:mysql://localhost/sp3_database?" + "autoReconnect=true&useSSL=false";
        ;
        String username = "root";
        String password = "Salar0108";
        try {
            // Initializing the variable connection with DriverManager (from java.sql)
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database established!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void newUser() {
        establishConnection();
        String usernameInput = u.getUserInput("Select username");
        String passwordInput = u.getUserInput("Select password");
        String login_query = "INSERT INTO userdata (username, password) VALUES (?,?)";
        // prepared statement query
        try {
            PreparedStatement query = connection.prepareStatement(login_query);
            query.setString(1, usernameInput);
            query.setString(2, passwordInput);
            // execute query
            query.execute();
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String readUserCredentials() {
        establishConnection();
        String username = u.getUserInput("USERNAME: ");
        String password = u.getUserInput("PASSWORD: ");
        String login_query = "SELECT * FROM userdata WHERE username ='" + username + "'" + "AND password ='" + password + "'";
        try {
            PreparedStatement query = connection.prepareStatement(login_query);
            // execute query
            ResultSet result = query.executeQuery();
            if (result.next()) {
               userId = result.getString("userId");
            } else {
                System.out.println("BAD");
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return userId;
    }


    public void addMovieToFavMedia(String userId, String movieId) {
        String favId = u.getUserInput("Do you want to add this movie to your favorite list? Y/N?");
        String addToFav_query = "INSERT INTO favoritmedia (movieId, userId) VALUES (?,?)";
        if (favId.equalsIgnoreCase("Y")) {
            try {
                PreparedStatement query = connection.prepareStatement(addToFav_query);
                query.setString(1, movieId);
                query.setString(2, userId);
                // execute query
                query.execute();
                query.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
                System.out.println("SOMETHING DIFFERENT HAPPENS");
            }
    }
    public void addSeriesToFavMedia(String userId, String seriesId) {
        establishConnection();
        String favId = u.getUserInput("Do you want to add this series to your favorite list? Y/N?");
        String addToFav_query = "INSERT INTO favoritmedia (seriesId, userId) VALUES (?,?)";
        if (favId.equalsIgnoreCase("Y")) {
            try {
                PreparedStatement query = connection.prepareStatement(addToFav_query);
                query.setString(1, seriesId);
                query.setString(2, userId);
                // execute query
                query.execute();
                query.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("SOMETHING DIFFERENT HAPPENS");
        }
    }
    public void addSeriesToWatchedMedia(String userId, String seriesId) {
        establishConnection();
        String addToFav_query = "INSERT INTO watchedmedia (seriesId, userId) VALUES (?,?)";
            try {
                PreparedStatement query = connection.prepareStatement(addToFav_query);
                query.setString(1, seriesId);
                query.setString(2, userId);
                // execute query
                query.execute();
                query.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public void addMoviesToWatchedMedia(String userId, String movieId) {
        establishConnection();
        String addToFav_query = "INSERT INTO watchedmedia (movieId, userId) VALUES (?,?)";
        try {
            PreparedStatement query = connection.prepareStatement(addToFav_query);
            query.setString(1, movieId);
            query.setString(2, userId);
            // execute query
            query.execute();
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}