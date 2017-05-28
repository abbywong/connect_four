package wangcn;

public class NotAValidMoveException extends Exception {
    public NotAValidMoveException(String msg) {
        super(msg);
    }
}
