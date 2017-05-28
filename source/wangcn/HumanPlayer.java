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
        int desiredMove = this.input.getMove();
        return 0; // todo
    }
}
