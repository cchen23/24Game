
public class Solution {
	int[] input;
	//int[] operations; //0 = +, 1 = -, 2 = *, 3 = /
	//int numOps = 4;
	
	public Solution(int[] a) {
		input = a;
	}

	//Solution using 9-way trie
	public String getSolution(SolutionTrie st) {
		return st.getSolution(input);
	}
	//Solution using calculations
	/*private void getSolution(int[] a) {
		int w = a[0];
		int x = a[1];
		int y = a[2];
		int z = a[3];
		
		int result = -1;
		while (result != 24) {
			for (int i = 0; i < numOps; i++) {
				for (int j = 0; j < numOps; j++) {
					double mid1 = calc(w, x, i);
					double mid2 = calc(y, z, j);
					result = (int) calc(mid1, mid2, i);
				}
			}
		}
	} */
}
