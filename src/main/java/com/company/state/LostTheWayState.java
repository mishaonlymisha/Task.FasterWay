package com.company.state;

import com.company.fieldClasses.Field;
import com.company.save.ArmyLocation;
import com.company.strategy.Point;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class LostTheWayState implements State {
    private Field field;
    private List<Point> myPath;
    private final String movingState="dead";

    @Override
    public State moveToTheNextState() {
        return new LostTheWayState(field,myPath);
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public ArmyLocation savedData() {
        return new ArmyLocation(myPath,movingState);
    }
}
