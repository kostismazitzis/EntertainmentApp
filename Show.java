import java.util.ArrayList;
import java.util.List;

class Show {
    private static int showCount = 0;

    private int showId;
    private String title;
    private int year;
    private String type;
    private String country;
    private Director director;
    private List<String> actors;
    private List<Actor> actor;
    private int seasons;
    private int episodesPerSeason;
    private int lastAiredYear;
    private List<Genre> genres;
    private String AverageRating;
    private int id;
    private int yearOfFirstScreening;
    private List<Rating> ratings;
    private String countryOfProduction;



    public Show(String title, int year, List<Genre> genres, String country, Director director, List<Actor> actors) {
        this.showId = ++showCount;
        this.title = title;
        this.year = year;
        this.country = country;
        this.director = director;
        this.actors = new ArrayList<String>();
        for (int i = 0; i < Math.min(actors.size(), 10); i++) {
            this.actors.add(String.valueOf(actors.get(i)));
        }
        this.genres = genres;
    }

    public Show(String show_title, int year, List<Genre> genres, String country, String director) {
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
