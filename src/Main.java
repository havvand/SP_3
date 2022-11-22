public class Main {


    public static void main(String[] args) {


        AccountDataBase aOne = new AccountDataBase();
        MediaData media = new MediaData();
        MediaDB mediaDB = new MediaDB();

        System.out.println("LOL");

        mediaDB.readUserCredentials();
        mediaDB.run();
        media.playButtonForMovie();
        //mediaDB.addMovieToFavMedia(mediaDB.userId, mediaDB.movieId);

        //aOne.userAuthentication();




        //System.out.println("End Main");

    }
}
