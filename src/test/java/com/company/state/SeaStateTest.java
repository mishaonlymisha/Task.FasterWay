package com.company.state;

import com.company.fieldClasses.ConverterOfDataField;
import com.company.fieldClasses.Field;
import com.company.strategy.Point;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SeaStateTest {

    @Test
    public void testMoveToTheSeaState() {
        List<Point> path = new ArrayList<>();
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|*|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        State resultGroundState = new SeaState(field, new Point(1, 1), new Point(3, 1), path);
        State testGroundState = new SeaState(field, new Point(2, 1), new Point(3, 1), path);

        resultGroundState = resultGroundState.moveToTheNextState();

        assertThat(testGroundState, is(resultGroundState));

    }

    @Test
    public void testMoveToTheGroundState() {
        List<Point> path = new ArrayList<>();
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|*|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        State resultGroundState = new SeaState(field, new Point(2, 1), new Point(3, 1), path);
        State testGroundState = new GroundState(field, new Point(3, 1), field.getFinish(), path);

        resultGroundState = resultGroundState.moveToTheNextState();

        assertThat(testGroundState, is(resultGroundState));

    }

}