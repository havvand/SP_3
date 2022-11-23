import java.sql.*;
import java.util.ArrayList;

public class MediaDB
{
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    TextUI u = new TextUI();

    public static String userId;
    public static String movieId;
    public static String seriesId;
    // Declaring a variable of type Connection (from java.sql).
    protected static Connection connection;
    public static ArrayList<Media> movies = new ArrayList<>();
    public static ArrayList<Media> series = new ArrayList<>();
    ArrayList<String> watchedMovies = new ArrayList<>();
    ArrayList<String> watchedSeries = new ArrayList<>();
    ArrayList<String> favoriteMovies = new ArrayList<>();
    ArrayList<String> favoriteSeries = new ArrayList<>();


    // Method to
    public void run()
    {
        int input = Integer.parseInt(u.getUserInput("Press 1 for movies: | Press 2 for series:"));

        if (input == 1)
        {
            movieOptions();
        }
        if (input == 2)
        {
            seriesOptions();
        }

    }

    public void movieOptions()
    {
        MediaData m = new MediaData();
        int input = Integer.parseInt(u.getUserInputForSearch("What do you wanna watch? Press 1 to search TITLE | 2 for CATEGORY | 3 to see your LISTS. "));

        if (input == 1)
        {
            String userInput = u.getUserInputForSearch("Search for title");
            String search_query = "SELECT * FROM movies WHERE title like \"%" + userInput + "%\"";
            //String search_query = "SELECT * FROM movies WHERE title like \"%" + userInput + "%\"";
            //query = MessageFormat.format("select * from movies where title like \"%{0}%\"", userInput);
            makeMovieQuery(search_query);
            System.out.println("FIRST");
            m.playButtonForMovie();
        }
        if (input == 2)
        {
            String userInput = u.getUserInputForSearch("Search for category");
            String search_query = "SELECT * FROM movies WHERE genre like \"%" + userInput + "%\"";
            makeMovieQuery(search_query);
            m.playButtonForMovie();
        }
        if (input == 3)
        {
            int input2 = Integer.parseInt(u.getUserInputForSearch("1 for watched media | 2 for favorite list"));

            if(input2 == 1)
            {
                System.out.println("WATCHED IN MOVIES");
                String userInput = userId;
                String search_query = "SELECT * FROM watchedmedia WHERE userId like \"%" + userInput + "%\"";
                makeWatchedQuery(search_query);
                System.out.println(watchedMovies);
            }
            if (input2 == 2)
            {
                //String userInput = userId;
                //String search_query = "SELECT * FROM favoritmedia WHERE userId like \"%" + userInput + "%\"";
                String search_query = "select favoritmedia.favMediaId, favoritmedia.userId, favoritmedia.seriesId,favoritmedia.movieId, movies.title, userdata.username\n" +
                        "from favoritmedia\n" +
                        "inner join userdata on favoritmedia.userId = userdata.userId\n" +
                        "join movies on movies.movieId = favoritmedia.movieId;";
                makeFavoriteQuery(search_query);
                for (String favMov: favoriteMovies)
                {
                    //System.out.println("SOUT IN OPTION 3-2 MOVIES-OPTION " );
                    if (favMov.contains(userId))
                    {
                        //System.out.println("INDEX 1 " + favoriteMovies.get(0));
                        String one = favMov.replace(userId, " ");
                        System.out.println(one);
                    }
                }

            }
        }
        //System.out.println("PRINTED LIST" + movies);
        //System.out.println(query);
        //return query;
    }

