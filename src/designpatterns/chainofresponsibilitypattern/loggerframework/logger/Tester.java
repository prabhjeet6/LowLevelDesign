package designpatterns.chainofresponsibilitypattern.loggerframework.logger;

import designpatterns.chainofresponsibilitypattern.loggerframework.data.LogLeveL;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger();
        logger.log(LogLeveL.ERROR, "DB query failed");
        logger.log(LogLeveL.DEBUG,
                "Received an empty response");
    }
}
