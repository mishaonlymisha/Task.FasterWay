package com.company.state;

import com.company.army.Scout;
import com.company.fieldClasses.Field;
import com.company.save.ArmyLocation;
import com.company.strategy.GroundStrategy;
import com.company.strategy.Point;
import com.company.strategy.SeaStrategy;
import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class GroundState implements State {
    private final Field field;
    private final Point myCurrentPosition;
    private final Point whereAmIGoing;
    private final String movingState = "moving";
    private List<Point> myPath;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroundState that = (GroundState) o;
        return Objects.equals(field, that.field) &&
                Objects.equals(myCurrentPosition, that.myCurrentPosition) &&
                Objects.equals(whereAmIGoing, that.whereAmIGoing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, myCurrentPosition, whereAmIGoing);
    }

    @Override
    public State moveToTheNextState() {
        if (myCurrentPosition.equals(field.getFinish())) {
            return new FinishState(field, myPath);
        }
        if (new Scout().armyLostTheWay(myPath)) {
            return new LostTheWayState(field, myPath);
        }
        List<Point> availablePositions = new Scout(1, 1, field).checkAvailablePositions(myCurrentPosition);
        List<Point> selectedPorts = selectOfPortPoints(field, availablePositions);
        List<Point> selectedSimplePoints = availablePositions;
        if (selectedPorts.isEmpty()) {
            Point nextPoint = new GroundStrategy(field, selectedSimplePoints, field.getFinish()).generateOptimalPointAndFasterWay().getKey().getKey();
            myPath.add(nextPoint);
            return new GroundState(field, nextPoint, field.getFinish(), myPath);

        } else {
            Pair<Pair<Point, Point>, Integer> resultOfSeaStrategy = new SeaStrategy(field, selectedPorts).generateOptimalPointAndFasterWay();
            Pair<Pair<Point, Point>, Integer> resultOfGroundStrategy = new GroundStrategy(field, selectedSimplePoints, field.getFinish()).generateOptimalPointAndFasterWay();
            if (seaStrategyWin(resultOfSeaStrategy.getValue(), resultOfGroundStrategy.getValue())) {
                myPath.add(resultOfSeaStrategy.getKey().getKey());
                return new SeaState(field, resultOfSeaStrategy.getKey().getKey(), resultOfGroundStrategy.getKey().getValue(), myPath);
            } else {
                myPath.add(resultOfGroundStrategy.getKey().getKey());
                return new GroundState(field, resultOfGroundStrategy.getKey().getKey(), resultOfGroundStrategy.getKey().getValue(), myPath);
            }
        }
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public ArmyLocation savedData() {
        return new ArmyLocation(myPath, movingState);
    }

    private List<Point> selectOfPortPoints(Field field, List<Point> availablePoints) {
        List<Point> resultList = new ArrayList<>();
        for (int i = 0; i < availablePoints.size(); i++) {
            if (field.inThisPointIsPort(availablePoints.get(i))) {
                resultList.add(availablePoints.get(i));
            }
        }
        return resultList;
    }

    private boolean seaStrategyWin(int resultWayOfSeaStrategy, int resultWayOfGroundStrategy) {
        if (resultWayOfSeaStrategy < resultWayOfGroundStrategy)
            return true;
        return false;
    }
}
