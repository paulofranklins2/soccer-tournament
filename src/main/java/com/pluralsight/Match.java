package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private Team team1;
    private Team team2;

    public Team play() {
        var winner = new Random().nextBoolean() ? team1 : team2;
        System.out.printf("Match: %s vs %s — Winner: %s%n", team1.getName(), team2.getName(), winner.getName());
        return winner;
    }

    @Override
    public String toString() {
        return String.format("Match: %s vs %s", team1.getName(), team2.getName());
    }
}
