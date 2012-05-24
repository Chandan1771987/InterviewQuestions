package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
        private int mode;
        private int numberOfMoves;
        private List<Player> players;
        private boolean isDraw;
        private String gameWinner;
        private String[][] boardArray;
        private Board board;
        private int boardSize;
    public void setBoardArray(String[][] boardArray) {
        this.boardArray = boardArray;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int n) {
        this.boardSize = n;
    }

    public void setMode(int mode) {
        this.mode = mode;
        players = choosePlayersBasedOnMode();
    }

    public int getMode() {
        return mode;
    }


    public List<Player> choosePlayersBasedOnMode() {
        Player playerOne;
        Player playerTwo;
        List<Player> players = new ArrayList<Player>();
        if (getMode() == 1) {
            System.out.println("Mode 1 is selected ");
            playerOne = new HumanPlayer();
            playerOne.setSymbol('X');
            playerTwo = new HumanPlayer();
            playerTwo.setSymbol('O');
        } else if (getMode() == 2) {

            System.out.println("Mode 2 is selected ");
            playerOne = new HumanPlayer();
            playerOne.setSymbol('X');
            playerTwo = new ComputerPlayer();
            playerTwo.setSymbol('O');
        } else {
            System.out.println("Mode 3 is selected ");
            playerOne = new ComputerPlayer();
            playerOne.setSymbol('X');
            playerTwo = new ComputerPlayer();
            playerTwo.setSymbol('O');
        }

        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String[][] getBoardArray() {
        return board.getBoardArray();
    }

    public TicTacToeGame(int boardSize) {
        setBoardSize(boardSize);
        boardArray = new String[getBoardSize()][getBoardSize()];
        board = new Board(boardArray, getBoardSize());
        numberOfMoves = 0;
        isDraw = false;
        gameWinner = "";
    }

    public int getTotalMoves() {
        return numberOfMoves;
    }

    public void setTotalMoves() {
        numberOfMoves++;
    }

    public void setWinner(String winner) {
        this.gameWinner = winner;
    }

    public String getWinner() {
        return gameWinner;
    }

    public void acceptInput(Player player) {
        board.acceptInput(boardArray, player);
        setTotalMoves();
    }

    public void setMatchDrawn(boolean isDraw) {
        this.isDraw = isDraw;
    }

    public boolean getMatchDrawnStatus() {
        return isDraw;
    }

    public boolean checkForDiagonalStrike(String input) {
        int i;
        for (i = 0; i < getBoardSize(); i++) {
            if (boardArray[i][i].equalsIgnoreCase(input)) {
                continue;
            }
            break;
        }
        if (i == getBoardSize()){
            setWinner(input);
            return true;
        }

        for (i = 0; i < getBoardSize(); i++) {
            if (boardArray[i][getBoardSize() - i - 1].equalsIgnoreCase(input)) {
                continue;
            }
            break;
        }

        if(i == getBoardSize()){
            setWinner(input);
            return true;
        }

        return false;
    }

    public boolean checkForHorizontalStrike(String input) {
        for (int i = 0; i < boardSize; i++) {
            int count = 0;
            for (int j = 0; j < boardSize; j++, count++) {
                if (boardArray[i][j].equalsIgnoreCase(input)) {
                    continue;
                }
                break;
            }
            if (count == boardSize){
                setWinner(input);
                return true;
            }
        }
        return false;
    }


    public boolean checkForVerticalStrike(String input) {
        for (int i = 0; i < boardSize; i++) {
            int count=0;
            for (int j = 0; j < boardSize; j++,count++) {
                if (boardArray[j][i].equalsIgnoreCase(input)) {
                    continue;
                }
                break;
            }
            if(count==boardSize){
                setWinner(input);
                return true;
            }
        }
        return false;
    }

    public void displayGameState() {
        System.out.println("*************** Current Game State *****************");
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                System.out.print(boardArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isGameOver() {
        String symbolOne = String.valueOf(players.get(0).getSymbol());
        String symbolTwo = String.valueOf(players.get(1).getSymbol());

        if (checkForDiagonalStrike(symbolOne) || checkForDiagonalStrike(symbolTwo) || checkForHorizontalStrike(symbolOne) || checkForHorizontalStrike(symbolTwo) ||
                checkForVerticalStrike(symbolOne) || checkForVerticalStrike(symbolTwo)) {
            return true;
        } else if (getTotalMoves() == (getBoardSize() * getBoardSize())) {
            setMatchDrawn(true);
            return true;
        }
        return false;
    }
}
