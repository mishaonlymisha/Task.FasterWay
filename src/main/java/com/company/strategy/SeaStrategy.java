package com.company.strategy;

import com.company.fieldClasses.Field;
import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SeaStrategy implements Strategy {

    private final int timeToMoveInThisStrategy = 1;
    private Field field;
    private List<Point> portsForCheck;

    @Override
    public Pair<Pair<Point, Point>, Integer> generateOptimalPointAndFasterWay() {
        int minWay = distanceToFinish(portsForCheck.get(0), getListOfPortsOfThisPort(portsForCheck.get(0)).get(0));
        Point nextPoint = portsForCheck.get(0);
        Point finishPort = getListOfPortsOfThisPort(nextPoint).get(0);
        for (int i = 1; i < portsForCheck.size(); i++) {
            for (int j = 0; j < getListOfPortsOfThisPort(portsForCheck.get(i)).size(); j++) {
                if (distanceToFinish(portsForCheck.get(i), getListOfPortsOfThisPort(portsForCheck.get(i)).get(j)) < minWay) {
                    minWay = distanceToFinish(portsForCheck.get(i), getListOfPortsOfThisPort(portsForCheck.get(i)).get(j));
                    nextPoint = portsForCheck.get(i);
                    finishPort = getListOfPortsOfThisPort(portsForCheck.get(i)).get(j);
                }
            }
        }
        return new Pair<>(new Pair<>(nextPoint, finishPort), minWay);

    }

    @Override
    public int distanceToFinish(Point from, Point finish) {
        return distanceToPort(from, finish) + new GroundStrategy(null, null, null).distanceToFinish(finish, field.getFinish()) + 2;
    }

    private List<Point> getListOfPortsOfThisPort(Pair port) {
        return field.getCellInThisCoordinates((int) port.getKey(), (int) port.getValue()).getListOfPorts();
    }

    private int distanceToPort(Point from, Point finish) {
        return new SimpleCalculator().thisDistanceToFinish(from, finish) * timeToMoveInThisStrategy;
    }
}
