package tests;

import com.tictactoe.Board;
import com.tictactoe.HumanPlayer;
import com.tictactoe.Player;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HumanPlayerTest {
    String[][] boardArray = new String[3][3];
    Board board = new Board(boardArray,3);
    Player player = new HumanPlayer();

    @Test
    public void testGetBoardState() throws Exception {
        Assert.assertSame(board.getBoardArray(), player.getBoardState(board));
    }

    @Test
    public void testGetInput() throws Exception {
        boardArray[0][2] = String.valueOf('H');
        Assert.assertSame(boardArray, board.getBoardArray());
    }


    @Test
    public void testEnterInput() throws Exception {
        boardArray[0][2] = String.valueOf('H');
        Assert.assertSame(boardArray, board.getBoardArray());
    }

    @Test
    public void testSetSymbol() throws Exception {
        player.setSymbol('H');
        Assert.assertSame('H', player.getSymbol());
    }

    @Test
    public void testGetSymbol() throws Exception {
        player.setSymbol('H');
        Assert.assertSame('H', player.getSymbol());
    }
}
