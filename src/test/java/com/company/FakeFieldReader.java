package com.company;

import com.company.reader.FieldDataInput;
import com.company.reader.FieldReader;

public class FakeFieldReader implements FieldReader {
    private final char[] field;

    public FakeFieldReader(char[] field) {
        this.field = field;
    }

    public char[] readField() {
        return field;
    }

    @Override
    public FieldDataInput tryReadField() {
        return null;
    }
}
