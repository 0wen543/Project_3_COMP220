import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Scores {
    private final ArrayList<Integer> nums;

    /**
     * @param numbers should be a String with zero or more whitespace-delimited integers.
     *                Each integer is a score. This class holds the list of scores parsed from the String.
     * @throws IllegalArgumentException if numbers is not a whitespace-delimited list of zero or more integers.
     */
    public Scores(String numbers) throws IllegalArgumentException {
        Scanner scnr = new Scanner(numbers);
        scnr.useDelimiter(" ");

        nums = new ArrayList<>();
//        while(scnr.hasNext()){
//            int lineCount=0;
//            String line=scnr.nextLine();
//            if(Character.isWhitespace(line.charAt(lineCount))){
//                nums.add(0);
//                lineCount+=2;
//            }
//            if(){
//
//            }
//        }
        if(!scnr.hasNextInt()){
            throw new IllegalArgumentException();
        }
        while(scnr.hasNextInt()){
            nums.add(scnr.nextInt());
            if (!scnr.hasNext()){
                break;
            }
            else if (!scnr.hasNextInt()){
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * @return the number of scores in this object i.e. the number of integers in the String given to the constructor
     */
    public int getNumScores() { return nums.size(); }

    /**
     * @param index An integer index in the range [0, getNumScores())
     * @return The score at the specified index. For example, the first score in the String is at index 0.
     */
    public int get(int index) {
        if(index>=nums.size()||index<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return nums.get(index);
    }

    /**
     * @return the maximum score stored in this object
     * @throws java.util.NoSuchElementException if there are no scores
     */
    public int getMax() throws NoSuchElementException {
        int maxNum=0;

        if(nums.isEmpty()){
            throw new NoSuchElementException("The scores are empty");
        }

        for(int i=0; i<nums.size(); i++){
            if(maxNum<nums.get(i)){
                maxNum=nums.get(i);
            }
        }
        return maxNum;
    }
    /**
     * if all the grades are the same X
     * if no grades                   X
     * if out of bounds checking       X
     * if the grades sent are doubles  X
     * if the grades sent are punctuation  X
     * if the grades sent are letters     X
     * if the grades sent are negative     X
     * if numbers are delimited by : or something else   X
     * if there's space before the first grade   X
     * if there's too much space in between X
     *
     * NEW tests(feel free to check my logic)
     *
     * if there's one grade
     * if there's one letter, but the rest is a white space delimited list of ints
     * if the grades sent have a new line in them
     * if the grades sent are numbers with more than 4 digits
     */

}
