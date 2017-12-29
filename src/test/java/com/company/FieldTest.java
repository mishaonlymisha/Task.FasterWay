//package com.company;
//import org.testng.annotations.Test;
//
//
//import java.io.File;
//import java.util.EmptyStackException;
//import java.util.NoSuchElementException;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//public class FieldTest {
//    @Test
//    public void GetFAsterWay (){
//
//        File file = new File(getClass().getResource("").getFile());
//        char []test={'*','*','^','f',
//                     'p','*','*','P',
//                     '*','*','*','*',
//                     'S','*','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(11));
//    }
//    @Test
//    public void GetFAsterWay1 (){
//
//        char []test={'*','*','^','*',
//                     'P','*','^','P',
//                     '*','*','*','*',
//                     'S','F','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(2));
//    }
//
//    @Test
//    public void GetFAsterWay2 (){
//        char []test={'*','*','^','F',
//                     'P','*','^','P',
//                     '*','*','*','*',
//                     'S','*','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(12));
//    }
//    @Test
//    public void GetFAsterWay3 (){
//        // new File(getClass().getResource("test.json"))
//        char []test={'*','*','^','*',
//                     '*','*','^','*',
//                     '*','*','*','*',
//                     'S','P','P','F'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(6));
//    }
//    @Test
//    public void GetFasterWay4 (){
//        char []test={'*','*','*','^','F',
//                     '*','*','*','*','*',
//                     'P','*','*','^','P',
//                     '^','*','*','*','*',
//                     'S','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(16));
//
//    }
//    @Test
//    public void GetFasterWay5 (){
//        char []test={'*','*','*','^','*',
//                     '*','*','*','*','*',
//                     '*','*','*','^','*',
//                     '*','*','*','*','*',
//                     'S','P','^','P','F'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(10));
//
//    }
//    @Test
//    public void GetFasterWay6 (){
//        char []test={'*','*','*','^','F',
//                     '*','*','*','^','*',
//                     'P','*','*','*','P',
//                     '*','*','*','*','*',
//                     'S','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(14));
//
//    }
//    @Test
//    public void GetFasterWay7 (){
//        char []test={'*','*','*','*','*','*',
//                     '*','^','*','*','^','*',
//                     '*','*','P','*','^','*',
//                     'P','*','^','*','^','*',
//                     '*','*','*','*','^','*',
//                     'S','*','*','*','^','F'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(29));
//
//    }
//    @Test
//    public void GetFasterWay8 (){
//        char []test={'S','^','P','*','*','*',
//                     '*','^','*','*','^','*',
//                     '*','^','*','*','^','*',
//                     '*','^','*','*','^','*',
//                     '*','^','*','P','^','*',
//                     '*','*','*','*','^','F'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(40));
//
//    }
//    @Test
//    public void GetFasterWay9 (){
//        char []test={'S','^','*','*','*','*',
//                     '*','^','*','*','^','*',
//                     '*','^','*','*','^','*',
//                     '*','^','*','*','^','*',
//                     'P','^','*','*','*','P',
//                     '*','*','*','*','*','F'};
//
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(19));
//
//    }
//    @Test
//    public void NoPath (){
//        char []test={'*','*','^','F',
//                     'P','*','^','P',
//                     '*','*','^','^',
//                     'S','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.GetWay(8,2);
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void NoPath1 (){
//        char []test={'*','*','^','F',
//                     'P','*','^','P',
//                     '*','*','^','^',
//                     'S','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.GetWay(3,5);
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void NoPath2 (){
//        char []test={'*','*','^','F',
//                     'P','*','*','P',
//                     '^','^','*','*',
//                     'S','^','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void NoPath3 (){
//        char []test={'*','*','*','^','F',
//                     'P','*','*','*','*',
//                     '^','^','^','^','P',
//                     '*','*','*','^','*',
//                     'S','*','*','^','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void NoPath4 (){
//        char []test={'*','*','*','*','*','F',
//                     '*','^','^','^','^','^',
//                     '^','*','*','*','*','*',
//                     'P','*','*','*','P','*',
//                     '*','*','*','*','*','*',
//                     'S','*','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void NoPath5 (){
//        char []test={'P','*','*','*','*','F',
//                     '^','*','*','*','*','^',
//                     '*','^','*','*','^','*',
//                     'P','*','^','^','P','*',
//                     '*','*','*','*','*','*',
//                     'S','*','*','*','*','P'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(0));
//
//    }
//    @Test
//    public void OnlyOnePath (){
//        char []test={'*','*','*','F',
//                     'P','*','*','^',
//                     '*','*','^','P',
//                     'S','*','*','^'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(12));
//
//    }
//    @Test
//    public void OnlyOnePath1 (){
//        char []test={'*','*','*','^','F',
//                     '^','*','*','*','*',
//                     'P','^','*','*','P',
//                     '^','*','^','*','^',
//                     'S','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(16));
//
//    }
//    @Test
//    public void OnlyOnePath2 (){
//        char []test={'*','*','*','^','*','F',
//                     '^','*','*','*','*','*',
//                     'P','^','*','^','^','P',
//                     '^','*','*','*','*','^',
//                     '^','^','^','^','*','^',
//                     'S','*','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(28));
//
//    }
//    @Test
//    public void OnlyOnePath3 (){
//        char []test={'*','*','*','^','*','F',
//                     '^','*','*','*','*','*',
//                     'P','^','*','^','^','P',
//                     '^','*','*','*','*','^',
//                     '^','^','^','^','*','*',
//                     '*','*','*','*','*','S'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(22));
//
//    }
//    @Test
//    public void OnlyOnePath4 (){
//        char []test={'*','*','*','^','*','F',
//                     '^','*','*','*','*','*',
//                     'P','^','*','^','^','P',
//                     '*','^','*','*','*','^',
//                     '*','^','^','^','*','*',
//                     '*','*','P','^','*','S'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(22));
//
//    }
//    @Test
//    public void FasterWaySeveralPorts1 (){
//        char []test={'*','*','F','P',
//                     'P','*','P','*',
//                     'P','*','*','*',
//                     'S','P','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(9));
//    }
//    @Test
//    public void FasterWaySeveralPorts2 (){
//        char []test={'P','P','P','F','P',
//                     '*','*','*','P','*',
//                     'S','P','*','*','*',
//                     '*','*','*','*','*',
//                     'P','P','*','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(9));
//    }
//    @Test
//    public void FasterWaySeveralPorts3 (){
//        char []test={'*','P','P','*','*',
//                     '*','*','*','*','P',
//                     'S','P','P','^','F',
//                     '*','*','*','*','P',
//                     '*','P','P','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(10));
//    }
//    @Test
//    public void FasterWaySeveralPorts4 (){
//        char []test={'*','P','P','*','*',
//                     '*','*','*','*','P',
//                     'S','P','P','*','F',
//                     '*','*','*','*','P',
//                     '*','P','P','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(8));
//    }
//    @Test(expectedExceptions = EmptyStackException.class)
//    public void IncorrectImput (){
//        char []test={'*','P',
//                     '*','*','*','*','P',
//                     'P','*','F',
//                     '*','*','*','*','P',
//                     '*','P','P','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = NullPointerException.class)
//    public void NullImput (){
//        Field f = new Field(null);
//    }
//    @Test(expectedExceptions = NoSuchElementException.class)
//    public void NoPorts (){
//        char []test={' ',' ',' ','F',
//                     ' ',' ',' ',' ',
//                     ' ',' ',' ',' ',
//                     'S',' ',' ',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = NoSuchElementException.class)
//    public void NoFinish (){
//        char []test={' ',' ',' ',' ',
//                     ' ',' ',' ','P',
//                     ' ',' ','P',' ',
//                     'S',' ',' ',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = NoSuchElementException.class)
//    public void NoStart (){
//        char []test={' ',' ',' ',' ',
//                     ' ','F',' ','P',
//                     ' ',' ','P',' ',
//                     ' ',' ',' ',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = StackOverflowError.class)
//    public void DataOverflow (){
//        char []test={' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',
//                ' ',' ',' ',' ', ' ','F',' ','P', ' ',' ','P',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test
//    public void OtherSymbols (){
//        char []test={'d','b',' ','e',
//                     '9','F',' ','P',
//                     ' ',' ','P','l',
//                     's','a',' ','c'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//        assertThat(result,is(6));
//    }
//    @Test(expectedExceptions = StackOverflowError.class)
//    public void SeveralStarts (){
//        char []test={' ',' ',' ',' ',
//                     ' ','F',' ','P',
//                     ' ','s','P',' ',
//                     'S','s',' ',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = StackOverflowError.class)
//    public void SeveralFinishs (){
//        char []test={' ',' ',' ',' ',
//                     ' ','F',' ','P',
//                     'F','s','P',' ',
//                     'f',' ',' ',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//    @Test(expectedExceptions = StackOverflowError.class)
//    public void SeveralStartsAndFinishs (){
//        char []test={' ',' ',' ',' ',
//                     ' ','F',' ','P',
//                     'F','s','P','a',
//                     'f','S','s',' '};
//        Field f = new Field(new FakeFieldReader(test));
//    }
//
//
//
//    @Test
//    public void FasterWaySeveralPorts6 (){
//        char []test={'*','P','P','*','*','*','*',
//                     '*','*','*','*','*','*','*',
//                     '*','*','*','^','*','*','*',
//                     '*','*','*','^','*','*','*',
//                     '*','^','^','^','*','P','*',
//                     'S','*','P','^','P','F','*',
//                     '*','P','*','*','*','P','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(12));
//    }
//    @Test
//    public void FasterWaySeveralPorts7 (){
//        char []test={'*','P','P','*','P','F','P',
//                     '*','*','*','*','*','*','*',
//                     '*','*','*','^','*','*','P',
//                     '*','*','*','^','*','*','*',
//                     '*','^','^','^','*','P','*',
//                     'S','*','P','^','P','*','*',
//                     '*','P','*','*','*','P','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(17));
//    }
//    @Test
//    public void FasterWaySeveralPorts8 (){
//        char []test={'*','P','P','*','P','*','P','*',
//                     '*','*','*','*','*','P','F','P',
//                     '*','*','*','*','*','*','*','*',
//                     '*','*','*','*','^','*','P','P',
//                     '*','*','*','*','^','*','*','*',
//                     '*','*','^','^','^','*','*','*',
//                     '*','*','*','P','^','P','P','P',
//                     '*','*','P','*','*','P','S','P'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(11));
//    }@Test
//    public void FasterWaySeveralPorts9 (){
//        char []test={'*','P','P','*','P','*','P','*',
//                     '*','*','*','*','*','P','F','P',
//                     '*','*','*','*','*','*','^','*',
//                     '*','*','*','*','^','*','P','P',
//                     '*','*','*','*','^','*','*','*',
//                     '*','*','^','^','^','*','*','*',
//                     '*','*','*','P','^','P','P','P',
//                     '*','*','P','*','*','P','S','P'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(12));
//    }
//    @Test
//    public void OnePortIsSkipped (){
//        char []test={'*','*','F','P',
//                     '*','*','*','*',
//                     '*','*','*','*',
//                     'S','*','*','*'};
//        Field f = new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(10));
//    }
//    @Test
//    public void OnePortIsSkippedOnBiggerField (){
//        char []test={'*','*','*','^','F',
//                     'P','*','*','*','*',
//                     '*','^','^','^','*',
//                     '*','*','*','^','*',
//                     'S','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(16));
//
//    }
//    @Test
//    public void OnePort2 (){
//        char []test={'*','*',' ','^','*','F',
//                     '*','*',' ','*','*','*',
//                     '^','*','*','*','*','*',
//                     '*','^','*','^','*','*',
//                     '*','*','*','^','*','*',
//                     'S','P','*','*','*','*'};
//        Field f=new Field(new FakeFieldReader(test));
//
//        int result=f.fasterWay();
//
//        assertThat(result,is(20));
//
//    }
//
//}
