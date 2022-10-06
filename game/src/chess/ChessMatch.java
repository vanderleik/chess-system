package chess;

import boardgame.Board;

/**
 * Essa classe é o coração do jogo de xadrez. É nessa classe que teremos as regras do jogo.
 */
public class ChessMatch {
    private Board board;

    /**
     * Dimensão do tabuleiro de xadrez
     */
    public ChessMatch() {
        board = new Board(8,8);
    }

    /**
     * @return matriz de peças da partida de xadrez
     */
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

}
