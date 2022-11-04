public class Series extends Media {
    private int amountOfEpisodes;
    private int amountOfSeasons;

    public Series(String title, int releaseYear, String genre, double rating, int amountOfEpisodes, int amountOfSeasons) {
        super(title, releaseYear, genre, rating);
        this.amountOfEpisodes = amountOfEpisodes;
        this.amountOfSeasons = amountOfSeasons;
    }

    public int getAmountOfEpisodes() {
        return amountOfEpisodes;
    }

    public int getAmountOfSeasons() {
        return amountOfSeasons;
    }

    @Override
    public String toString() {
        return super.toString() + "Series{" +
                "amountOfEpisodes=" + amountOfEpisodes +
                ", amountOfSeasons=" + amountOfSeasons +
                '}';
    }
}
