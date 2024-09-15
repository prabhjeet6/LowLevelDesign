package designpatterns.chainofresponsibilitypattern.loggerframework.logger;

import designpatterns.chainofresponsibilitypattern.loggerframework.data.LogLeveL;

public class WarnLogger implements Logger {
    private final Logger nextLogger;
    private final Publisher logPublisher;

    public WarnLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }


    @Override
    public void log(LogLeveL leveL, String message) {
        if (leveL.getLevel() == LogLeveL.WARN.getLevel()) {
            logPublisher.notify(LogLeveL.WARN + " " + message);
        }
        this.nextLogger.log(leveL, message);
    }
}
