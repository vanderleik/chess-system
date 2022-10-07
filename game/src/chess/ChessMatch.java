package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();//Converte em posição da matriz
        Position target = targetPosition.toPosition();//Converte em posição da matriz

        //Valido se na posição havia realmente uma peça
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    /**
     * Lógica de movimentar a peça
     * @param source
     * @param target
     * @return retorna a peça capturada
     */
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);//Remove a peça da posição de origem
        Piece capturedPiece = board.removePiece(target);//Remove a possível peça que esteja na posição de destino
        board.placePiece(p, target);
        return capturedPiece;
    }

    /**
     * Valida a posição de origem da peça
     * @param position
     */
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
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
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
//        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
//        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
//        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
//        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
//        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
//        placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
//        placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
//        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
//        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
//        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
//        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
//        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
//        placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
//        placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));
    }

}
