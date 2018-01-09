package com.company.writer;

import com.company.ConverterOfDataField;
import com.company.reader.FieldDataInput;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonFieldWriter implements FieldWriter {
    private String outputFileName;
    private File outputFile = null;

    public JsonFieldWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public JsonFieldWriter(File outputFile) {
        this.outputFile = outputFile;
        //getOutputStream(outputFile);
    }

    private static FileOutputStream getOutputStream(File outputFile) {
        try {
            return new FileOutputStream(outputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void tryWriteFieldAndFasterWay(FieldDataInput input, int way) {
        if (clientUsesTheFileName()) {
            final String filename = outputFileName;
            final String workDir = System.getProperty("user.dir");
            final String fullFilename = workDir + File.separator + filename;

            final File file = new File(fullFilename);

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File already created");
            }

            FieldDataOutput fieldDataOutput = new FieldDataOutput(input, way);
            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.writeValue(new FileOutputStream(System.getProperty("user.dir") + File.separator + outputFileName), fieldDataOutput);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        } else {
            FieldDataOutput fieldDataOutput = new FieldDataOutput(input, way);
            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.writeValue(getOutputStream(outputFile), fieldDataOutput);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

    private boolean clientUsesTheFileName() {
        if (outputFile == null)
            return true;
        return false;
    }

}
