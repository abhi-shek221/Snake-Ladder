package SnakeAndLadder;

import java.util.*;

public class PlaySnakeAndLadder {
    public static void main(String[] args) {
        
        Dice dice = new Dice(1);

        // Initialize 
        Queue<Player> playersQueue = new LinkedList<>();
        playersQueue.offer(new Player("Alberts", 1));
        playersQueue.offer(new Player("Pintoss", 2));

        
        List<Jumper> snakes = Arrays.asList(
            new Jumper(10, 2),
            new Jumper(99, 12),
            new Jumper(25, 5)
        );

        
        List<Jumper> ladders = Arrays.asList(
            new Jumper(3, 22),
            new Jumper(15, 44),
            new Jumper(40, 89)
        );

       
        Map<String, Integer> playerPositions = new HashMap<>();
        for (Player player : playersQueue) {
            playerPositions.put(player.getPlayerName(), 0);
        }

        
        GameBoard gameBoard = new GameBoard(dice, playersQueue, snakes, ladders, playerPositions, 100);

        
        gameBoard.startGame();
    }
}
