import java.util.ArrayList;
import java.util.List;

class Show {
    private static int showCount = 0;

    private int showId;
    private String title;
    private int year;
    private String type;
    private Director director;
    private List<String> actors;
    private int seasons;
    private int episodesPerSeason;
    private int lastAiredYear;
    private List<Genre> genres;
    private String AverageRating;
    private int id;
    private List<Rating> ratings;


    public Show(String title, int year, List<Genre> genres, String country, Director director, List<Actor> actors) {
        this.showId = ++showCount;
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = new ArrayList<>();
        for (int i = 0; i < Math.min(actors.size(), 10); i++) {
            this.actors.add(actors.get(i).getName());
        }
        this.genres = genres;
    }

    public Show(String title, int year, List<Genre> genres, String country, Director director) {
        this.showId = ++showCount;
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = new ArrayList<>();
        this.genres = genres;
    }




    public static int showCount() {
        return showCount;
    }

    public static void setShowCount(int showCount) {
        Show.showCount = showCount;
    }

    public int getShowId() {
        return showId;
    }

    public void setSeriesDetails(int seasons, int episodesPerSeason, int lastAiredYear) {
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.lastAiredYear = lastAiredYear;
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    public void displayShowInfo() {
        System.out.println("Show ID: " + showId);
        System.out.println("Title: " + title);
        System.out.println("Type: " + type);
        System.out.println("Director: " + director);
    }
    public void displayShowDetails() {
        System.out.println("Show ID: " + showId);
        System.out.println("Title: " + title);
        System.out.println("Type: " + type);
        System.out.println("Director: " + director);
        System.out.println("Seasons: " + seasons);
        System.out.println("Episodes per Season: " + episodesPerSeason);
        System.out.println("Last Aired Year: " + lastAiredYear);
        System.out.println("Actors: " + actors);
    }

    public String getTitle() {
        return title;
    }
    public List<Genre> getGenres() {
        return genres;
    }

    public Director getDirector() {
        return director;
    }

    public String getAverageRating() {
        return AverageRating;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public List<Rating> getAllRatings() {
        return ratings;
    }

    public void addEvaluation(Evaluation evaluation) {
    }
}
