public class Series extends Media {
    private int amountOfEpisodesInSeason;

    public Series(String title, int releaseYear, String genre, double rating, int amountOfEpisodesInSeason) {
        super(title, releaseYear, genre, rating);
        this.amountOfEpisodesInSeason = amountOfEpisodesInSeason;

    }

    public int getAmountOfEpisodesInSeason() {
        return amountOfEpisodesInSeason;
    }


    @Override
    public String toString() {
        return super.toString() + "Series{" +
                "amountOfEpisodesInSeason=" + amountOfEpisodesInSeason +

        '}';
    }
}
