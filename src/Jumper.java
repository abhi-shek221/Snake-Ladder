package SnakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Jumper {
    int startPoint;
    int endPoint;

    public Jumper(int startPoint, int endPoint) {
        if (startPoint <= 0 || endPoint <= 0) {
            throw new IllegalArgumentException("Points must be positive integers.");
        }
        if (startPoint == endPoint) {
            throw new IllegalArgumentException("Start point and end point cannot be the same.");
        }
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}