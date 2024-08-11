package designexamples.boardgames.chess.player;

import designexamples.boardgames.Move;
import designexamples.boardgames.Player;
import designexamples.boardgames.chess.ChessBoard;
import designexamples.boardgames.chess.PieceName;
import designexamples.boardgames.chess.piece.ChessPiece;

import java.util.Map;

public abstract class ChessPlayer extends Player {

    private final Map<PieceName, ChessPiece> pieces;

    private final ChessBoard chessBoard;



    protected ChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard chessBoard) {
        super(name);
        this.pieces = pieces;
        this.chessBoard = chessBoard;
    }

    public ChessBoard getChessBoard() {
        return this.chessBoard;
    }
    public Map<PieceName, ChessPiece> getPieces() {
        return pieces;
    }

    public ChessPiece getChessPiece(PieceName pieceName){
        if(this.pieces.containsKey(pieceName)){
            return this.pieces.get(pieceName);
        }else{
            throw new IllegalArgumentException("Illegal PieceName");
        }
    }


    public abstract Move MakeMove();
}
