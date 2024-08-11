package designexamples.boardgames.chess.player;

import designexamples.boardgames.Move;
import designexamples.boardgames.Pair;
import designexamples.boardgames.chess.ChessBoard;
import designexamples.boardgames.chess.PieceName;
import designexamples.boardgames.chess.piece.ChessPiece;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class HumanChessPlayer extends ChessPlayer {
    protected HumanChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard chessBoard) {
        super(name, pieces,chessBoard);
    }

    @Override
    public Move MakeMove() {
        Pair source = null;
        // logic to get source; e.g. display then scan from console
        getChessBoard().display();
        int x, y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt(); y = scanner.nextInt(); source = new Pair(x, y);
        Optional<ChessPiece> chessPiece = this.getChessBoard().getCell(source).getChessPiece();
        if (!chessPiece.isPresent())
            throw new RuntimeException("Invalid spot");
        if (!chessPiece.get().equals(getChessPiece(chessPiece.get().getPieceName())))
            throw new RuntimeException("Illegal piece chosen");
        Pair destination = null;
        x = scanner.nextInt(); y = scanner.nextInt(); destination = new Pair(x, y);
        // logic to get destination and validate | No checks | check at move side
        return new Move(source, destination);

    }
}
