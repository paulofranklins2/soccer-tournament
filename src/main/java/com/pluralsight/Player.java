package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private String position;
    private int number;

    private static final String[] POSITIONS = {
            "GOALKEEPER", "DEFENDER", "MIDFIELDER", "FORWARD"
    };

    Player(String name) {
        this.name = name;
        this.number = (int) (Math.random() * 100);
        this.position = POSITIONS[new Random().nextInt(POSITIONS.length)];
    }

    @Override
    public String toString() {
        return String.format("#%s - %d (%s)", name, number, position);
    }
}
