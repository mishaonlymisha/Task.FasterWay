package com.company;

import com.company.reader.FieldDataInput;

import java.util.List;

public class ContainerOfDataField {
    private FieldDataInput fieldDataInput;

    public ContainerOfDataField(FieldDataInput fieldDataInput) {
        this.fieldDataInput = fieldDataInput;
    }

    public char[] convertListOfStringsToCharArray() {
        char[] arrayField = new char[fieldDataInput.getField().size() * fieldDataInput.getField().size()];
        int elem = 0;
        for (int i = 0; i < fieldDataInput.getField().size(); i++) {
            for (int j = 0; j < fieldDataInput.getField().get(i).length(); j++) {
                arrayField[elem] = fieldDataInput.getField().get(i).charAt(j);
                elem++;
            }
        }
        return arrayField;
    }

    public List<String> getListOfStrings() {
        return fieldDataInput.getField();
    }
}
