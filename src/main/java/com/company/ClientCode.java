package com.company;

import com.company.reader.FieldDataInput;
import com.company.reader.JsonFieldReader;
import com.company.writer.JsonFieldWriter;

import java.io.InputStream;

public class ClientCode {

    private String inputFileName;
    private String outputFileName;

    public ClientCode(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void getFasterWay() {
        InputStream inputStream = Main.class.getResourceAsStream("text.json");
        JsonFieldReader json = new JsonFieldReader(inputStream);
        ContainerOfDataField containerOfDataField = new ContainerOfDataField(json.tryReadField());
        Field f = new Field(containerOfDataField.convertListOfStringsToCharArray());
        JsonFieldWriter jsonFieldWriter = new JsonFieldWriter(outputFileName);
        jsonFieldWriter.tryWriteFieldAndFasterWay(containerOfDataField, f.fasterWay());

    }


}
