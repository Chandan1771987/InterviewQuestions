package com.tictactoe;

import java.util.Scanner;


public class HumanPlayer implements Player {
    private char symbol;
    private Scanner scanner;
    private String[][] boardArray;
    private String input;

    public HumanPlayer() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String[][] getBoardState(Board board) {
        return board.getBoardArray();
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public void enterInput(Board board) {
        input = scanner.nextLine();
        boardArray = getBoardState(board);
        int x = 0, y = 0;
        while (true) {
            if(input.length()!=3)   {
                System.out.println("The board Position is already occupied or it is invalid . Please enter an another position");
                input = scanner.nextLine();
                continue;
            }
            x = Integer.parseInt(input.split(" ")[0]);
            y = Integer.parseInt(input.split(" ")[1]);
            if (x > board.getBoardSize()-1 || x < 0 || y > board.getBoardSize()-1 || y < 0 || boardArray[x][y] != "-") {
                System.out.println("The board Position is already occupied or it is invalid . Please enter an another position");
                input = scanner.nextLine();
                continue;
            }
            break;
        }
        System.out.println("You chose "+x+"   and  "+y);
    }

    @Override
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

