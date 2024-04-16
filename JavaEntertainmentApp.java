import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class JavaEntertainmentApp {
    private static List<Show> shows = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User loginUser;
    private static User User;
    private static User[] userList;
    User user = new User("John Doe", "john@example.com", "password");

    public static void main(String[] args) {
        String choice;

        do {
            System.out.println("JavaEntertainment Application");
            System.out.println("1. Add Show");
            System.out.println("2.Show Renewal");
            System.out.println("3. Search and Evaluate Show");
            System.out.println("4. View User Ratings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addShow();
                    break;
                case "2":
                    showRenewal();
                    break;
                case "3":
                    searchAndEvaluateShow(User);
                    break;
                case "4":
                    viewUserRatings(User);
                    break;
                case "5":
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (!choice.equals("5"));
    }


    public static void addShow() {
        System.out.println("Enter show details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Year of 1st screening: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Country of production: ");
        String country = scanner.nextLine();
        System.out.print("Director's name: ");
        String director = scanner.nextLine();

        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.DRAMA);
        genres.add(Genre.THRILLER);
        genres.add(Genre.COMEDY);
        genres.add(Genre.HORROR);
        genres.add(Genre.CRIME);
        genres.add(Genre.ROMANCE);
        Director showDirector = new Director("Director Name"); // Replace "Director Name" with the actual director name
        Show show = new Show("Show Title", 2023, genres, "Country", director);


        System.out.print("Is it a series or miniseries? (S/M): ");
        String seriesOption = scanner.nextLine();

        if (seriesOption.equalsIgnoreCase("S")) {
            System.out.print("Number of seasons: ");
            int seasons = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Number of episodes per season: ");
            int episodesPerSeason = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Year last aired: ");
            int lastAiredYear = scanner.nextInt();
            scanner.nextLine();

            show.setSeriesDetails(seasons, episodesPerSeason, lastAiredYear);
        }

        System.out.println();
        System.out.println("Enter actor details (Enter 'done' to finish):");

        String actor;
        do {
            System.out.print("Actor's full name: ");
            actor = scanner.nextLine();

            if (!actor.equalsIgnoreCase("done")) {
                show.addActor(actor);
            }
        }while (!actor.equalsIgnoreCase("done")) ;

            shows.add(show);
            System.out.println();
            System.out.println("Show added successfully!");
            show.displayShowInfo();
        }
    public static void showRenewal() {
        System.out.println("Enter the show ID or title to renew:");
        String searchInput = scanner.nextLine();

        Show selectedShow = null;
        boolean found = false;

        // Search for the show by ID or title
        for (Show show : shows) {
            if (show.getShowId() == Integer.parseInt(searchInput) || show.getTitle().equalsIgnoreCase(searchInput)) {
                selectedShow = show;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Show found. Current details:");
            selectedShow.displayShowDetails();
            System.out.println();

            // Prompt for show renewal details
            System.out.println("Enter the renewal details:");
            System.out.print("Number of seasons: ");
            int seasons = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Episodes per season: ");
            int episodesPerSeason = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Year last aired: ");
            int lastAiredYear = scanner.nextInt();
            scanner.nextLine();

            // Update the show details
            selectedShow.setSeriesDetails(seasons, episodesPerSeason, lastAiredYear);

            // Prompt for adding actors
            String actor;
            do {
                System.out.print("Add actor (or 'done' to finish): ");
                actor = scanner.nextLine();

                if (!actor.equalsIgnoreCase("done")) {
                    selectedShow.addActor(actor);
                }
            } while (!actor.equalsIgnoreCase("done"));

            System.out.println();
            System.out.println("Show renewed successfully!");
            selectedShow.displayShowDetails();
        } else {
            System.out.println("Show not found.");
        }
    }
    public static void searchAndEvaluateShow(User user) {
        System.out.println("Search and Evaluate Show");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Year");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                searchByTitle();
                break;
            case "2":
                searchByYear();
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
        }
        System.out.print("Do you want to rating any show? (Y/N): ");
        String evaluateChoice = scanner.nextLine();

        if (evaluateChoice.equalsIgnoreCase("Y")) {
            if (user != null) {
                System.out.print("Enter the show ID to evaluate: ");
                int showId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter your rating (1-10): ");
                int rating = scanner.nextInt();
                scanner.nextLine();

                user.rateShow(showId, rating);
                System.out.println("Show rated successfully.");
            } else {
                System.out.println("You need to be logged in to evaluate a show.");
                System.out.print("Do you want to sign in? (Y/N): ");
                String signInChoice = scanner.nextLine();

                if (signInChoice.equalsIgnoreCase("Y")) {
                    user = signIn();
                    if (user != null) {
                        System.out.print("Enter the show ID to evaluate: ");
                        int showId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter your rating (1-10): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine();

                        Show show = findShowById(showId);
                        if (show != null) {
                            user.evaluateShow(show, rating);
                            System.out.println("Show rated successfully.");
                        } else {
                            System.out.println("Show not found.");
                        }
                    } else {
                        System.out.println("Invalid credentials. Sign in failed.");
                    }
                }
            }
        }
    }

    private static User signIn() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : userList) {
            if (user.getemail().equals(email) && user.getpassword().equals(password)) {
                return user; // Return the matched user
            }
        }

        return null;
    }


    public static void searchByTitle() {
        System.out.print("Enter the show title: ");
        String title = scanner.nextLine();

        List<Show> searchResults = new ArrayList<>();

        for (Show show : shows) {
            if (show.getTitle().equalsIgnoreCase(title)) {
                searchResults.add(show);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No matching shows found.");
        } else {
            displaySearchResults(searchResults);
        }
    }

    public static void searchByYear() {
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        List<Show> searchResults = new ArrayList<>();

        for (Show show : shows) {
            if (show.getYear() == year) {
                searchResults.add(show);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No matching shows found.");
        } else {
            displaySearchResults(searchResults);
        }
    }
    public static void displaySearchResults(List<Show> searchResults) {
        System.out.println("Search Results:");
        for (Show show : searchResults) {
            System.out.println("ID: " + show.getShowId());
            System.out.println("Title: " + show.getTitle());
            System.out.println("Year: " + show.getYear());
            System.out.println("Director: " + show.getDirector());
            System.out.println("Average Rating: " + show.getAverageRating());

            if (show instanceof Series) {
                Series series = (Series) show;
                System.out.println("Year Last Viewed: " + series.getYearLastViewed());
                System.out.println("Number of Seasons: " + series.getNumberOfSeasons());
            }

            System.out.println();
        }
    }
    public static void viewUserRatings(User user) {
        boolean loggedInUser;
        if (user != null) {
            System.out.println("User Ratings:");
            for (Map.Entry<Integer, Integer> entry : user.getShowRatings().entrySet()) {
                int showId = entry.getKey();
                int rating = entry.getValue();
                Show show = findShowById(showId);
                if (show != null) {
                    System.out.println("Show Title: " + show.getTitle());
                    System.out.println("Rating: " + rating);
                    System.out.println();
                }
            }
        } else {
            System.out.println("You need to be logged in to view your ratings.");
        }
    }

    private static Show findShowById(int showId)
    {
        for (Show show : shows) {
            if (show.getId() == showId) {
                return show;
            }
        }
        return null;
    }


}

