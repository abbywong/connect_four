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
        return Cell.EMPTY; //todo
    }

    public void drop(int y, Cell color) {
        if (color == Cell.EMPTY) {
            throw new IllegalArgumentException("You can only drop red and yellow pieces");
        }
        // todo
    }
}
