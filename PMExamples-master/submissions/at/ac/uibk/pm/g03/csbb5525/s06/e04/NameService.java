package at.ac.uibk.pm.g03.csbb5525.s06.e04;

public class NameService {
    private final Logger logger;

    public NameService(Logger logger) {
        this.logger = logger;
    }

    public String constructFullName(String forename, String surname) {
        if(forename.equals(forename.toUpperCase())) {
            logger.warn("All caps forename");
        }
        if(surname.equals(surname.toUpperCase())) {
            logger.warn("All caps surname");
        }

        return forename + " " + surname;

    }
}
