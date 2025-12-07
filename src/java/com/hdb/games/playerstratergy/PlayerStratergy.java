package com.hdb.games.playerstratergy;

import com.hdb.games.board.Board;
import com.hdb.games.board.Position;

public interface PlayerStratergy {
  Position selectPosition(Board board);
}