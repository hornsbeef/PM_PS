package at.ac.uibk.pm.g03.csbb5525.s06.e04;

public class LoggerSpy implements Logger, Spy {
    private final Logger logger;
    private int counter = 0;

    //Constructor
    private LoggerSpy(Logger logger) {
        this.logger = logger;
    }

    public static LoggerSpy spy(Logger logger) {
        return new LoggerSpy(logger);
    }



    @Override
    public void warn(String message) {
        counter++;
        logger.warn(message);
    }

    @Override
    public int getInteractions() {
        return counter;
    }
}
