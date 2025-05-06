package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final List<Match> matches;

    public List<Team> playRound() {
        List<Team> winners = new ArrayList<Team>();
        System.out.println("=== Starting Round ===");
        for (Match match : matches) {
            winners.add(match.play());
        }
        System.out.println("=== Round Complete ===\n");
        return winners;
    }

    Round(List<Match> matches){
        this.matches = matches;
    }
}
