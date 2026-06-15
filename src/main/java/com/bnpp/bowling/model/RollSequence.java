package com.bnpp.bowling.model;

import java.util.Arrays;

public record RollSequence(int[] rolls) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollSequence that = (RollSequence) o;
        return Arrays.equals(rolls, that.rolls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rolls);
    }

    @Override
    public String toString() {
        return "RollSequence{" +
                "rolls=" + Arrays.toString(rolls) +
                '}';
    }
}