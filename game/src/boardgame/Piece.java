package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece() {
    }

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    /**
     * Método abstrato que verifica se o movimento da peça é possível
     * @return
     */
    public abstract boolean[][] possibleMovies();

    /**
     * Verifica se é possível mover a peça para uma determinada posição
     * Implementa o método abstrato possibleMovies()
     * @param position
     * @return
     */
    public boolean possibleMove(Position position){
        return possibleMovies()[position.getRow()][position.getColumn()];
    }

    /**
     * Método que verifica se existe pelo menos um movimento útil para a peça
     * @return
     */
    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMovies();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
