package com.tictactoe;

public interface Player {

    public String getInput();
    public void enterInput(Board board);
    public void setSymbol(char symbol);
    public char getSymbol();
    public String[][] getBoardState(Board board);

}
