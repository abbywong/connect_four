package wangcn;

public class Game {
    Board board;
    Player alice;
    Player bob;
    BoardView view;

    public Game(Board board, Player alice, Player bob, BoardView view) {
        this.board = board;
        this.alice = alice;
        this.bob = bob;
        this.view = view;
    }

    /*
     * @return: The winning player, or null for a tie.
     */
    public Player play() {
        this.initialize();
        while (true) {
            this.turn();
            // todo: switch turn to other player
            Player winner = this.getWinnerIfOver();
            if (winner != null) {
                return winner;
            }
            if (this.isBoardFull()) {
                return null;
            }
        }
    }

    private void initialize() {
        //todo;
    }

    private void turn() {
        //todo
    }

    public Player getWinnerIfOver() {
        return null; //todo
    }

    public boolean isBoardFull() {
        return false; // todo
    }
}
