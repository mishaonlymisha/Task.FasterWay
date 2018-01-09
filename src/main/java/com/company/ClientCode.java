package com.company;

import com.company.reader.FieldDataInput;
import com.company.reader.FieldReader;
import com.company.reader.JsonFieldReader;
import com.company.writer.FieldWriter;
import com.company.writer.JsonFieldWriter;

import java.io.File;
import java.io.InputStream;

public class ClientCode {
    private final FieldReader reader;
    private final FieldWriter writer;

    public ClientCode(File inputFileName, File outputFileName) {
        this(new JsonFieldReader(inputFileName), new JsonFieldWriter(outputFileName));
    }

    public ClientCode(FieldReader reader, FieldWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void getFasterWay() {
        FieldDataInput input = reader.tryReadField();

        Field f = new Field(new ConverterOfDataField().convertListOfStringsToCharArray(input.getField()));

        writer.tryWriteFieldAndFasterWay(input, f.fasterWay());

    }


}
