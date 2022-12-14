package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw  new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int columns){
        if (!positionExists(row, columns)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][columns];
    }

    public Piece piece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    /**
     * Método que atribui uma peça a uma determinada posição no tabuleiro
     * @param piece
     * @param position
     */
    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /**
     * Método que remove uma peça do tabuleiro
     * @param position
     * @return a peça retirada
     */
    public Piece removePiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null; //não tem mais peça nessa posição
        return aux;//retorna informando a peça que foi retirada
    }

    /**
     * Verifica se a posição existe no tabuleiro
     * @param position
     * @return
     */
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    /**
     * Verifrica se a posição existe
     * Se for diferente de nulo, então existe uma peça na posição indicada
     * @param position
     * @return
     */
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
