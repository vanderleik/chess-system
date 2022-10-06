package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Roock extends ChessPiece {

    public Roock(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
