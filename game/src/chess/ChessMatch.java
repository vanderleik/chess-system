package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Roock;

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
     * Método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
     */
    private void initialSetup(){
        board.placePiece(new Roock(board, Color.WHITE), new Position(2,1));
        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
    }

}
