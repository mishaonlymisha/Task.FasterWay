package com.company.army;

import com.company.fieldClasses.ConverterOfDataField;
import com.company.fieldClasses.Field;
import com.company.strategy.Point;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ScoutTest {

    @Test
    public void testCheckAvailablePositions() throws Exception {

        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|^|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        Point myCurrentPosition = new Point(2, 2);
        Scout scout = new Scout(1, 1, field);
        List<Point> listOfPointForAssert = Arrays.asList(new Point(3, 2), new Point(2, 3), new Point(1, 2));

        List<Point> resultListOfAvailablePoints = scout.checkAvailablePositions(myCurrentPosition);

        assertThat(listOfPointForAssert, is(resultListOfAvailablePoints));

    }
    @Test
    public void testNoLostWay(){
        List<Point> listForTest=Arrays.asList(new Point(0,1),new Point(1,1),new Point(1,0),new Point(1,1),new Point(0,1));

        boolean result = new Scout().armyLostTheWay(listForTest);

        assertThat(result,is(false));

    }
    @Test
    public void testLostWay(){
        List<Point> listForTest=Arrays.asList(new Point(0,1),new Point(1,1),new Point(1,0),new Point(1,1),new Point(1,0),new Point(1,1));

        boolean result = new Scout().armyLostTheWay(listForTest);

        assertThat(result,is(true));

    }
}