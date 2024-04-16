import java.util.List;

public class Series extends Show  {
    private int numberOfSeasons;
    private int episodesPerSeason;
    private int yearLastViewed;

    public Series(String title, int year, List<Genre> genres, String country, Director director, int numberOfSeasons, int episodesPerSeason, int yearLastViewed) {
        super(title, year, genres, country, String.valueOf(director));
        this.numberOfSeasons = numberOfSeasons;
        this.episodesPerSeason = episodesPerSeason;
        this.yearLastViewed = yearLastViewed;
    }

    public int numberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int episodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int yearLastViewed() {
        return yearLastViewed;
    }

    public void setYearLastViewed(int yearLastViewed) {
        this.yearLastViewed = yearLastViewed;
    }

    public int getYearLastViewed() {
        return yearLastViewed;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }
}
