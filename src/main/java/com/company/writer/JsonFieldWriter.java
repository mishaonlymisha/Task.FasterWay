package com.company.writer;

import com.company.ContainerOfDataField;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonFieldWriter implements FieldWriter {
    private String outputFileName;

    public JsonFieldWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void tryWriteFieldAndFasterWay(ContainerOfDataField containerOfDataField, int way) {
        final String filename = outputFileName;
        final String workDir = System.getProperty("user.dir");
        final String fullFilename = workDir + File.separator + filename;

        final File file = new File(fullFilename);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FieldDataOutput fieldDataOutput = new FieldDataOutput(containerOfDataField.getListOfStrings(), way);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileOutputStream(System.getProperty("user.dir") + File.separator + outputFileName), fieldDataOutput);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
