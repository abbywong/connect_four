package wangcn;

public class Main {
    public static void main(String[] args) throws NotAValidMoveException {
        Board board = new Board(8, 7);
//        Player p1 = new HumanPlayer(new StdinInputController());
        Player p1 = new RandomPlayer("Abby");
        Player p2 = new RandomPlayer("Mark");
        BoardView view = new TextBoardView(new ReadOnlyBoard(board));
        Game game = new Game(board, p1, p2, view);
        Player winner = game.play();
    }
}
