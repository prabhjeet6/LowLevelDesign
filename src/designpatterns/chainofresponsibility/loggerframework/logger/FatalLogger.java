package designpatterns.chainofresponsibility.loggerframework.logger;

import designpatterns.chainofresponsibility.loggerframework.data.LogLeveL;

public class FatalLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public FatalLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLeveL logLevel, String message) {
        if(logLevel.getLevel() == LogLeveL.FATAL.getLevel()) {
            this.logPublisher.notify(LogLeveL.FATAL + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
