package com.company.strategy;

import javafx.util.Pair;

import static java.lang.Math.abs;

public class Point extends Pair<Integer, Integer> {
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public Point(Integer key, Integer value) {
        super(key, value);
    }

    public int dx(Point x) {
        return abs(this.getKey() - x.getKey());
    }

    public int dy(Point x) {
        return abs(this.getValue() - x.getValue());
    }
}
