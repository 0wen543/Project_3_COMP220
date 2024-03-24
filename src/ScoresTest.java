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
        Scores aTest = new Scores(doubles);
        }catch (IllegalArgumentException e){
        exceptCount++;
        }
        assertEquals(1,exceptCount);
    }

    @Test
    public void negativeTest(){
        final String negatives ="-4 -25 -87";

        Scores bTest = new Scores(negatives);
        assertEquals(3,bTest.getNumScores());
    }

    @Test
    public void nothingTest(){
        final String nothing = "";

        Scores cTest = new Scores(nothing);
        assertEquals(0,cTest.getNumScores());
    }

    @Test
    public void zeroTest(){
        final String zeros = "0 0 0 0 0 0 0 0";

        Scores dTest = new Scores(zeros);
        assertEquals(0,dTest.getNumScores());
    }

    @Test
    public void bigTest(){
        final String noSpaces = "43568346176437014389690";

        Scores eTest = new Scores(noSpaces);
        assertEquals(1,eTest.getNumScores());
    }

    @Test
    public void outOfBoundTest(){
        final String outOfBound = "2 3";
        int exceptCount=0;
        Scores fTest = new Scores(outOfBound);
        try{
            fTest.get(8);
        }catch(ArrayIndexOutOfBoundsException e){
            exceptCount++;
        }
        try{
            fTest.get(-1);
        }catch (ArrayIndexOutOfBoundsException e){
            exceptCount++;
        }
        assertEquals(2,exceptCount);
    }


    /*
     * getMax() tests
     */
    @Test
    public void maxTest(){
        final String same ="4 4 4 4";

        Scores gTest = new Scores(same);
        assertEquals(4,gTest.getMax());
    }

    @Test
    public void negativeMaxTest(){
        final String negatives="-32 4 6 7";

        Scores hTest = new Scores(negatives);
        assertEquals(7,hTest.getMax());
    }

    @Test
    public void emptyTest(){
        final String blank=" ";
        int exceptCount=0;
        Scores iTest = new Scores(blank);
        try{
            iTest.getMax();
        }catch (NoSuchElementException e){
            exceptCount++;
        }
        assertEquals(1,exceptCount);
    }
}