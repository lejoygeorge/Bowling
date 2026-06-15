package com.bnpp.bowling.calculator;

import com.bnpp.bowling.model.RollSequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TenPinScoreCalculatorTest {

    private TenPinScoreCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TenPinScoreCalculator();
    }

    @Test
    @DisplayName("Gutter game should score 0")
    void calculate_GutterGame_ReturnsZero() {
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        RollSequence sequence = new RollSequence(rolls);

        int score = calculator.calculate(sequence);

        assertEquals(0, score);
    }

    @Test
    @DisplayName("All ones should score 20")
    void calculate_AllOnes_ReturnsTwenty() {
        int[] rolls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        RollSequence sequence = new RollSequence(rolls);
        int score = calculator.calculate(sequence);
        assertEquals(20, score);
    }

    @ParameterizedTest(name = "{index} => Game Type: {0}, Expected Score: {1}")
    @MethodSource("provideBowlingGames")
    @DisplayName("Calculate score for special bowling sequences (Spares and Strikes)")
    void calculate_WithSparesAndStrikes_ReturnsExpectedScore(String description, int expectedScore, int[] rolls) {
        RollSequence sequence = new RollSequence(rolls);
        int actualScore = calculator.calculate(sequence);
        assertEquals(expectedScore, actualScore, "Failed for scenario: " + description);
    }

    private static Stream<Arguments> provideBowlingGames() {
        return Stream.of(
                Arguments.of(
                        "One Spare then misses",
                        16,
                        new int[]{5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                ),
                Arguments.of(
                        "One Strike then misses",
                        24,
                        new int[]{10, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                ),
                Arguments.of(
                        "Perfect Game (All Strikes)",
                        300,
                        new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
                ),
                Arguments.of(
                        "All Spares with a final 5",
                        150,
                        new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
                ),
                Arguments.of(
                        "Pairs of 9 and miss",
                        90,
                        new int[]{9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0}
                )
        );
    }
}