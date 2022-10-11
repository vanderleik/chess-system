package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition() {
    }

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from 1a to 8h.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /**
     * Dada uma posição no xadrez, eu devo converter para uma posição na matriz
     * matrix_row = 8 - chess_row
     * matrix_column = chess_column - 'a'
     * a = 0
     * b = 1
     * ...
     * 'a' - 'a' = 0
     * 'b' - 'a' = 1
     * @return new Position(8 - row, column - 'a')
     */
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    /**
     * Método que faz a operação inversa do método toPosition
     * @param position
     * @return
     */
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        /*
        essa string vazia "" é um macete para concatenar automático. Isso força o compilador a entender que se trata de
        uma concatenação de strings
         */
        return "" + column + row;
    }
}
