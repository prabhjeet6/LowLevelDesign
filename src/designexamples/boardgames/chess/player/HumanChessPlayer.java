package designexamples.boardgames.chess.player;

import designexamples.boardgames.Move;
import designexamples.boardgames.chess.ChessBoard;
import designexamples.boardgames.chess.PieceName;
import designexamples.boardgames.chess.piece.ChessPiece;

import java.util.Map;

public class HumanChessPlayer extends ChessPlayer {
    protected HumanChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard chessBoard) {
        super(name, pieces,chessBoard);
    }

    @Override
    public Move MakeMove() {
        return null;
    }
}
