# Tic-Tac-Toe

A Tic-Tac-Toe game with design pattern implementation in Java.

## Prerequisites

- Java JDK 8 or higher

Verify installation:
```bash
java -version
javac -version
```

## Project Structure

```
src/java/com/hdb/games/
├── Main.java                 # Entry point
├── board/
│   ├── Board.java            # Game board logic
│   └── Position.java         # Board position
├── constant/
│   └── Symbol.java           # X, O, EMPTY symbols
├── game/
│   ├── TicTacToeGame.java    # Game flow controller
│   └── GameContext.java
├── player/
│   └── Player.java           # Player model
└── playerstratergy/
    ├── PlayerStratergy.java  # Strategy interface
    └── HumanPlayerStratergy.java
```

## How to Run

### 1. Navigate to source directory

```bash
cd src/java
```

### 2. Compile

```bash
javac com/hdb/games/Main.java
```

### 3. Run

```bash
java com.hdb.games.Main
```

## How to Play

1. The game displays a 3x3 board
2. Players take turns entering row and column numbers (0-2)
3. Player 1 uses **X**, Player 2 uses **O**
4. First player to get 3 in a row (horizontal, vertical, or diagonal) wins

### Example Input

```
Enter the row and column for the move
0
1
```

This places your symbol at row 0, column 1.

## License

See [LICENSE](LICENSE) file.
