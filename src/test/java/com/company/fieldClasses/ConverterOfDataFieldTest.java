package com.company.fieldClasses;

import com.company.strategy.Point;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConverterOfDataFieldTest {

    @Test
    public void testConvertFunction() {
        List<String> testField = Arrays.asList(
                "*|p1->p3|^|f",
                "p2->p3|*|^|p3->p1,p2",
                "*|*|*|*",
                "s|*|*|*");
        List<List<Cells>> correctCellsField = Arrays.asList(
                Arrays.asList(new SimpleCell(new Point(0, 0), null, true),
                        new SimpleCell(new Point(1, 0), Arrays.asList(new Point(3, 1)), true),
                        new SimpleCell(new Point(2, 0), null, false),
                        new SimpleCell(new Point(3, 0), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 1), Arrays.asList(new Point(3, 1)), true),
                        new SimpleCell(new Point(1, 1), null, true),
                        new SimpleCell(new Point(2, 1), null, false),
                        new SimpleCell(new Point(3, 1), Arrays.asList(new Point(1, 0), new Point(0, 1)), true)),
                Arrays.asList(new SimpleCell(new Point(0, 2), null, true),
                        new SimpleCell(new Point(1, 2), null, true),
                        new SimpleCell(new Point(2, 2), null, true),
                        new SimpleCell(new Point(3, 2), null, true)),
                Arrays.asList(new SimpleCell(new Point(0, 3), null, true),
                        new SimpleCell(new Point(1, 3), null, true),
                        new SimpleCell(new Point(2, 3), null, true),
                        new SimpleCell(new Point(3, 3), null, true)));
        Field correctField = new Field(correctCellsField, new Point(3, 0), new Point(0, 3));

        Field resultField = new ConverterOfDataField().convert(testField);

        assertThat(correctField, is(resultField));


    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testInvalidDataException() {
        List<String> testField = Arrays.asList(
                "*|p1->p3|^|f",
                "p2->p3|*|^|p3>p1,p2",
                "*|*|*|*",
                "8|*|*|*");
        Field field = new ConverterOfDataField().convert(testField);
    }

}
