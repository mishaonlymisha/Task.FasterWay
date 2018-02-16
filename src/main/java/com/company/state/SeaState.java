package com.company.state;

import com.company.army.Scout;
import com.company.fieldClasses.Field;
import com.company.save.ArmyLocation;
import com.company.strategy.GroundStrategy;
import com.company.strategy.Point;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class SeaState implements State {
    private final Field field;
    private final Point myCurrentPosition;
    private final Point whereAmIGoing;
    private List<Point> myPath;
    private final String movingState = "moving";


    @Override
    public ArmyLocation savedData() {
        return new ArmyLocation(myPath, movingState);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeaState seaState = (SeaState) o;
        return Objects.equals(field, seaState.field) &&
                Objects.equals(myCurrentPosition, seaState.myCurrentPosition) &&
                Objects.equals(whereAmIGoing, seaState.whereAmIGoing);
    }

    @Override
    public int hashCode() {

        return Objects.hash(field, myCurrentPosition, whereAmIGoing);
    }

    @Override
    public State moveToTheNextState() {
        if (new Scout().armyLostTheWay(myPath)) {
            return new LostTheWayState(field, myPath);
        }
        List<Point> availablePoints = new Scout(1, 1, field).checkAvailablePositions(myCurrentPosition);
        Point nextPoint = new GroundStrategy(field, availablePoints, whereAmIGoing).generateOptimalPointAndFasterWay().getKey().getKey();
        myPath.add(nextPoint);
        if (armyCameToThePort(nextPoint, whereAmIGoing)) {
            Point resultWhereAmIGoing = field.getFinish();
            return new GroundState(field, nextPoint, resultWhereAmIGoing, myPath);
        } else {
            return new SeaState(field, nextPoint, whereAmIGoing, myPath);
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }


    private boolean armyCameToThePort(Point nextPoint, Point port) {
        if (nextPoint.equals(port))
            return true;
        return false;
    }

}
