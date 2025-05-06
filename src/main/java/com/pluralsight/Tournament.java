package com.pluralsight;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Tournament {
    private String name;
    private List<Team> teams;
    private List<Round> rounds;
    private Team winner;

    Tournament() {
        this.name = new Faker().aviation().aircraft();
        this.teams = new ArrayList<>();
        this.rounds = new ArrayList<>();
    }

    Tournament(String tournamentName) {
        this.name = tournamentName;
        this.teams = new ArrayList<>();
        this.rounds = new ArrayList<>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void startTournament() {
        var currentTeams = new ArrayList<>(teams);

        while (currentTeams.size() > 1) {
            System.out.println("Tournament " + this.name + " starting tournament");

            var matches = new ArrayList<Match>();
            var nextRoundTeams = new ArrayList<Team>();

            // Handle odd number of teams: give one team a bye
            if (currentTeams.size() % 2 != 0) {
                var byeTeam = currentTeams.removeLast();
                System.out.println(byeTeam.getName() + " gets a bye to the next round!");
                nextRoundTeams.add(byeTeam); // auto-advances
            }

            // Create matches in pairs
            for (int i = 0; i < currentTeams.size(); i += 2) {
                matches.add(new Match(currentTeams.get(i), currentTeams.get(i + 1)));
            }

            var round = new Round(matches);
            rounds.add(round);

            // Play the round and get winners
            nextRoundTeams.addAll(round.playRound());

            // Prepare for the next round
            currentTeams = nextRoundTeams;
        }

        // Final winner
        winner = currentTeams.getFirst();
        System.out.println("The winner of the tournament is: " + winner.getName() + "!");
    }

}
