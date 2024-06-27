package com.torneo.futbol.model;

public enum Position {
    GOALKEEPER(0),
    DEFENDER(1),
    MIDFIELDER(3),
    FORWARD(5);

    private final int multiplier;

    Position(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}