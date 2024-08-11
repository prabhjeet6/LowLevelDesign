package designexamples.boardgames.chess;

import designexamples.boardgames.chess.piece.ChessPiece;

import java.util.Optional;

public class ChessCell {
    private final int x;
    private final int y;



    private  Optional<ChessPiece> chessPiece;


    public ChessCell(int x, int y, Optional<ChessPiece> chessPiece) {
        this.x = x;
        this.y = y;
        this.chessPiece = chessPiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Optional<ChessPiece> getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(Optional<ChessPiece> chessPiece) {
        this.chessPiece = chessPiece;
    }
}
