package com.bnpp.bowling.calculator;

import com.bnpp.bowling.model.RollSequence;
import org.springframework.stereotype.Component;

import static com.bnpp.bowling.constants.BowlingConstants.*;

@Component
public class TenPinScoreCalculator implements ScoreCalculator {

    @Override
    public int calculate(RollSequence sequence) {
        var rolls = sequence.rolls();
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < FRAMESIZE; frame++) {
            if (isStrike(rolls, rollIndex)) {
                score += MAXPOINT + strikeBonus(rolls, rollIndex);
                rollIndex++;
            } else if (isSpare(rolls, rollIndex)) {
                score += MAXPOINT + spareBonus(rolls, rollIndex);
                rollIndex += TWOROLL;
            } else {
                score += sumOfPinsInFrame(rolls, rollIndex);
                rollIndex += TWOROLL;
            }
        }
        return score;
    }

    private boolean isStrike(int[] rolls, int rollIndex) {
        return rolls[rollIndex] == MAXPOINT;
    }

    private boolean isSpare(int[] rolls, int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + ONEROLL] == MAXPOINT;
    }

    private int strikeBonus(int[] rolls, int rollIndex) {
        return rolls[rollIndex + ONEROLL] + rolls[rollIndex + TWOROLL];
    }

    private int spareBonus(int[] rolls, int rollIndex) {
        return rolls[rollIndex + TWOROLL];
    }

    private int sumOfPinsInFrame(int[] rolls, int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + ONEROLL];
    }
}
