public class Rating {
    private String username;
    private int rating;


    public Rating(String username, int rating) {
        this.username = username;
        this.rating = rating;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int rating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
