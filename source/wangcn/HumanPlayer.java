package wangcn;

public class HumanPlayer implements Player {
    private final InputController input;

    public HumanPlayer(InputController input) {
        this.input = input;
    }

    @Override
    public String getName() {
        return "human player";
    }

    @Override
    public int getMove(ReadOnlyBoard board) {
        //  int desiredMove = this.input.getColumn();
        int col = this.input.getColumn();
//        for (col < board.width; col++) {
            while (col >= board.width ||col<0|| board.isColumnFull(col)) {
                col = this.input.getColumn();
            }
            return col;
//        }
    }
}
