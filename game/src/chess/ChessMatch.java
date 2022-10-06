package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Essa classe é o coração do jogo de xadrez. É nessa classe que teremos as regras do jogo.
 */
public class ChessMatch {
    private Board board;

    /**
     * Cria o tabuleiro de xadrez e chama o setup
     */
    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
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

    /**
     * Método que recebe as coordenadas do xadrez
     * @param column
     * @param row
     * @param piece
     */
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    /**
     * Método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
     */
    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }

}
