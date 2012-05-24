package com.tictactoe;



public  class Board{
    private String[][] boardArray;
    private int boardSize;

    public Board(String[][] board, int size) {
        this.boardSize=size;
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j]="-";
            }
        }
        this.boardArray = board;
    }

    public String[][] getBoardArray(){
        return boardArray;
    }

    public void acceptInput(String[][] board,Player player) {
        player.enterInput(this);
        String[] input = player.getInput().split(" ");
        board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = String.valueOf(player.getSymbol());
        this.boardArray = board;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
