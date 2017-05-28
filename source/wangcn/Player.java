package wangcn;

public interface Player {
    public String getName();

    /*
     * @return: the number of the column.
     */
    public int getMove(ReadOnlyBoard board);
}
