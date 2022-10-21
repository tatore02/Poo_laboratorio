import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void horizontalWinTest() {
        /* TODO */
    }

    @Test
    public void verticalWinTest() {
        /* TODO */
    }

    @Test
    public void firstDiagonalWinTest() {
        /* TODO */
    }

    @Test
    public void secondDiagonalWinTest() {
        /* TODO */
    }

    @Test
    public void AndreaTest() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, TicTacToe.player1);
        game.set(0, 1, TicTacToe.player2);
        game.set(1, 0, TicTacToe.player1);
        game.set(1, 1, TicTacToe.player2);
        game.set(2, 1, TicTacToe.player1);
        Assert.assertEquals("Nessun vincitore", game.getWinner());
    }
}