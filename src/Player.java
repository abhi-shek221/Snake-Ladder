package SnakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
class Player {
    private final String playerName;
    private final int id;

    public Player(String playerName, int id) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Player ID must be a positive integer.");
        }
        this.playerName = playerName;
        this.id = id;
    }
}
