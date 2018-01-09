package com.company;

import java.util.List;

public class ConverterOfDataField {
    public char[] convertListOfStringsToCharArray(List<String> data) {
        char[] arrayField = new char[data.size() * data.size()];
        int elem = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length(); j++) {
                arrayField[elem] = data.get(i).charAt(j);
                elem++;
            }
        }
        return arrayField;
    }
}
