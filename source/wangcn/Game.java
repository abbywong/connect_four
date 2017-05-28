package wangcn;

import java.util.Random;

public class Game {
    private Board board;
    private Player alice;
    private Player activePlayer;
    private Player bob;
    private BoardView view;
    private ReadOnlyBoard readOnlyBoard;
    private Cell activeColor;

    public Game(Board board, Player alice, Player bob, BoardView view) {
        this.board = board;
        this.alice = alice;
        this.bob = bob;
        this.view = view;
    }

    /*
     * @return: The winning player, or null for a tie.
     */
    public Player play() throws NotAValidMoveException {
        this.initialize();
        while (true) {
            this.turn();
            this.view.update();
            this.swapActivePlayer();
            Player winner = this.getWinnerIfOver();
            if (this.isBoardFull()) {
                System.out.println("It is a draw, no winner!");
                return null;
            }
            if (winner != null) {
                System.out.printf("%s won!\n", winner.getName());
                return winner;
            }

        }
    }

    private void swapActivePlayer() {
        if (activePlayer == alice) {
            activePlayer = bob;
            activeColor = Cell.COLOR2;
        } else {
            activePlayer = alice;
            activeColor = Cell.COLOR1;
        }
    }

    private void initialize() {
        Random random = new Random();
        int playerNr = random.nextInt(2);
        if (playerNr == 1) {
            activePlayer = alice;
            activeColor = Cell.COLOR1;
        } else {
            activePlayer = bob;
            activeColor = Cell.COLOR2;
        }
    }

    private void turn() throws NotAValidMoveException {
        //ReadOnlyBoard readOnlyBoard = this.readOnlyBoard;
        int colInto = activePlayer.getMove(readOnlyBoard);
        board.drop(colInto, activeColor);
    }

    public Player getWinnerIfOver() {
        return null; //todo
    }

    public boolean isBoardFull() {
        return board.isFull();
    }
}
