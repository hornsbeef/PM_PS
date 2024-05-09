package at.ac.uibk.pm.g03.csbb5525.s06.e04;

public class LoggerImpl implements Logger {


    @Override
    public void warn(String message) {
        System.out.println("Warning: "+message);
    }
}
