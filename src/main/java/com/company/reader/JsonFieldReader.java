package com.company.reader;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

public class JsonFieldReader implements FieldReader {
    private static ObjectMapper mapper = new ObjectMapper();
    private InputStream inputStream;


    public JsonFieldReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public JsonFieldReader(File inputFile) {
        this(getInputStream(inputFile));
    }

    private static FileInputStream getInputStream(File inputFile) {
        try {
            return new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FieldDataInput readField() {
        try {
            return mapper.readValue(inputStream, FieldDataInput.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
