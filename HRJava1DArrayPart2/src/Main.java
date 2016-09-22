import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testCases = in.nextInt();
		
		while (testCases > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] array = new int[n];
			Deque<Integer> deque = new ArrayDeque<Integer>();
			HashSet<Integer> exploredSpots = new HashSet<Integer>();
			boolean jumpable = false;
			
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}
			
			deque.addLast(0);
			
			while (!deque.isEmpty()) {
				int elt = deque.removeFirst();
				exploredSpots.add(elt);
				
				if (elt + m >= n || elt + 1 >= n) {
					jumpable = true;
					break;
				}
				if (array[elt + 1] == 0 && !exploredSpots.contains(elt + 1)) {
					deque.addLast(elt + 1);
				}
				if (array[elt + m] == 0 && !exploredSpots.contains(elt + m)) {
					deque.addLast(elt + m);
				}
				if (elt > 0 && array[elt - 1] == 0 && !exploredSpots.contains(elt - 1)) {
					deque.addLast(elt - 1);
				}
				
			}
			System.out.println(jumpable ? "YES" : "NO");
			testCases--;
		}
		
		in.close();
	}
	

}
