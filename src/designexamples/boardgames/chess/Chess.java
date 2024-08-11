package designexamples.boardgames.chess;

import designexamples.boardgames.Board;
import designexamples.boardgames.BoardGame;
import designexamples.boardgames.Player;

import java.util.Queue;

public class Chess extends BoardGame {

    public Chess(Queue<Player> players, Board board) {
        super(players, board);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
