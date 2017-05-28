package wangcn;

import java.util.Random;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;
    private Player activePlayer;
    private BoardView view;
    private ReadOnlyBoard readOnlyBoard;
    private Cell activeColor;

    public Game(Board board, Player p1, Player p2, BoardView view) {
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.view = view;
        this.readOnlyBoard = new ReadOnlyBoard(board);
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
        if (activePlayer == p1) {
            activePlayer = p2;
            activeColor = Cell.COLOR2;
        } else {
            activePlayer = p1;
            activeColor = Cell.COLOR1;
        }
    }

    private void initialize() {
        Random random = new Random();
        int playerNr = random.nextInt(2);
        if (playerNr == 1) {
            activePlayer = p1;
            activeColor = Cell.COLOR1;
        } else {
            activePlayer = p2;
            activeColor = Cell.COLOR2;
        }
    }

    private void turn() throws NotAValidMoveException {
        //ReadOnlyBoard readOnlyBoard = this.readOnlyBoard;
        int colInto = activePlayer.getMove(readOnlyBoard);
        board.drop(colInto, activeColor);
    }

    public Player getWinnerIfOver() {
        Player winner;
        winner = gameWinnerIfOverHorizontal();
        if (winner != null) return winner;
        winner = gameWinnerIfOverVertical();
        if (winner != null) return winner;
        winner = gameWinnerIfOverDiagonalSlash();
        if (winner != null) return winner;
        winner = gameWinnerIfOverDiagonalBackSlash();
        if (winner != null) return winner;
        return null;
    }

    private Player gameWinnerIfOverHorizontal() {
        for (int x = 0; x < this.board.height; x++) {
            for (int y = 0; y < this.board.width - 3; y++) {
                if (this.board.read(x, y) != Cell.EMPTY &&
                        this.board.read(x, y) == this.board.read(x, y + 1) &&
                        this.board.read(x, y + 1) == this.board.read(x, y + 2) &&
                        this.board.read(x, y + 2) == this.board.read(x, y + 3))
                {
                    if (this.board.read(x, y) == Cell.COLOR1) {
                        return p1;
                    } else {
                        return p2;
                    }
                }
            }
        }
        return null;
    }

    private Player gameWinnerIfOverVertical() {
        for (int y = 0; y < this.board.width; y++) {
            for (int x = 0; x < this.board.height - 3; x++) {
                if (this.board.read(x, y) != Cell.EMPTY &&
                        this.board.read(x, y) == this.board.read(x +1, y) &&
                        this.board.read(x+1, y ) == this.board.read(x+2, y ) &&
                        this.board.read(x+2, y ) == this.board.read(x+3, y ))
                {
                    if (this.board.read(x, y) == Cell.COLOR1) {
                        return p1;
                    } else {
                        return p2;
                    }
                }
            }
        }
        return null;
    }

    private Player gameWinnerIfOverDiagonalSlash() {
        for (int y = 0; y < this.board.width-3; y++) {
            for (int x = this.board.height-1; x >= 3; x--) {
                if (this.board.read(x, y) != Cell.EMPTY &&
                        this.board.read(x, y) == this.board.read(x -1, y+1) &&
                        this.board.read(x-1, y+1 ) == this.board.read(x-2, y+2 ) &&
                        this.board.read(x-2, y+2 ) == this.board.read(x-3, y+3 ))
                {
                    if (this.board.read(x, y) == Cell.COLOR1) {
                        return p1;
                    } else {
                        return p2;
                    }
                }
            }
        }
        return null;
    }
    private Player gameWinnerIfOverDiagonalBackSlash() {
        for (int y = 0; y < this.board.width-3; y++) {
            for (int x = 0; x < this.board.height - 3; x++) {
                if (this.board.read(x, y) != Cell.EMPTY &&
                        this.board.read(x, y) == this.board.read(x +1, y+1) &&
                        this.board.read(x+1, y+1 ) == this.board.read(x+2, y+2 ) &&
                        this.board.read(x+2, y+2 ) == this.board.read(x+3, y+3 ))
                {
                    if (this.board.read(x, y) == Cell.COLOR1) {
                        return p1;
                    } else {
                        return p2;
                    }
                }
            }
        }
        return null;
    }
    public boolean isBoardFull() {
        return board.isFull();
    }
}
