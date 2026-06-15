package com.bnpp.bowling.service;

import com.bnpp.bowling.calculator.ScoreCalculator;
import com.bnpp.bowling.parser.SequenceParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenPinScoringService implements BowlingScoringService {

    private final SequenceParser parser;
    private final ScoreCalculator calculator;

    @Override
    public int calculateScore(String sequence) {
        var parsedSequence = parser.parse(sequence);
        return calculator.calculate(parsedSequence);
    }
}