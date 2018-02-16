package com.company.army;

import com.company.fieldClasses.Field;
import com.company.save.ArmyLocation;
import com.company.state.GroundState;
import com.company.state.State;
import com.company.strategy.Point;
import org.testng.collections.Lists;

import java.util.List;

public class SimpleArmy implements Army {
    private State stateNow;


    public SimpleArmy(Field field) {
        List<Point> myPath= Lists.newArrayList(field.getStart());
        stateNow = new GroundState(field, field.getStart(), field.getFinish(),myPath);
    }

    @Override
    public void move() {
        stateNow = stateNow.moveToTheNextState();
    }

    @Override
    public boolean movementIsFinished() {
        return stateNow.isFinal();
    }

    @Override
    public ArmyLocation location(){
        return stateNow.savedData();
    }

}
