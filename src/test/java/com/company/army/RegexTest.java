package com.company.army;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    @Test
    public void test(){
        Pattern pattern = Pattern.compile("(?<port>p\\d+)->(?<ports>(p\\d+,)*(p\\d+))");
        Matcher matcher = pattern.matcher("p3->p1,p2");
        if(matcher.matches()){
            String port = matcher.group("port");
            List<String> ports = Arrays.asList(matcher.group("ports").split(","));
            System.out.println(port);
            System.out.println(ports);
            System.out.println();
        }
    }

}