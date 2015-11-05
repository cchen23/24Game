import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SolutionTrie {
	private static int N = 13;
	private Node root = new Node();
	
	private static class Node {
		private String solution;
		private Node[] next = new Node[N];
	}
	
	//constructs solution trie based on filename
	public SolutionTrie(String fileName) {
		//set up solution trie with four levels
		for (int i = 0; i < N; i++) {
			root.next[i] = new Node();
			for (int j = 0; j < N; j++) {
				root.next[i].next[j] = new Node();
				for (int k = 0; k < N; k++) {
					root.next[i].next[j].next[k] = new Node();
					for (int l = 0; l < N; l++) {
						root.next[i].next[j].next[k].next[l] = new Node();
					}
				}
			}
		}
		
		File file = new File(fileName);
		Scanner input;
		try {
			input = new Scanner(file);
		
			//fill levels with solution strings
			while (input.hasNextLine()) {
				int i = input.nextInt() - 1;
				int j = input.nextInt() - 1;
				int k = input.nextInt() - 1;
				int l = input.nextInt() - 1;
				input.next();
				String str = input.next();
				root.next[i].next[j].next[k].next[l].solution = str;
			}
			input.close();
		}
	    catch (FileNotFoundException e) {
	    	System.out.println("File not found");
	    	e.printStackTrace();
	    }
	}
	
	public String getSolution(int[] a) {
		assert (a.length == 4) : "Array length of incorrect size";
		return root.next[a[0] - 1].next[a[1] - 1].next[a[2] - 1].next[a[3] - 1].solution;
	}
}