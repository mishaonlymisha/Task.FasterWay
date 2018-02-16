package com.company.strategy;

import com.company.fieldClasses.Field;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GroundStrategyTest {

    @Test
    public void testGenerateFasterWay() throws Exception {
        Point finish = new Point(3, 3);
        Field f = new Field(null, finish,null);
        List<Point> pointsForCheck = Arrays.asList(new Point(1, 0), new Point(0, 1), new Point(1, 2), new Point(2, 1));
        GroundStrategy groundStrategy = new GroundStrategy(f, pointsForCheck, f.getFinish());

        int result = groundStrategy.generateOptimalPointAndFasterWay().getValue();

        assertThat(result, is(6));

    }

    @Test
    public void testGenerateOptimalPoint() throws Exception {
        Point finish = new Point(3, 3);
        Field f = new Field(null, finish,null);
        List<Point> pointsForCheck = Arrays.asList(new Point(1, 0), new Point(0, 1), new Point(1, 2), new Point(2, 1));
        GroundStrategy groundStrategy = new GroundStrategy(f, pointsForCheck, f.getFinish());
        Point pointForAssert = new Point(2, 1);

        Point result = groundStrategy.generateOptimalPointAndFasterWay().getKey().getKey();


        assertThat(result, is(pointForAssert));

    }

    @Test
    public void testCaseWithDxDyCriterion() throws Exception {
        Point finish = new Point(3, 3);
        Field f = new Field(null, finish,null);
        List<Point> pointsForCheck = Arrays.asList(new Point(0, 2), new Point(2, 2));
        GroundStrategy groundStrategy = new GroundStrategy(f, pointsForCheck, f.getFinish());
        Point pointForAssert = new Point(2, 2);

        Point result = groundStrategy.generateOptimalPointAndFasterWay().getKey().getKey();


        assertThat(result, is(pointForAssert));


    }

    @Test
    public void testCaseWithOnePoint() throws Exception {
        Point finish = new Point(3, 3);
        Field f = new Field(null, finish,null);
        List<Point> pointsForCheck = Arrays.asList(new Point(2, 2));
        GroundStrategy groundStrategy = new GroundStrategy(f, pointsForCheck, f.getFinish());
        Point pointForAssert = new Point(2, 2);

        Point result = groundStrategy.generateOptimalPointAndFasterWay().getKey().getKey();

        assertThat(result, is(pointForAssert));


    }

}