package com.company.writer;

import com.company.reader.FieldDataInput;
import com.company.save.ArmyLocation;

public interface FieldWriter {
    void tryWriteFieldAndFasterWay(FieldDataInput input, ArmyLocation armyLocation);

}
