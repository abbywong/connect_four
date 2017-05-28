package wangcn;

public class RandomPlayer implements Player {


    @Override
    public String getName() {
        return "random player";
    }

    @Override
    public int getMove(ReadOnlyBoard board) {
        return 0;
    }
}
