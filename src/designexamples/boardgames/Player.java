package designexamples.boardgames;

public abstract class Player {
    private final String name;

    protected Player(String name) {
        this.name = name;
    }

    public abstract Move MakeMove();
}
