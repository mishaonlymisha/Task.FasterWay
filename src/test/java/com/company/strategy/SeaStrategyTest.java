package com.company.strategy;

import com.company.fieldClasses.Cells;
import com.company.fieldClasses.Field;
import com.company.fieldClasses.SimpleCell;
import javafx.util.Pair;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SeaStrategyTest {

    @Test
    public void testGenerateFasterWay() throws Exception {
        List<Point> listOfPortsOfFirstPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfSecondPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfThirdPort = Arrays.asList(new Point(1, 0), new Point(0, 1));

        List<List<Cells>> listOfCells = Arrays.asList(
                Arrays.asList(new SimpleCell(new Point(0, 0), null, true),
                        new SimpleCell(new Point(1, 0), listOfPortsOfFirstPort, true),
                        new SimpleCell(new Point(2, 0), null, false),
                        new SimpleCell(new Point(3, 0), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 1), listOfPortsOfSecondPort, true),
                        new SimpleCell(new Point(1, 1), null, true),
                        new SimpleCell(new Point(2, 1), null, false),
                        new SimpleCell(new Point(3, 1), listOfPortsOfThirdPort, true)),
                Arrays.asList(new SimpleCell(new Point(0, 2), null, true),
                        new SimpleCell(new Point(1, 2), null, true),
                        new SimpleCell(new Point(2, 2), null, true),
                        new SimpleCell(new Point(3, 2), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 3), null, true),
                        new SimpleCell(new Point(1, 3), null, true),
                        new SimpleCell(new Point(2, 3), null, true),
                        new SimpleCell(new Point(3, 3), null, true)));
        Point finish = new Point(3, 0);
        Field field = new Field(listOfCells, finish,null);
        List<Point> listOfPortsForTest = Arrays.asList(new Point(1, 0), new Point(0, 1));
        SeaStrategy seaStrategy = new SeaStrategy(field, listOfPortsForTest);

        int result = seaStrategy.generateOptimalPointAndFasterWay().getValue();

        assertThat(result, is(7));


    }

    @Test
    public void testGenerateOptimalPoint() throws Exception {
        List<Point> listOfPortsOfFirstPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfSecondPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfThirdPort = Arrays.asList(new Point(1, 0), new Point(0, 1));

        List<List<Cells>> listOfCells = Arrays.asList(
                Arrays.asList(new SimpleCell(new Point(0, 0), null, true),
                        new SimpleCell(new Point(1, 0), listOfPortsOfFirstPort, true),
                        new SimpleCell(new Point(2, 0), null, false),
                        new SimpleCell(new Point(3, 0), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 1), listOfPortsOfSecondPort, true),
                        new SimpleCell(new Point(1, 1), null, true),
                        new SimpleCell(new Point(2, 1), null, false),
                        new SimpleCell(new Point(3, 1), listOfPortsOfThirdPort, true)),
                Arrays.asList(new SimpleCell(new Point(0, 2), null, true),
                        new SimpleCell(new Point(1, 2), null, true),
                        new SimpleCell(new Point(2, 2), null, true),
                        new SimpleCell(new Point(3, 2), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 3), null, true),
                        new SimpleCell(new Point(1, 3), null, true),
                        new SimpleCell(new Point(2, 3), null, true),
                        new SimpleCell(new Point(3, 3), null, true)));
        Point finish = new Point(3, 0);
        Field field = new Field(listOfCells, finish,null);
        List<Point> listOfPortsForTest = Arrays.asList(new Point(1, 0), new Point(0, 1));
        SeaStrategy seaStrategy = new SeaStrategy(field, listOfPortsForTest);
        Point pointForTest = new Point(1, 0);

        Point nextPoint = seaStrategy.generateOptimalPointAndFasterWay().getKey().getKey();

        assertThat(nextPoint, is(pointForTest));


    }

    @Test
    public void testCaseWithOnePort() throws Exception {
        List<Point> listOfPortsOfFirstPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfSecondPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfThirdPort = Arrays.asList(new Point(1, 0), new Point(0, 1));

        List<List<Cells>> listOfCells = Arrays.asList(
                Arrays.asList(new SimpleCell(new Point(0, 0), null, true),
                        new SimpleCell(new Point(1, 0), listOfPortsOfFirstPort, true),
                        new SimpleCell(new Point(2, 0), null, false),
                        new SimpleCell(new Point(3, 0), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 1), listOfPortsOfSecondPort, true),
                        new SimpleCell(new Point(1, 1), null, true),
                        new SimpleCell(new Point(2, 1), null, false),
                        new SimpleCell(new Point(3, 1), listOfPortsOfThirdPort, true)),
                Arrays.asList(new SimpleCell(new Point(0, 2), null, true),
                        new SimpleCell(new Point(1, 2), null, true),
                        new SimpleCell(new Point(2, 2), null, true),
                        new SimpleCell(new Point(3, 2), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 3), null, true),
                        new SimpleCell(new Point(1, 3), null, true),
                        new SimpleCell(new Point(2, 3), null, true),
                        new SimpleCell(new Point(3, 3), null, true)));
        Point finish = new Point(3, 0);
        Field field = new Field(listOfCells, finish,null);
        List<Point> listOfPortsForTest = Arrays.asList(new Point(0, 1));
        SeaStrategy seaStrategy = new SeaStrategy(field, listOfPortsForTest);
        Point pointForTest = new Point(0, 1);

        Point nextPoint = seaStrategy.generateOptimalPointAndFasterWay().getKey().getKey();

        assertThat(nextPoint, is(pointForTest));


    }

    @Test
    public void testGenerateOptimalFinishPort() throws Exception {
        List<Point> listOfPortsOfFirstPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfSecondPort = Arrays.asList(new Point(3, 1));
        List<Point> listOfPortsOfThirdPort = Arrays.asList(new Point(1, 0), new Point(0, 1));

        List<List<Cells>> listOfCells = Arrays.asList(
                Arrays.asList(new SimpleCell(new Point(0, 0), null, true),
                        new SimpleCell(new Point(1, 0), listOfPortsOfFirstPort, true),
                        new SimpleCell(new Point(2, 0), null, false),
                        new SimpleCell(new Point(3, 0), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 1), listOfPortsOfSecondPort, true),
                        new SimpleCell(new Point(1, 1), null, true),
                        new SimpleCell(new Point(2, 1), null, false),
                        new SimpleCell(new Point(3, 1), listOfPortsOfThirdPort, true)),
                Arrays.asList(new SimpleCell(new Point(0, 2), null, true),
                        new SimpleCell(new Point(1, 2), null, true),
                        new SimpleCell(new Point(2, 2), null, true),
                        new SimpleCell(new Point(3, 2), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 3), null, true),
                        new SimpleCell(new Point(1, 3), null, true),
                        new SimpleCell(new Point(2, 3), null, true),
                        new SimpleCell(new Point(3, 3), null, true)));
        Point finish = new Point(3, 0);
        Field field = new Field(listOfCells, finish,null);
        List<Point> listOfPortsForTest = Arrays.asList(new Point(1, 0), new Point(0, 1));
        SeaStrategy seaStrategy = new SeaStrategy(field, listOfPortsForTest);
        Point pointForTest = new Point(3, 1);

        Point nextPoint = seaStrategy.generateOptimalPointAndFasterWay().getKey().getValue();

        assertThat(nextPoint, is(pointForTest));


    }


}