package com.company.writer;

import com.company.reader.FieldDataInput;
import com.company.save.ArmyLocation;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonFieldWriter implements FieldWriter {
    private File outputFile = null;

    public JsonFieldWriter(String outputFileName) {
        this(new File(outputFileName));
    }

    public JsonFieldWriter(File outputFile) {
        this.outputFile = outputFile;
    }

    private static FileOutputStream getOutputStream(File outputFile) {
        try {
            return new FileOutputStream(outputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void tryWriteFieldAndFasterWay(FieldDataInput input, ArmyLocation armyLocation) {

        outputFile.getParentFile().mkdirs();

        FieldDataOutput fieldDataOutput = new FieldDataOutput(input.getField(), armyLocation.getPathForSave(), armyLocation.getMovingStateForSave());
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(getOutputStream(outputFile), fieldDataOutput);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }



}
