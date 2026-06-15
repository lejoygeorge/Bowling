package com.bnpp.bowling.service;

public class TenPinScoringService {

    public int calculateScore(String sequence) {
        String cleanSequence = sequence.replaceAll("\\s+", "");
        int[] rolls = parseSequence(cleanSequence);
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[rollIndex] + rolls[rollIndex + 1] == 10) {
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    private int[] parseSequence(String seq) {
        int[] rolls = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            rolls[i] = switch (c) {
                case '/' -> 10 - rolls[i - 1];
                case '-' -> 0;
                default -> Character.getNumericValue(c);
            };
        }
        return rolls;
    }
}
