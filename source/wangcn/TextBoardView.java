package wangcn;

public class TextBoardView implements BoardView {
    ReadOnlyBoard board;

    public TextBoardView(ReadOnlyBoard board) {
        this.board = board;
    }

    @Override
    public void update() {
        System.out.println("CONNECT FOUR");
        for (int x = this.board.height -1; x >=0; x--)
        {
            for ( int y = 0; y < this.board.width; y++)
            {
                Cell cell = board.get(x, y);
                if (cell == Cell.EMPTY) {
                    System.out.print(". ");
                } else if (cell == Cell.COLOR1) {
                    System.out.print("Y ");
                } else if (cell == Cell.COLOR2) {
                    System.out.print("R ");
                } else {
                    throw new IllegalStateException("Cannot draw anything except empty and two colors");
                }
            }
            System.out.println();
        }
    }
}
