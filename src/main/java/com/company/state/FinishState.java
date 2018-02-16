package com.company.state;

import com.company.fieldClasses.Field;
import com.company.save.ArmyLocation;
import com.company.strategy.Point;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FinishState implements State {
    private Field field;
    private List<Point> myPath;
    private final String movingState = "hasCome";

    @Override
    public State moveToTheNextState() {
        return new FinishState(field, myPath);
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public ArmyLocation savedData() {
        return new ArmyLocation(myPath, movingState);
    }
}
