package designexamples.boardgames.chess.piece;

import designexamples.boardgames.chess.ChessBoard;
import designexamples.boardgames.chess.ChessCell;
import designexamples.boardgames.chess.Color;
import designexamples.boardgames.chess.PieceName;

public class Bishop implements ChessPiece{

    private final PieceName pieceName;
    private final Color color;
    private boolean isDead;

    public Bishop(PieceName pieceName, Color color, boolean isDead) {
        this.pieceName = pieceName;
        this.color = color;
        this.isDead = isDead;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public PieceName getPieceName() {
        return this.pieceName;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void setDead(boolean isDead) {
     this.isDead=isDead;
    }

    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard chessBoard) {

    }


}
