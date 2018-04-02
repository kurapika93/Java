
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class insertionSortMain {
	public static ArrayList<Integer> randomArrayList(int belowthreshold , int upperthreshold, int totalRandomNumber ) {
		Random rand = new Random();
		Integer[] ints = new Integer[totalRandomNumber];
		for ( int i = 0 ; i<totalRandomNumber;i++ ) {
			
			ints[i] = rand.nextInt((upperthreshold - belowthreshold )+ 1) + belowthreshold;
		
	
		}
		return new ArrayList<Integer>(Arrays.asList(ints));
	}
	
	public static void main (String[]args) {
		
		int belowthreshold = 6;
		int upperthreshold = 10;
		int totalRandomNumber = 50;
		
		ArrayList<Integer> integers = randomArrayList(belowthreshold, upperthreshold, totalRandomNumber);
		
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}

