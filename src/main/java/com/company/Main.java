package com.company;


import com.company.reader.JsonFieldReader;
import com.company.writer.JsonFieldWriter;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        File input = new File(Main.class.getResource("text.json").getFile());
        File output = new File(System.clearProperty("user.dir") + File.separator + "result.json");

        ClientCode clientCode = new ClientCode(new JsonFieldReader(input), new JsonFieldWriter(output));
        clientCode.getFasterWay();




        

    }
}

