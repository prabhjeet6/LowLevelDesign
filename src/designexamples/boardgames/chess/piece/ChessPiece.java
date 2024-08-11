package designexamples.boardgames.chess.piece;

import designexamples.boardgames.chess.ChessBoard;
import designexamples.boardgames.chess.ChessCell;
import designexamples.boardgames.chess.PieceName;

public interface ChessPiece {
    PieceName getPieceName();
    boolean isDead();

    void setDead(boolean isDead);

    void move(ChessCell source, ChessCell destination, ChessBoard chessBoard);

}
