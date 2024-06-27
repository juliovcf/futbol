package com.torneo.futbol.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private List<Player> players;

    private int quality;
    private int attackQuality;
    private int defenseQuality;
    private int midfieldQuality;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        calculateQualities();
    }

    private void calculateQualities() {
        int totalQuality = 0;
        int totalAttackQuality = 0;
        int totalDefenseQuality = 0;
        int totalMidfieldQuality = 0;

        for (Player player : players) {
            totalQuality += player.getQuality();
            switch (player.getPosition()) {
                case FORWARD:
                    totalAttackQuality += player.getQuality();
                    break;
                case MIDFIELDER:
                    totalMidfieldQuality += player.getQuality();
                    break;
                case DEFENDER:
                case GOALKEEPER:
                        totalDefenseQuality += player.getQuality();
                        break;
            }
        }

        this.quality = totalQuality;
        this.attackQuality = totalAttackQuality;
        this.defenseQuality = totalDefenseQuality;
        this.midfieldQuality = totalMidfieldQuality;
    }
}