package com.company.strategy;

import javafx.util.Pair;

public interface Strategy {
    Pair<Pair<Point, Point>, Integer> generateOptimalPointAndFasterWay();

    int distanceToFinish(Point from, Point finish);
}
