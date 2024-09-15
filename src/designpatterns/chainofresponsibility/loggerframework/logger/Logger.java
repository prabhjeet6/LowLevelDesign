package designpatterns.chainofresponsibility.loggerframework.logger;

import designpatterns.chainofresponsibility.loggerframework.data.LogLeveL;

public interface Logger {
    void log(LogLeveL leveL,String message);
}
