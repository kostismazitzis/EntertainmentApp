import java.util.Date;

public class Actor {
        private int actorId;
        private String Name;
        private Date dateOfBirth;
        private String countryOfBirth;
        private String website;

        public Actor(String Name, Date dateOfBirth, String countryOfBirth, String website) {
            this.Name = Name;
            this.dateOfBirth = dateOfBirth;
            this.countryOfBirth = countryOfBirth;
            this.website = website;
        }

        // Getters and Setters

        public int getActorId() {
            return actorId;
        }

        public void setActorId(int actorId) {
            this.actorId = actorId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getCountryOfBirth() {
            return countryOfBirth;
        }

        public void setCountryOfBirth(String countryOfBirth) {
            this.countryOfBirth = countryOfBirth;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }
    }
