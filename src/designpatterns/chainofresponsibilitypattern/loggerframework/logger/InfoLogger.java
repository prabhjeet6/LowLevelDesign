package designpatterns.chainofresponsibilitypattern.loggerframework.logger;

import designpatterns.chainofresponsibilitypattern.loggerframework.data.LogLeveL;

public class InfoLogger implements Logger{
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public InfoLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLeveL leveL, String message) {
        if (leveL.getLevel() == LogLeveL.INFO.getLevel()) {
            this.logPublisher.notify(LogLeveL.INFO + " " + message);
        }
        this.nextLogger.log(leveL, message);
    }

}
