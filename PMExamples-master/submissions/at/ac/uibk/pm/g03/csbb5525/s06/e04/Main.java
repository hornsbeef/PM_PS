package at.ac.uibk.pm.g03.csbb5525.s06.e04;

public class Main {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        NameService nameService = new NameService(logger);
        String fullName = nameService.constructFullName("MAX", "MUSTERMANN");
        System.out.println(fullName);
    }
}
