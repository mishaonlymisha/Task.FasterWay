package com.company;

import java.util.ArrayList;
import java.util.List;

public class JsonField {
    private List<String> field = new ArrayList();

    public List<String> getField() {
        return field;
    }

    public void out() {
        for (int i = 0; i <field.size() ; i++) {
            for (int j = 0; j <field.size() ; j++) {
                System.out.print(field.get(i).charAt(j));
            }
            System.out.println();
        }
    }
}
