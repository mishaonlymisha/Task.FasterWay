package com.company.fieldClasses;


import com.company.strategy.Point;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
@AllArgsConstructor
public class Field {

    private final List<List<Cells>> cellsField;
    private final Point finish;
    private final Point start;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(cellsField, field.cellsField) &&
                Objects.equals(finish, field.finish) &&
                Objects.equals(start, field.start);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cellsField, finish, start);
    }

    public Point getFinish() {
        return finish;
    }
    public Point getStart(){return start;}

    public Point getPointInThisCoordinates(int x, int y) {
        return cellsField.get(y).get(x).getMyCurrentPosition();
    }

    public Cells getCellInThisCoordinates(int x, int y) {
        return cellsField.get(y).get(x);
    }


    public boolean getStateOfThisPoint(int x, int y) {
        return cellsField.get(y).get(x).canMoveOnThisPoint();
    }

    public boolean inThisPointIsPort(Point point) {
        if (cellsField.get(point.getValue()).get(point.getKey()).getListOfPorts() != null)
            return true;
        return false;
    }
}



