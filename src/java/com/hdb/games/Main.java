package com.hdb.games;

import com.hdb.games.constant.Symbol;
import com.hdb.games.game.TicTacToeGame;
import com.hdb.games.player.Player;
import com.hdb.games.playerstratergy.HumanPlayerStratergy;

class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", Symbol.X, new HumanPlayerStratergy());
        Player player2 = new Player("Player 2", Symbol.O, new HumanPlayerStratergy());
        TicTacToeGame game = new TicTacToeGame(player1, player2, 3);
        game.play();
    }
}