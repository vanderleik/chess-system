package chess;

public class ChessException extends RuntimeException{
    static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }
}
