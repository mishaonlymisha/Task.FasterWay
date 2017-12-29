package com.company.reader;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonFieldReader implements FieldReader {
    private static ObjectMapper mapper = new ObjectMapper();
    private InputStream inputStream;


    public JsonFieldReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public FieldDataInput tryReadField() {
        try {
            return mapper.readValue(inputStream, FieldDataInput.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
