package com.company.army;

import com.company.save.ArmyLocation;

import java.util.stream.IntStream;

public interface Army {
    void move();

    boolean movementIsFinished();

    default void moveTillFinish() {
        while (!movementIsFinished()){
            move();
        }
    }

    default void move(int numberOfSteps) {
        IntStream.rangeClosed(1, numberOfSteps).forEach(x -> move());
    }

    ArmyLocation location();
}
