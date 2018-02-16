package com.company;

import com.company.reader.FieldDataInput;
import com.company.reader.FieldReader;

import java.util.List;

public class FakeFieldReader implements FieldReader {
    private final List<String> field;


    public FakeFieldReader(List<String> field) {
        this.field = field;
    }

    @Override
    public FieldDataInput readField() {
        return new FieldDataInput(field);
    }
}
