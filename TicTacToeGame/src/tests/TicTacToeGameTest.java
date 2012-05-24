package tests;

import com.tictactoe.Player;
import com.tictactoe.TicTacToeGame;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TicTacToeGameTest {
    TicTacToeGame ticTacToeGame = new TicTacToeGame(3);
    String[][] boardArray = new String[3][3];
    @Test
    public void testSetMode() throws Exception {
        ticTacToeGame.setMode(1);
        Assert.assertSame(1, ticTacToeGame.getMode());
    }

    @Test
    public void testGetMode() throws Exception {
        ticTacToeGame.setMode(0);
        Assert.assertSame(0,ticTacToeGame.getMode());
    }

    @Test
    public void testGetPlayers() throws Exception {
        ticTacToeGame.setMode(1);
        List<Player> players = ticTacToeGame.getPlayers();
        Assert.assertEquals('X',players.get(0).getSymbol());
        Assert.assertEquals('O',players.get(1).getSymbol());
    }

    @Test
    public void testGetTotalMoves() throws Exception {
        Assert.assertNotNull(ticTacToeGame.getTotalMoves());
    }

    @Test
    public void testSetTotalMoves() throws Exception {
        Assert.assertNotNull(ticTacToeGame.getTotalMoves());
    }

    @Test
    public void testSetWinner() throws Exception {
        ticTacToeGame.setWinner(String.valueOf('H'));
        Assert.assertEquals(String.valueOf('H'),ticTacToeGame.getWinner());
    }

    @Test
    public void testGetWinner() throws Exception {
        ticTacToeGame.setWinner(String.valueOf('H'));
        Assert.assertEquals(String.valueOf('H'),ticTacToeGame.getWinner());
    }

    @Test
    public void testSetUserChoice() throws Exception {
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertSame(boardArray[2][2],ticTacToeGame.getBoardArray()[2][2]);
    }

    @Test
    public void testSetMatchDrawn() throws Exception {
        ticTacToeGame.setMatchDrawn(true);
        Assert.assertEquals(true,ticTacToeGame.getMatchDrawnStatus());
    }

    @Test
    public void testGetMatchDrawnStatus() throws Exception {
        ticTacToeGame.setMatchDrawn(true);
        Assert.assertEquals(true,ticTacToeGame.getMatchDrawnStatus());
    }

    @Test
    public void testCheckForDiagonalStrike() throws Exception {
        boardArray = new String[][]{{"H", "-", "-"},{"-","H","-"},{"-","-","H"}};
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertEquals(true,ticTacToeGame.checkForDiagonalStrike("H"));
    }

    @Test
    public void testCheckForHorizontalStrike() throws Exception {
        boardArray = new String[][]{{"H", "H", "H"},{"-","-","-"},{"-","-","-"}};;
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertEquals(true,ticTacToeGame.checkForHorizontalStrike("H"));
    }

    @Test
    public void testCheckForVerticalStrike() throws Exception {
        boardArray = new String[][]{{"H", "-", "-"},{"H","-","-"},{"H","-","-"}};
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertEquals(true,ticTacToeGame.checkForVerticalStrike("H"));
    }

    @Test
    public void testDisplayGameState() throws Exception {
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertSame(boardArray[2][2],ticTacToeGame.getBoardArray()[2][2]);
    }

    @Test
    public void testIsGameOver() throws Exception {
        ticTacToeGame.setMode(0);
        char symbol = ticTacToeGame.getPlayers().get(0).getSymbol();
        boardArray = new String[][]{{String.valueOf(symbol), String.valueOf(symbol), String.valueOf(symbol)},{"H","-","-"},{"H","-","-"}};
        ticTacToeGame.setBoardArray(boardArray);
        Assert.assertEquals(true,ticTacToeGame.isGameOver());
    }
}
