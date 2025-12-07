package com.hdb.games.board;

import com.hdb.games.constant.Symbol;

public class Board {
  private Symbol[][] board;
  private int isGameWon = 0;
  private int isGameTied = 0;

  public Board(int size) {
    this.board = new Symbol[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        this.board[i][j] = Symbol.EMPTY;
      }
    }
  }

  public void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j].toString() + " ");
      }
      System.out.println();
    }
  }

  public boolean isValidMove(Position position) {
    int row = position.getRow();
    int col = position.getCol();
    return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == Symbol.EMPTY;
  }

  public void makeMove(Position position, Symbol symbol) {
    board[position.getRow()][position.getCol()] = symbol;
  }

  public void checkGameState(Position position, Symbol symbol) {
    if (isGameWon(position, symbol)) {
      isGameWon = 1;
    } else if (isGameTied()) {
      isGameTied = 1;
    }
  }

  public boolean isGameWon() {
    return isGameWon == 1;
  }

  public boolean isGameOver() {
    return isGameWon == 1 || isGameTied == 1;
  }


  public boolean isGameTied() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == Symbol.EMPTY) {
          return false;
        } 
      }
    }
    return true;
  }

  public boolean isGameWon(Position position, Symbol symbol) {
    return isGameWonByRow(position, symbol) || isGameWonByColumn(position, symbol) || isGameWonByDiagonal(position, symbol);
  }
  
  public boolean isGameWonByRow(Position position, Symbol symbol) {
    Symbol[] row = board[position.getRow()];
    for (int i = 0; i < row.length; i++) {
      if (row[i] != symbol) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isGameWonByColumn(Position position, Symbol symbol) {
    Symbol[] column = new Symbol[board.length];
    for (int i = 0; i < board.length; i++) {
      column[i] = board[i][position.getCol()];
    }
    for (int i = 0; i < column.length; i++) {
      if (column[i] != symbol) {
        return false;
      }
    }
    return true;
  }

  public boolean isGameWonByDiagonal(Position position, Symbol symbol) {
    Symbol[] diagonal = new Symbol[board.length];
    for (int i = 0; i < board.length; i++) {
      diagonal[i] = board[i][i];
    }
    boolean diagonal1Won = true, diagonal2Won = true;
    for (int i = 0; i < diagonal.length; i++) {
      if (diagonal[i] != symbol) {
        diagonal1Won = false;
        break;
      }
    }
    if (diagonal1Won) {
      return true;
    }
    diagonal = new Symbol[board.length];
    // other side of the diagonal
    for (int i = board.length - 1; i >= 0; i--) {
      diagonal[i] = board[i][board.length - 1 - i];
    }
    for (int i = 0; i < diagonal.length; i++) {
      if (diagonal[i] != symbol) {
        diagonal2Won = false;
        break;
      }
    }
    return diagonal2Won;
  }
}