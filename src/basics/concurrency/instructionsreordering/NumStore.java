package basics.concurrency.instructionsreordering;

public class NumStore {
    int x;
    int y;
    int z;

    public NumStore() {
        x = 0;
        y = 0;
        z = 0;
        w = 0;
    }

    int w;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public void increment() {
        x++;
        y++;
        z++;
        w++;
    }
}