    public void seriesOptions() {
        MediaData m = new MediaData();
        int input = Integer.parseInt(u.getUserInputForSearch("What do you wanna watch? Press 1 to search TITLE | 2 for CATEGORY | 3 to see your LISTS. "));

        if (input == 1) {
            String userInput = u.getUserInputForSearch("Search for title");
            String search_query = "SELECT * FROM series WHERE title like \"%" + userInput + "%\"";
            //String search_query = "SELECT * FROM movies WHERE title like \"%" + userInput + "%\"";
            //query = MessageFormat.format("select * from movies where title like \"%{0}%\"", userInput);
            makeSeriesQuery(search_query);
            System.out.println("FIRST - in series");
            m.playButtonForSeries();
        }
        if (input == 2) {
            String userInput = u.getUserInputForSearch("Search for category");
            String search_query = "SELECT * FROM series WHERE genre like \"%" + userInput + "%\"";
            makeSeriesQuery(search_query);
            m.playButtonForSeries();
        }
        if (input == 3) {
            int input2 = Integer.parseInt(u.getUserInputForSearch("1 for watched media | 2 for favorite list"));

            if (input2 == 1) {
                System.out.println("WATCHED IN SERIES");
                String userInput = userId;
                String search_query = "SELECT * FROM watchedmedia WHERE userId like \"%" + userInput + "%\"";
                makeWatchedQuery(search_query);
                System.out.println(watchedSeries);
            }
            if (input2 == 2) {
                System.out.println("FAVORIT IN SERIES");
                //String userInput = userId;
                String search_query = "select favoritmedia.favMediaId, favoritmedia.userId, favoritmedia.seriesId, series.title, userdata.username\n" +
                        "from favoritmedia\n" +
                        "inner join userdata on favoritmedia.userId = userdata.userId\n" +
                        "join series on series.seriesId = favoritmedia.seriesId;";
                makeFavoriteQuery(search_query);
                for (String watchedM : favoriteSeries) {
                    System.out.println("SOUT IN OPTION 3-2 SERIES-OPTIONS");
                    if (watchedM != null) {
                        System.out.println(watchedM);
                    }
                }
            }
        }
    }
        //System.out.println("PRINTED LIST" + movies);
        //System.out.println(query);
        public void makeMovieQuery(String search_query){
        try {
            System.out.println("Search query in runMovies " + search_query);

                PreparedStatement query = connection.prepareStatement(search_query);
                // execute query
                query.executeQuery();
                ResultSet result = query.getResultSet();
                System.out.println(result);
            while (result.next()) // Scans for as long as there is another row with data (another film on the list).
            {
                String ID = (result.getString("movieId"));
                String title = (result.getString("title"));
                String genre = (result.getString("genre"));
                String releaseYear = (result.getString("releaseYear"));
                String rating = (result.getString("rating"));

                Media media = new Movies(ID, title, releaseYear, genre, rating);
                this.movies.add(media);
            }
            query.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        printMovies();
        System.out.println("END");


    }

    public void makeSeriesQuery(String search_query)
    {
        try {
            System.out.println("Search query in runSeries " + search_query);

            PreparedStatement query = connection.prepareStatement(search_query);
            // execute query
            query.executeQuery();
            ResultSet results = query.getResultSet();
            System.out.println(results);
            while (results.next()) {
                String ID = (results.getString("seriesId"));
                String title = (results.getString("title"));
                String genre = (results.getString("genre"));
                String releaseYear = (results.getString("releaseYear"));
                String rating = (results.getString("rating"));
                String amountOfEpisodesInSeason = (results.getString("amountOfEpisodesInSeason"));

                Media media = new Series(ID, title, releaseYear, genre, rating, amountOfEpisodesInSeason);
                this.series.add(media);

            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printSeries();
    }

    public void makeWatchedQuery(String search_query)
    {
        //ArrayList<String> watchedMovies = new ArrayList<>();
        //ArrayList<String> watchedSeries = new ArrayList<>();
        try {
            System.out.println("Search query in watched " + search_query);

            PreparedStatement query = connection.prepareStatement(search_query);
            // execute query
            query.executeQuery();
            ResultSet result = query.getResultSet();
            System.out.println(result);
            while (result.next()) // Scans for as long as there is another row with data (another film on the list).
            {
                String ID = (result.getString("watchedMediaId"));
                String movieId = (result.getString("movieId"));
                String seriesId = (result.getString("seriesId"));
                String userId = (result.getString("userId"));
                watchedMovies.add(movieId);
                watchedSeries.add(seriesId);
            }
            query.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("END");
    }

    public void makeFavoriteQuery(String search_query) {
        //ArrayList<String> favoriteMovies = new ArrayList<>();
        try {
            System.out.println("Search query in watched " + search_query);

            PreparedStatement query = connection.prepareStatement(search_query);
            // execute query
            query.executeQuery();
            ResultSet result = query.getResultSet();
            System.out.println("RESULT "+result);
            while (result.next()) // Scans for as long as there is another row with data (another film on the list).
            {
                String favMediaId = (result.getString("favMediaId"));
                String userId = (result.getString("userId"));
                String seriesId = (result.getString("seriesId"));
                String title = (result.getString("title"));
                String userName = (result.getString("username"));
                favoriteMovies.add(title+" "+userId);
                favoriteSeries.add(title+" "+userId);
            }
            query.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }

    private void printMovies()
    {
        for (Media m : this.movies)
        {
            System.out.println("ID: "+m.getID()+ "\nTitle: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating());
        }
    }
    private void printSeries()
    {
        for (Media m : this.series)
        {
            System.out.println("ID: "+m.getID()+ "\nTitle: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nRating: " + m.getRating());
        }
    }

    // Method to make connection to mysql database.
    public void establishConnection() {
        // Declaring and initializing the variables to use in DriverManager.getConnection()
        String url = "jdbc:mysql://localhost/sp3_database?" + "autoReconnect=true&useSSL=false";
        ;
        String username = "root";
        String password = "Ostefar";
        try {
            // Initializing the variable connection with DriverManager (from java.sql)
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database established!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void newUser()
    {
        //establishConnection();
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
        //establishConnection();
        String username = u.getUserInput("USERNAME: ");
        String password = u.getUserInput("PASSWORD: ");
        String login_query = "SELECT * FROM userdata WHERE username ='" + username + "'" + "AND password ='" + password + "'";
        try {
            PreparedStatement query = connection.prepareStatement(login_query);
            // execute query
            ResultSet result = query.executeQuery();
            if (result.next()) {
               userId = result.getString("userId");
               u.displayMessage("Login Success");
            } else {
                u.displayMessage("Login Failed! - Try Again!");
                readUserCredentials();
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
                movieOptions();
                System.out.println("SOMETHING DIFFERENT HAPPENS");
            }
    }
    public void addSeriesToFavMedia(String userId, String seriesId) {
        //establishConnection();
        String favId = u.getUserInput("Do you want to add this series to your favorite list? Y/N?");
        String addToFav_query = "INSERT INTO favoritmedia (userId, seriesId) VALUES (?,?)";
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
            seriesOptions();
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