package com.company;

import com.company.reader.FieldDataInput;
import com.company.save.ArmyLocation;
import com.company.writer.FieldDataOutput;
import com.company.writer.FieldWriter;
import lombok.Getter;

@Getter
public class FakeFieldWriter implements FieldWriter {

    private FieldDataOutput fieldDataOutput;


    @Override
    public void tryWriteFieldAndFasterWay(FieldDataInput input, ArmyLocation armyLocation) {
        fieldDataOutput = new FieldDataOutput(input.getField(), armyLocation.getPathForSave(), armyLocation.getMovingStateForSave());
    }
}
