package com.hdb.games.player;

import com.hdb.games.constant.Symbol;
import com.hdb.games.playerstratergy.PlayerStratergy;

public class Player {
  private String name;
  private Symbol symbol;
  private PlayerStratergy playerStratergy;

  public Player(String name, Symbol symbol, PlayerStratergy playerStratergy) {
    this.name = name;
    this.symbol = symbol;
    this.playerStratergy = playerStratergy;
  }

  public String getName() {
    return name;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  public PlayerStratergy getPlayerStratergy() {
    System.out.println("It's your turn '"+getName()+"' to play");
    return playerStratergy;
  }
}
