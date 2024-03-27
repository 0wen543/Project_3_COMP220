import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

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
        Scores test = new Scores(nothing);
        assertEquals(0,test.getNumScores());
    }

    @Test
    public void nonSpacedTest(){
        final String noSpaces = "435683461";
        Scores test = new Scores(noSpaces);
        assertEquals(1,test.getNumScores());
    }

    @Test
    public void outOfBoundTest(){
        final String outOfBound = "2 3";
        int exceptCount=0;
        Scores test = new Scores(outOfBound);
        try{
            test.get(8);
        }catch(IndexOutOfBoundsException e){
            exceptCount++;
        }
        try{
            test.get(-1);
        }catch (IndexOutOfBoundsException e){
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
    @Test
    public void spaceFirstTest(){
        final String spaceOne = "    1 2 3 4 5";
        Scores spaceyScores = new Scores(spaceOne);
        assertEquals(5,spaceyScores.getNumScores());
    }

    @Test
    public void spaceAfterTest(){
        final String spaceAfter = "1         2 3 4 5";
        Scores funkySpaces = new Scores(spaceAfter);
        assertEquals(5,funkySpaces.getNumScores());
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
        Scores withNewLine = new Scores(newLineToo);
        assertEquals(6,withNewLine.getNumScores());
    }
    @Test
    public void bigNumbersTest(){
        final String bigNumbersToo = "12345 23456 34567 8 9 70123";
        Scores withBig = new Scores(bigNumbersToo);
        assertEquals(6, withBig.getNumScores());
    }

    /*
    getMax() tests
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

    @Test
    public void emptyTest(){
        final String blank=" ";
        int exceptCount=0;
        Scores test = new Scores(blank);
        try{
            test.getMax();
        }catch (NoSuchElementException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }

    @Test
    public void fakeScores(){
        final String scores = "8 73 834 32516";
        Scores test = new Scores(scores);
        assertEquals(73,test.getMax());
    }
    //added tests to see if getMax will select a valid score on test

    @Test
    public void negativeGetMax(){
        final String scores="-42 -2 -100";
        Scores test = new Scores(scores);
        assertEquals(0,test.getMax());
    }

    @Test
    public void startMaxLocations(){
        final String startMax="100 42 77 55 67";
        Scores testA = new Scores(startMax);
        int maxCheck=0;
        if (testA.getMax()==100){
            maxCheck++;
        }
        assertEquals(1,maxCheck);

    }
    @Test
    public void midMaxLocation(){
        final String midMax="55 67 100 42 89";
        Scores testB = new Scores(midMax);
        int maxCheck=0;
        if (testB.getMax()==100){
            maxCheck++;
        }
        assertEquals(1,maxCheck);
    }
    @Test
    public void endMaxLocation(){
        final String endMax="78 99 33 92 100";
        Scores testC = new Scores(endMax);
        int maxCheck=0;
        if (testC.getMax()==100){
            maxCheck++;
        }
        assertEquals(1,maxCheck);
    }

}