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
        assertEquals(1,test.getNumScores());
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
}