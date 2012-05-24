package com.tictactoe;

import java.util.Scanner;


public class GameController {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.playGame();
    }

    public void getNextTurn(TicTacToeGame ticTacToeGame) {
        ticTacToeGame.acceptInput(ticTacToeGame.getPlayers().get(ticTacToeGame.getTotalMoves() % 2));
    }

    public void playGame() {
        System.out.println("Please enter the boardSize you will be needing. It should be atleast 3 ");
        int boardSize;
        while (true) {
            try{
            boardSize = Integer.parseInt(scanner.nextLine());
                if(boardSize<3){
                    System.out.println(" The boardSize should be atleast 3. Please enter the appropriate size ");
                    continue;
                }
            }
            catch(NumberFormatException exception){
                System.out.println("Please enter a valid number greater than or equal to 3");
                continue;
            }
            break;
        }
        System.out.println("The boardSize you have entered is : "+boardSize);
        TicTacToeGame ticTacToeGame = new TicTacToeGame(boardSize);
        System.out.println("Please enter the Mode you want to Opt for :");
        System.out.println("Enter 1. Between Human-Human *********************");
        System.out.println("Enter 2. Between Human-Computer ******************");
        System.out.println("Enter 3. Between Computer-Computer ***************");
        ticTacToeGame.setMode(Integer.parseInt(scanner.nextLine()));

        while (!ticTacToeGame.isGameOver()) {
            getNextTurn(ticTacToeGame);
            ticTacToeGame.displayGameState();
        }
        if (ticTacToeGame.getMatchDrawnStatus())
            System.out.println("Match is drawn");
        else
            System.out.println("Winner is :" + ticTacToeGame.getWinner());
    }


}

