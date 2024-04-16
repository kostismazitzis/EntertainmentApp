import java.time.LocalDate;

public class Director {
    private String name;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String website;

    public Director(String name, LocalDate dateOfBirth, String countryOfBirth, String website) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.website = website;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String countryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String website() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
