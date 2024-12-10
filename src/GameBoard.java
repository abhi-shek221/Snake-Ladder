package SnakeAndLadder;

import java.util.*;

class GameBoard {
    private final Dice dice;
    private final Queue<Player> playersQueue;
    private final List<Jumper> snakes;
    private final List<Jumper> ladders;
    private final Map<String, Integer> playerPositions;
    private final int boardSize;

    public GameBoard(Dice dice, Queue<Player> playersQueue, List<Jumper> snakes, List<Jumper> ladders,
                     Map<String, Integer> playerPositions, int boardSize) {
        this.dice = dice;
        this.playersQueue = playersQueue;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerPositions = playerPositions;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while (playersQueue.size() > 1) {
            Player currentPlayer = playersQueue.poll();
            int currentPosition = playerPositions.get(currentPlayer.getPlayerName());

            // Roll 
            int diceValue = dice.rollDice();
            System.out.println(currentPlayer.getPlayerName() + " rolled a " + diceValue);

            int nextPosition = currentPosition + diceValue;

            //  player > the board size
            if (nextPosition > boardSize) {
                System.out.println(currentPlayer.getPlayerName() + " exceeded the board size and stays at position " + currentPosition);
                playersQueue.offer(currentPlayer);
                continue;
            }

            
            nextPosition = processJumpers(nextPosition);

            // win
            if (nextPosition == boardSize) {
                System.out.println(currentPlayer.getPlayerName() + " reached position " + boardSize + " and won the game!");
                return; 
            }

            // update
            playerPositions.put(currentPlayer.getPlayerName(), nextPosition);
            System.out.println(currentPlayer.getPlayerName() + " is now at position " + nextPosition);
            playersQueue.offer(currentPlayer);
        }
    }

    private int processJumpers(int position) {
        for (Jumper snake : snakes) {
            if (snake.getStartPoint() == position) {
                System.out.println("Oh no! Bitten by a snake. Sliding down from " + position + " to " + snake.getEndPoint());
                return snake.getEndPoint();
            }
        }
        for (Jumper ladder : ladders) {
            if (ladder.getStartPoint() == position) {
                System.out.println("Yay! Climbed a ladder from " + position + " to " + ladder.getEndPoint());
                return ladder.getEndPoint();
            }
        }
        return position;
    }
}
