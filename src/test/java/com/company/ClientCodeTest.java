package com.company;

import com.company.fieldClasses.Cells;
import com.company.fieldClasses.ConverterOfDataField;
import com.company.fieldClasses.Field;
import com.company.fieldClasses.SimpleCell;
import com.company.reader.JsonFieldReader;
import com.company.strategy.Point;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ClientCodeTest {
    @Test
    public void processData() {
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|^|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        FakeFieldWriter fakeWriter = new FakeFieldWriter();
        ClientCode clientCode = new ClientCode(new FakeFieldReader(testField), fakeWriter);

        clientCode.moveTillFinish();

        assertThat(fakeWriter.getFieldDataOutput().getField(), is(testField));
    }

    @Test
    public void processDataWithMovingStateResult() {
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|^|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        FakeFieldWriter fakeWriter = new FakeFieldWriter();
        ClientCode clientCode = new ClientCode(new FakeFieldReader(testField), fakeWriter);

        clientCode.moveFewSteps(5);

        assertThat(fakeWriter.getFieldDataOutput().getMovingState(), is("moving"));
    }

    @Test
    public void processDateWithPath() {
        List<String> testField = Arrays.asList("*|p1->p3|^|f", "p2->p3|*|^|p3->p1,p2", "*|*|*|*", "s|*|*|*");
        FakeFieldWriter fakeWriter = new FakeFieldWriter();
        ClientCode clientCode = new ClientCode(new FakeFieldReader(testField), fakeWriter);
        List<Point> correctPath = Arrays.asList(new Point(0, 3), new Point(1, 3), new Point(1, 2));

        clientCode.moveFewSteps(2);

        assertThat(fakeWriter.getFieldDataOutput().getPath(), is(correctPath));

    }

    @Test
    public void processCellsFieldFromJson() {
        File input = new File(Main.class.getResource("newText.json").getFile());

        Field result = new ConverterOfDataField().convert(new JsonFieldReader(input).readField().getField());

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
        assertThat(result, is(correctField));


    }

    @Test
    public void processMovingArmyFromJson() {
        File input = new File(Main.class.getResource("newText.json").getFile());
        FakeFieldWriter fakeFieldWriter = new FakeFieldWriter();
        ClientCode clientCode = new ClientCode(new JsonFieldReader(input), fakeFieldWriter);

        clientCode.moveFewSteps(3);

        assertThat(fakeFieldWriter.getFieldDataOutput().getMovingState(), is("moving"));


    }


}