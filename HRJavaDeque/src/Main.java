
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		int n = in.nextInt();
        int m = in.nextInt();
        int arrayDistinctMax = 0;
        int subarrayDistinct = 0;
        
        for (int i = 0; i < n; i++) {
        	int num = in.nextInt();
        	deque.addLast(num);
        	
        	if (!hm.containsKey(num)) {
        		hm.put(num, 1);
        		subarrayDistinct++;
        	} else {
        		hm.put(num, hm.get(num) + 1);
        	}
        	
        	// when deque gets bigger than M elts, remove first elt
        	if (deque.size() > m) {
        		int elt = deque.removeFirst();
        		int eltCount = hm.get(elt);
            	if (eltCount == 1) {
            		hm.remove(elt);
            		subarrayDistinct--;
            	} else {
            		hm.put(elt, hm.get(elt) - 1);
            	}
        	}
        	
        	// update max of unique elts
        	if (subarrayDistinct > arrayDistinctMax) {
        		arrayDistinctMax = subarrayDistinct;
        	}
        }
        
        in.close();
        
        System.out.println(arrayDistinctMax);
        
	}
	
	
	
}
