package com.company.army;

import com.company.fieldClasses.ConverterOfDataField;
import com.company.fieldClasses.Field;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleArmyTest {

    @Test
    public void testMove() {
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|*|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
        SimpleArmy simpleArmy = new SimpleArmy(field);

        while (!simpleArmy.movementIsFinished()) {
            simpleArmy.move();
        }

        System.out.println();
    }
}