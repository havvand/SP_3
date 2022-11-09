public class Series extends Media {
    private String amountOfEpisodesInSeason;

    public Series(String title, String releaseYear, String genre, String rating, String amountOfEpisodesInSeason) {
        super(title, releaseYear, genre, rating);
        this.amountOfEpisodesInSeason = amountOfEpisodesInSeason;

    }

    public String getAmountOfEpisodesInSeason() {
        return amountOfEpisodesInSeason;
    }


    @Override
    public String toString() {
        return super.toString() + "Series{" +
                "amountOfEpisodesInSeason=" + amountOfEpisodesInSeason +

        '}';
    }
}
