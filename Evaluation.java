public class Evaluation {
    private String showTitle;
    private int rating;

    public Evaluation(String showTitle, int rating) {
        this.showTitle = showTitle;
        this.rating = rating;
    }

    public String showTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int rating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
