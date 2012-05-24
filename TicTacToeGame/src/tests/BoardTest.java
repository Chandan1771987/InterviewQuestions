package tests;

import com.tictactoe.Board;
import com.tictactoe.ComputerPlayer;
import com.tictactoe.Player;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardTest {

    @Test
    public void testGetBoardArray() throws Exception {
        String[][] boardArray = new String[3][3];
        Board board = new Board(boardArray,3);
        Assert.assertEquals(boardArray, board.getBoardArray());
    }

    @Test
    public void testAcceptInput() throws Exception {
        String[][] boardArray = new String[3][3];
        Player player = new ComputerPlayer();
        player.setSymbol('X');
        Board board = new Board(boardArray,3);
        board.acceptInput(boardArray, player);
        Assert.assertEquals(boardArray, board.getBoardArray());

    }
}
