package com.tictactoe;

import java.util.Scanner;



public class ComputerPlayer implements Player{
    private String input;
    private Character symbol;
    private String[][] boardArray;
    Scanner scanner;
    public ComputerPlayer(){
        scanner= new Scanner(System.in);
    }

    @Override
    public String getInput() {
        System.out.println("Computer chose "+input.split(" ")[0]+"  and  "+input.split(" ")[1]);
        return input;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void enterInput(Board board) {
        int[] indices = getNextAvailablePosition(board);
        input=String.valueOf(indices[0]+" "+indices[1]);
    }

    public int[] getNextAvailablePosition(Board board){
        boardArray=getBoardState(board);
        for(int i=0;i<board.getBoardSize();i++){
            for(int j=0;j<board.getBoardSize();j++) {
                if(boardArray[i][j]=="-")
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }

    @Override
    public void setSymbol(char symbol) {
        this.symbol=symbol;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    public String[][] getBoardState(Board board) {
        return board.getBoardArray();  //To change body of implemented methods use File | Settings | File Templates.
    }
}