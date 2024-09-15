package designpatterns.chainofresponsibility.loggerframework.data;

public enum LogLeveL {
    DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);

    LogLeveL(int level) {
        this.level = level;
    }

    private final int level;

    public int getLevel() {
        return level;
    }
}
