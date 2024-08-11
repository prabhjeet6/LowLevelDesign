package designexamples.boardgames;

import java.util.Queue;

public abstract class BoardGame {

    private final Queue<Player> players;
    private final Board board;

    public BoardGame(Queue<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public Queue<Player> getPlayers() {
        return players;
    }
    public Board getBoard() {
        return board;
    }
    public void startGame() {
        while (true) {
            Player currentPlayer = this.players.poll();
            Move currentMove = currentPlayer.MakeMove();
            board.applyMove(currentMove);
            if (isGameOver()) {
                System.out.println("Game Over!! " + currentPlayer + " won.");
                break;
            }
            this.players.add(currentPlayer);

        }

    }

    public abstract boolean isGameOver();


}
