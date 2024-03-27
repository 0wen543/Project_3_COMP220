import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoresTest {
    /*
     * Constructor tests using numScores() and get()
     */
    @Test
    public void doubleTest(){
        final String doubles = "0.45 22.22 3.67";
        int exceptCount=0;
        try{
            Scores test = new Scores(doubles);
        }catch (IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }

    @Test
    public void numScoreTest(){
        final String nums="6 3 87 12 65 53";

        Scores test = new Scores(nums);

        assertEquals(6,test.getNumScores());
    }

    @Test
    public void wordsTest(){
        final String words="This test is interesting";
        int exceptCount=0;
        try{
            Scores test = new Scores(words);
        }
        catch(IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }

    @Test
    public void getTest(){
        final String nums ="4 5 6 7 7";

        Scores test = new Scores(nums);

        assertEquals(6, test.get(2));
    }

    @Test
    public void negativeTest(){
        final String negatives ="-4 -25 -87";

        Scores test = new Scores(negatives);
        assertEquals(3,test.getNumScores());
    }

    @Test
    public void nothingTest(){
        final String nothing = " ";
        int exceptCount = 0;
        Scores test; // = new Scores(nothing);
        try{
            test = new Scores(nothing);
        }catch(IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
        //assertEquals(1,test.getNumScores());
    }

    @Test
    public void nonSpacedTest(){
        final String noSpaces = "43568346176437014389690";
        int exceptCount=0;
        try {
            Scores test = new Scores(noSpaces);
        }
        catch(IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }

    @Test
    public void outOfBoundTest(){
        final String outOfBound = "2 3";
        int exceptCount=0;
        Scores test = new Scores(outOfBound);
        try{
            test.get(8);
        }catch(ArrayIndexOutOfBoundsException e){
            exceptCount++;
        }
        try{
            test.get(-1);
        }catch (ArrayIndexOutOfBoundsException e){
            exceptCount++;
        }
        assertEquals(2,exceptCount);
    }
    @Test
    public void dashes(){
        final String dashed = "4-8-132";
        int exceptCount=0;
        try{
            Scores test = new Scores(dashed);
        }catch (IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }


    /*
     * getMax() tests
     */
    @Test
    public void sameTest(){
        final String same ="4 4 4 4";

        Scores test = new Scores(same);
        assertEquals(4,test.getMax());
    }

    @Test
    public void negativeMaxTest(){
        final String negatives="-32 4 6 7";

        Scores test = new Scores(negatives);
        assertEquals(7,test.getMax());
    }

//    @Test
//    public void emptyTest(){
//        final String blank=" ";
//        int exceptCount=0;
//        Scores test = new Scores(blank);
//        try{
//            test.getMax();
//        }catch (NoSuchElementException e){
//            exceptCount++;
//        }
//        assertEquals(1,exceptCount);
//    }


    @Test
    public void spaceFirstTest(){
        final String spaceOne = "    1 2 3 4 5";
        int exceptCount = 0;
        try {
            Scores spaceyScores = new Scores(spaceOne);
        }catch (IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1, exceptCount);
    }

    @Test
    public void spaceAfterTest(){
        final String spaceAfter = "1         2 3 4 5";
        int exceptCount = 0;
        try {
            Scores funkySpaces = new Scores(spaceAfter);
        }catch (IllegalArgumentException e){
            exceptCount++;
        }
        assertEquals(1, exceptCount);
    }
    @Test
    public void oneGradeTest(){
        final String oneGrade = "1";
        Scores one = new Scores(oneGrade);
        assertEquals(1, one.getNumScores());
    }
    @Test
    public void letterTest(){
        final String letterToo = "1 r 5";
        int exceptCount = 0;
        try {
            Scores withLetter = new Scores(letterToo);
        } catch(IllegalArgumentException e ){
            exceptCount++;
        }
        assertEquals(1, exceptCount);
    }
    @Test
    public void newLineTest(){
        final String newLineToo = "1 2 3 \n 4 5 6";
        int exceptCount = 0;
        try {
            Scores withNewLine = new Scores(newLineToo);
        } catch(IllegalArgumentException e ){
            exceptCount++;
        }
        assertEquals(1, exceptCount);
    }
    @Test
    public void bigNumbersTest(){
        final String bigNumbersToo = "12345 23456 34567 8 9 70123";
        Scores withBig = new Scores(bigNumbersToo);
        assertEquals(6, withBig.getNumScores());
    }

    @Test
    public void allInt(){
        final String integers = "8 73 834 32516";
        Scores test = new Scores(integers);
        assertEquals(test.get(3),test.getMax());
    }
    //added this to test functionality of getMax


}