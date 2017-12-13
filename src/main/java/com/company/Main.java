package com.company;




public class Main {


    public static void main(String[] args) {
        char []test={'*','*','^','F' ,'P','*','*','P','*','*','*','*','S','*','*','*'};
        Field f = new Field(test);
        int path=f.FasterWay();
        System.out.println("Faster path: "+path);
    }
}

