package com.pluralsight;


public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        Tournament tournament = new Tournament();

        for (int i = 0; i < 21; i++) {
            tournament.addTeam(new Team());
        }
        tournament.startTournament();
    }
}