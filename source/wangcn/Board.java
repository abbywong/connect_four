package wangcn;

public class Board {
    public final int width;
    public final int height;
    private final Cell[][] data;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new Cell[height][width];
        this.makeBoardEmpty();

    }

    private void makeBoardEmpty() {
        for (int x = 0; x < height; x++)
        {
            for ( int y = 0; y < width; y++)
            {
                this.data[x][y] = Cell.EMPTY;
            }
        }
    }

    public Cell read(int x, int y) {
        return this.data[x][y];
    }

    public void drop(int col, Cell color) throws NotAValidMoveException {
        if (color == Cell.EMPTY) {
            throw new IllegalArgumentException("You can only drop red and yellow pieces");
        }
        if(this.isColumnFull(col)) {
            throw new NotAValidMoveException(String.format("Column %d is full", col));
        }
        for (int x = 0; x < height; x++)
        {
            if (this.data[x][col] == Cell.EMPTY) {
                // set color
                this.data[x][col] = color;
                // stop
                return;
            }
        }
    }

    public boolean isFull() {
        for ( int y = 0; y < width; y++)
        {
            if (!isColumnFull(y))
            {
                return false;
            }
        }
        return true;
    }

    public boolean isColumnFull(int col) {
        int x = height - 1;
        if (this.data[x][col] == Cell.EMPTY)
        {
            return false;
        }
        return true;
    }
}
