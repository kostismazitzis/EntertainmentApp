import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String email;
    private String password;
    private Map<Integer, Integer> showRatings; // Map to store show ratings (showId, rating)
    private List<Evaluation> evaluations;

    private List<Director> favoriteDirectors;
    private Actor[] actors;
    private Director[] directors;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.showRatings = new HashMap<>();
        this.evaluations = new ArrayList<>();
        this.favoriteDirectors = new ArrayList<>();
        this.actors = new Actor[0];
        this.directors = new Director[0];
    }


    public void rateShow(int showId, int rating) {
        showRatings.put(showId, rating);
    }

    public int getRatingForShow(int showId) {
        return showRatings.getOrDefault(showId, -1); // Return -1 if no rating is found
    }

    // Getter methods for name, email, and password

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Director> favoriteDirectors() {
        return favoriteDirectors;
    }

    public void setFavoriteDirectors(List<Director> favoriteDirectors) {
        this.favoriteDirectors = favoriteDirectors;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Integer, Integer> showRatings() {
        return showRatings;
    }

    public void setShowRatings(Map<Integer, Integer> showRatings) {
        this.showRatings = showRatings;
    }

    public Map<Integer, Integer> getShowRatings() {
        return showRatings;
    }
    public List<Evaluation> getAllEvaluations() {
        return evaluations;
    }

    public List<Evaluation> evaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void evaluateShow(Show show, int rating) {
        Evaluation evaluation = new Evaluation(show.getTitle(), rating);
        show.addEvaluation(evaluation);
    }

    public Actor[] actors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public Director[] directors() {
        return directors;
    }

    public void setDirectors(Director[] directors) {
        this.directors = directors;
    }

    public Object getpassword() {
        return password;
    }

    public Object getemail() {
        return email;
    }
}

