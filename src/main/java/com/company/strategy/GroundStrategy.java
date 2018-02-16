package com.company.strategy;

import com.company.fieldClasses.Field;
import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.lang.Math.abs;

@AllArgsConstructor
public class GroundStrategy implements Strategy {
    private final int timeToMoveInThisStrategy = 2;
    private Field field;
    private List<Point> pointsForCheck;
    private Point whereAmIGoing;

    @Override
    public Pair<Pair<Point, Point>, Integer> generateOptimalPointAndFasterWay() {
        if (pointsForCheck.isEmpty())
            return null;
        else {
            int minWay = distanceToFinish(pointsForCheck.get(0), whereAmIGoing);
            Point currentNextPoint = new Point(pointsForCheck.get(0).getKey(), pointsForCheck.get(0).getValue());
            for (int i = 1; i < pointsForCheck.size(); i++) {
                if (distanceToFinish(pointsForCheck.get(i), whereAmIGoing) < minWay) {
                    minWay = distanceToFinish(pointsForCheck.get(i), whereAmIGoing);
                    currentNextPoint = pointsForCheck.get(i);
                } else if (distanceToFinish(pointsForCheck.get(i), whereAmIGoing) == minWay) {
                    currentNextPoint = nextPointWithDxDyCriterion(currentNextPoint, pointsForCheck.get(i));
                }
            }
            return new Pair<>(new Pair<>(currentNextPoint, field.getFinish()), minWay);

        }
    }

    @Override
    public int distanceToFinish(Point from, Point finish) {
        return new SimpleCalculator().thisDistanceToFinish(from, finish) * timeToMoveInThisStrategy;
    }

    private Point nextPointWithDxDyCriterion(Point currentNextPoint, Point verifiablePoint) {
        if ((currentNextPoint.dx(whereAmIGoing) == verifiablePoint.dy(whereAmIGoing)) && (currentNextPoint.dy(whereAmIGoing) == verifiablePoint.dx(whereAmIGoing))) {
            if (currentNextPoint.dx(whereAmIGoing) < verifiablePoint.dx(whereAmIGoing))
                return currentNextPoint;
            return verifiablePoint;
        } else {
            if (abs(currentNextPoint.dx(whereAmIGoing) - currentNextPoint.dy(whereAmIGoing)) < abs(verifiablePoint.dx(whereAmIGoing) - verifiablePoint.dy(whereAmIGoing)))
                return currentNextPoint;
            return verifiablePoint;
        }
    }


}
