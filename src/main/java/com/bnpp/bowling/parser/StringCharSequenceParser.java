package com.bnpp.bowling.parser;

import com.bnpp.bowling.model.RollSequence;
import org.springframework.stereotype.Component;

import static com.bnpp.bowling.constants.BowlingConstants.*;

@Component
public class StringCharSequenceParser implements SequenceParser {

    @Override
    public RollSequence parse(String sequence) {
        var cleanSequence = sequence.replaceAll("\\s+", "");
        var rolls = new int[cleanSequence.length()];

        for (int i = 0; i < cleanSequence.length(); i++) {
            char c = cleanSequence.charAt(i);
            rolls[i] = switch (c) {
                case 'X', 'x' -> MAXPOINT;
                case '/' -> MAXPOINT - rolls[i - ONEROLL];
                case '-' -> MINPOINT;
                default -> Character.getNumericValue(c);
            };
        }
        return new RollSequence(rolls);
    }
}