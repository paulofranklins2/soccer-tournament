package com.pluralsight;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Team {
    private String name;
    private List<Player> players;

    Team(String name) {
        this.name = name;
        this.players = generateAutoList();
    }

    Team(){
        this.name = new Faker().country().name();
        this.players = generateAutoList();
    }

    private List<Player> generateAutoList() {
        var players = new ArrayList<Player>();
        var faker = new Faker();

        for (int i = 0; i < 11; i++) {
            players.add(new Player(faker.name().lastName()));
        }
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public String toString() {
        return String.format("Team{name='%s', Players=%s}", name, players);
    }

}
