package designpatterns.chainofresponsibility.loggerframework.logger;

import designpatterns.chainofresponsibility.loggerframework.data.LogLeveL;

public class DebugLogger implements Logger{

    private final Logger nextLogger;
    private final Publisher logPublisher;

    public DebugLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLeveL leveL, String message) {
        if (leveL.getLevel() == LogLeveL.DEBUG.getLevel()) {
            this.logPublisher.notify(LogLeveL.DEBUG + " " + message);
        }
        this.nextLogger.log(leveL, message);
    }
}