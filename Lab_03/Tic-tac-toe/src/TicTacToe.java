import java.util.Scanner;

public class TicTacToe {

    private final String[][] board;
    static int ROWS = 3;
    static int COLUMNS = 3;
    static String player1 = "x";
    static String player2 = "o";

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            r.append("|");
            for (int j = 0; j < COLUMNS; j++)
                r.append(board[i][j]);
            r.append("|\n");
        }
        return r.toString();
    }

    public void set(int i, int j, String player) {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    public String getWinner() {
        /* TODO */
    }

    public static void main(String[] args) {
        String player = player1;
        TicTacToe game = new TicTacToe();
        Scanner in = new Scanner(System.in);
        int row, column;
        System.out.println(game);

        do {

            if (game.getWinner().equals(player1) || game.getWinner().equals(player2)) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci riga per " + player + " (-1 per uscire):");
            row = in.nextInt();

            if (row == -1) {
                System.out.println("Partita finita");
                System.exit(0);
            }

            System.out.println("Inserisci colonna per " + player + ":");
            column = in.nextInt();

            if (row >= ROWS || column >= COLUMNS) {
                System.out.println("Combinazione non valida");
            } else {
                /* TODO */
            }

        } while (row < ROWS && column < COLUMNS);
    }
}