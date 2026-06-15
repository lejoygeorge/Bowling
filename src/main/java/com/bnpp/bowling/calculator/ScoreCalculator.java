package com.bnpp.bowling.calculator;

import com.bnpp.bowling.model.RollSequence;

public interface ScoreCalculator {
    int calculate(RollSequence sequence);
}
