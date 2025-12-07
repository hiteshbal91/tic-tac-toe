package com.hdb.games.playerstratergy;

import java.util.Scanner;

import com.hdb.games.board.Board;
import com.hdb.games.board.Position;

public class HumanPlayerStratergy implements PlayerStratergy {
  private Scanner scanner = new Scanner(System.in);

  public HumanPlayerStratergy() {
  }

  @Override
  public Position selectPosition(Board board) {
    while (true) {
      try {
        System.out.println("Enter the row and column for the move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        System.out.println("Selected position: " + row + ", " + col);
        Position nextMove = new Position(row, col);

        if (board.isValidMove(nextMove)) {
          return nextMove;
        } else {
          System.out.println("Invalid move, try again");
        }
      } catch (Exception e) {
        System.out.println("Invalid input, try again");
        scanner.nextLine();
      }
    }
  }
}
