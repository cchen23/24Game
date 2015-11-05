
import java.util.Scanner;
import java.util.Arrays;

public class Solver {
		private int[] nums;
		
	public static void main(String[] args) {
		Solver puzzle = new Solver();
		SolutionTrie st = new SolutionTrie("Challenge24.txt");

		int numInts = 4;
		puzzle.nums = new int[numInts];
		boolean again = true;
		
		Scanner in = new Scanner(System.in);
		while (again) {
			//ask user for input numbers
			puzzle.nums = puzzle.getInput(numInts);
	
			//find solution
			String solution = puzzle.getSolution(st);
	
			//output solution or say if not possible
			if (solution.equals("none")) System.out.println("Not possible");
			else {
				System.out.println("One possible solution is" + solution);
			}
			
			System.out.println("Get another solution? y/n");
			String another = "y";
			if (in.hasNext()) another = in.next();
			another.toLowerCase();
			if (another.equals("n")) {
				again = false; 
			}
		}
		in.close();
	}

	//get input from command line user input
	private int[] getInput(int size) {
		int[] input = new int[size];
		int i = 0;

		System.out.println("Please enter " + size + 
				" space-separate integers between 1 and 13");
		
		Scanner in = new Scanner(System.in);
		while (i < size) {
			if (in.hasNext()) {
				int num = in.nextInt();
				if (num > 13 || num < 1) {
					System.out.println("Invalid number. Please enter a number" +
										"between 1 and 13");
				}
				else {
					input[i] = num;
					i++;
				}
			}
		}
		return input;
	}
	
	//return solution object from inputed integers
	private String getSolution(SolutionTrie st) {
		Arrays.sort(nums);
		Solution sol = new Solution(nums);
		return sol.getSolution(st);
	}
}


