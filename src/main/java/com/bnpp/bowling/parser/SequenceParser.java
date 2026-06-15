package com.bnpp.bowling.parser;

import com.bnpp.bowling.model.RollSequence;

public interface SequenceParser {
    RollSequence parse(String sequence);
}
