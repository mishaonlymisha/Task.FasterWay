package com.company.fieldClasses;

import com.company.strategy.Point;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class SimpleCell implements Cells {
    private final Point myPosition;
    private final List<Point> listOfPorts;
    private final boolean canMoveOnThisPoint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleCell that = (SimpleCell) o;
        return canMoveOnThisPoint == that.canMoveOnThisPoint &&
                Objects.equals(myPosition, that.myPosition) &&
                Objects.equals(listOfPorts, that.listOfPorts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myPosition, listOfPorts, canMoveOnThisPoint);
    }

    public Point getMyPosition() {
        return myPosition;
    }

    @Override
    public List<Point> getListOfPorts() {
        return listOfPorts;
    }

    @Override
    public boolean canMoveOnThisPoint() {
        return canMoveOnThisPoint;
    }

    @Override
    public Point getMyCurrentPosition() {
        return myPosition;
    }
}
