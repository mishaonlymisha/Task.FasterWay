package com.company.army;

import com.company.fieldClasses.Field;
import com.company.strategy.Point;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Scout {
    private int dx;
    private int dy;
    private Field field;


    public List<Point> checkAvailablePositions(Point myCurrentPosition) {
        List<Point> resultListOfAvailablePositions = new ArrayList<>();
        if (myCurrentPosition.getValue() - dy >= 0 && field.getStateOfThisPoint(myCurrentPosition.getKey(), (myCurrentPosition.getValue()) - dy))
            resultListOfAvailablePositions.add(field.getPointInThisCoordinates(myCurrentPosition.getKey(), (myCurrentPosition.getValue()) - dy));

        if (myCurrentPosition.getKey() + dx <= 3 && field.getStateOfThisPoint((myCurrentPosition.getKey()) + dx, myCurrentPosition.getValue()))
            resultListOfAvailablePositions.add(field.getPointInThisCoordinates((myCurrentPosition.getKey()) + dx, myCurrentPosition.getValue()));

        if (myCurrentPosition.getValue() + dy <= 3 && field.getStateOfThisPoint(myCurrentPosition.getKey(), (myCurrentPosition.getValue()) + dy))
            resultListOfAvailablePositions.add(field.getPointInThisCoordinates(myCurrentPosition.getKey(), (myCurrentPosition.getValue()) + dy));

        if (myCurrentPosition.getKey() - dx >= 0 && field.getStateOfThisPoint(myCurrentPosition.getKey() - dx, (myCurrentPosition.getValue())))
            resultListOfAvailablePositions.add(field.getPointInThisCoordinates((myCurrentPosition.getKey()) - dx, myCurrentPosition.getValue()));

        return resultListOfAvailablePositions;
    }

    public boolean armyLostTheWay(List<Point> path) {
        if (findMaxReiterationOfPoint(path) == 3)
            return true;
        return false;
    }

    private int findMaxReiterationOfPoint(List<Point> list) {
        int maxReiteration = 1;
        for (int i = 0; i < list.size(); i++) {
            int localReiteration = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)))
                    localReiteration++;
            }
            if (localReiteration == 3)
                return 3;
            if (localReiteration > maxReiteration)
                maxReiteration = localReiteration;
        }
        return maxReiteration;
    }
}
