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

public class GroundStateTest {

    @Test
    public void testMoveToGroundState() throws Exception {
        List<Point> path = new ArrayList<>();
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|*|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        State resultGroundState = new GroundState(field, new Point(1, 1), field.getFinish(), path);
        State testGroundState = new GroundState(field, new Point(2, 1), field.getFinish(), path);

        resultGroundState = resultGroundState.moveToTheNextState();

        assertThat(testGroundState, is(resultGroundState));

    }

    @Test
    public void testMoveToTheSeaState() throws Exception {
        List<Point> path = new ArrayList<>();
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|*|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        State resultGroundState = new GroundState(field, new Point(0, 2), field.getFinish(), path);
        State testGroundState = new SeaState(field, new Point(0, 1), field.getFinish(), path);

        resultGroundState = resultGroundState.moveToTheNextState();

        assertThat(testGroundState, is(resultGroundState));

    }
}