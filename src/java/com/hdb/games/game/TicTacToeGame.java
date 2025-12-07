package com.hdb.games.game;

import com.hdb.games.board.Board;
import com.hdb.games.board.Position;
import com.hdb.games.player.Player;

public class TicTacToeGame {
  private Player player1;
  private Player player2;
  private Board board;
  private Player currentPlayer;

  public TicTacToeGame(Player player1, Player player2, int size) {
    this.player1 = player1;
    this.player2 = player2;
    this.board = new Board(size);
  }

  public void play() {
    do {
      // printing the current board
      board.printBoard();
      nextPlayer();
      Position nextPosition = currentPlayer.getPlayerStratergy().selectPosition(board);
      board.makeMove(nextPosition, currentPlayer.getSymbol());
      System.out.println("board.makeMove called");
      board.checkGameState(nextPosition, currentPlayer.getSymbol());
      System.out.println("board.checkGameState called"+board.isGameOver());      
      System.out.println("nextPlayer called"+currentPlayer.getName());
    } while (!board.isGameOver());

    printGameResult();
  }

  private void nextPlayer() {
    if (currentPlayer == null) {
      currentPlayer = player1;
    } else {
      currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
  }

  private void printGameResult() {
    if (board.isGameWon()) {
      System.out.println("Game won by " + currentPlayer.getName());
    } else if (board.isGameTied()) {
      System.out.println("Game tied");
    } else {
      System.out.println("Game is still in progress");
    }
  }
}
