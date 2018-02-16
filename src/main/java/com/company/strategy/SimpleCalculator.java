package com.company.strategy;

import static java.lang.Math.abs;

public class SimpleCalculator implements Calculator {
    @Override
    public int thisDistanceToFinish(Point from, Point finish) {
        return (abs(from.getKey() - finish.getKey()) + abs(from.getValue() - finish.getValue()));
    }
}
