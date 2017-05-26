package wangcn;

public class ReadOnlyBoard {
    private Board board;
    public final int width;
    public final int height;

    public ReadOnlyBoard(Board board) {
        this.board = board;
        this.width = board.width;
        this.height = board.height;
    }

    public Cell get(int x, int y) {
        return this.board.read(x, y);
    }
}
