package designpatterns.chainofresponsibility.loggerframework.logger;


import designpatterns.chainofresponsibility.loggerframework.data.LogLeveL;

public class AnalyticsLogger implements Logger{

    private final Logger nextLogger;
    private final Publisher logPublisher;

    public AnalyticsLogger(Logger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLeveL logLevel, String message) {
        if(logLevel.getLevel() == LogLeveL.ERROR.getLevel()) {
            //
        }
        this.nextLogger.log(logLevel, message);
    }
}
