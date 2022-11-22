public class Main {


    public static void main(String[] args) {


        AccountDataBase aOne = new AccountDataBase();
        TextUI textUI = new TextUI();
        MediaData media = new MediaData();
        MediaDB mediaDB = new MediaDB();
        System.out.println("LOL");

        mediaDB.run();
        System.out.println(mediaDB.foundSeriesList);
        media.playButtonForSeries();

        aOne.userAuthentication();




        //System.out.println("End Main");

    }
}
