package designpatterns.chainofresponsibilitypattern.loggerframework.logger;

import designpatterns.chainofresponsibilitypattern.loggerframework.data.LogLeveL;

public interface Logger {
    void log(LogLeveL leveL,String message);
}
