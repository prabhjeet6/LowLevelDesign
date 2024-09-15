package designpatterns.chainofresponsibilitypattern.loggerframework.logger;


import designpatterns.chainofresponsibilitypattern.loggerframework.data.LogLeveL;

public class ErrorLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public ErrorLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLeveL logLevel, String message) {
        if(logLevel.getLevel() == LogLeveL.ERROR.getLevel()) {
            this.logPublisher.notify(LogLeveL.ERROR + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
