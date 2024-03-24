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
        if(!scnr.hasNextInt()){
           throw new IllegalArgumentException();
        }
        while(scnr.hasNextInt()){
            nums.add(scnr.nextInt());
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
}
