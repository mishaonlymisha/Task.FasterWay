package com.company.fieldClasses;

import com.company.strategy.Point;

import java.util.List;

public interface Cells {
    List<Point> getListOfPorts();

    boolean canMoveOnThisPoint();

    Point getMyCurrentPosition();
}
