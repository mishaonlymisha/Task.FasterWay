package com.company;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;


public class Main {


    public static void main(String[] args) {

    ObjectMapper mapper = new ObjectMapper();
    InputStream inputStream = JsonField.class.getClassLoader().getResourceAsStream("text.json");
    try {
            JsonField text=(JsonField) mapper.readValue(inputStream,JsonField.class);
            text.out();
            Field f=new Field(text);
            System.out.println(f.fasterWay());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}

