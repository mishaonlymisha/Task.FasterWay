package com.company;

import com.company.army.SimpleArmy;
import com.company.fieldClasses.ConverterOfDataField;
import com.company.fieldClasses.Field;
import com.company.reader.FieldDataInput;
import com.company.reader.FieldReader;
import com.company.save.DataInfoForRestSave;
import com.company.writer.FieldWriter;
import lombok.AllArgsConstructor;


public class ClientCode {
    private final FieldReader reader;
    private final FieldWriter writer;
    private DataInfoForRestSave dataInfoForRestSave;

    public ClientCode(FieldReader reader, FieldWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public DataInfoForRestSave getDataInfoForRestSave() {
        return dataInfoForRestSave;
    }

    public void moveTillFinish() {
        FieldDataInput input = reader.readField();
        Field field = new ConverterOfDataField().convert(input.getField());
        SimpleArmy simpleArmy = new SimpleArmy(field);

        simpleArmy.moveTillFinish();

        writer.tryWriteFieldAndFasterWay(input, simpleArmy.location());
        dataInfoForRestSave = new DataInfoForRestSave(input.getField(),simpleArmy.location().getPathForSave(),simpleArmy.location().getMovingStateForSave());

    }

    public void moveFewSteps(int numberOfSteps) {
        FieldDataInput input = reader.readField();
        Field field = new ConverterOfDataField().convert(input.getField());
        SimpleArmy simpleArmy = new SimpleArmy(field);

        simpleArmy.move(numberOfSteps);

        writer.tryWriteFieldAndFasterWay(input, simpleArmy.location());
        dataInfoForRestSave = new DataInfoForRestSave(input.getField(),simpleArmy.location().getPathForSave(),simpleArmy.location().getMovingStateForSave());

    }


}
