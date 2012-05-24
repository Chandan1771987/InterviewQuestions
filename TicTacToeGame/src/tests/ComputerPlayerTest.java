package tests;

import com.tictactoe.Board;
import com.tictactoe.ComputerPlayer;
import com.tictactoe.Player;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerPlayerTest {
    String[][] boardArray = new String[3][3];
    Board board = new Board(boardArray,3);
    Player player = new ComputerPlayer();

    @Test
    public void testGetInput() throws Exception {
        Assert.assertNotNull(getInput());
    }

    public String getInput() {
        player.setSymbol('C');
        player.enterInput(board);
        return player.getInput();
    }

    @Test
    public void testEnterInput() throws Exception {
        Assert.assertNotNull(getInput());
    }

    @Test
    public void testGetNextAvailablePosition() throws Exception {
        Assert.assertNotNull(new ComputerPlayer().getNextAvailablePosition(board));
    }

    @Test
    public void testSetSymbol() throws Exception {
        player.setSymbol('C');
        Assert.assertSame('C',player.getSymbol());
    }

    @Test
    public void testGetSymbol() throws Exception {
        player.setSymbol('C');
        Assert.assertSame('C',player.getSymbol());
    }

    @Test
    public void testGetBoardState() throws Exception {
        Assert.assertSame(boardArray, player.getBoardState(board));
    }
}
