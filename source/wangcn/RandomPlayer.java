package wangcn;

import java.util.Random;

public class RandomPlayer implements Player {
    Random random = new Random();
    private String name;

    public RandomPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMove(ReadOnlyBoard board) {
        int col = this.random.nextInt(board.width);
        while (board.isColumnFull(col)) {
            col = this.random.nextInt(board.width);
        }
        return col;
    }
}
