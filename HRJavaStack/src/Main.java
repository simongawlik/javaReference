
import java.util.*;

public class Main {
   
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
      
        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
        }
      
        sc.close();
    }
   
   
    public static boolean isBalanced(String s) {
	   
	    if (s.length() == 0) return true;
	   
	    Stack<Character> st = new Stack<Character>();
	   
	    for (Character c : s.toCharArray()) {
		    if ((c == '}' || c == ']' || c == ')') && st.isEmpty()) {
		    	return false;
		    } else if (c == '}' && st.peek() == '{') {
			    st.pop();
		    } else if (c == ']' && st.peek() == '[') {
			    st.pop();
		    } else if (c == ')' && st.peek() == '(') {
		   	    st.pop();
		    } else if (c == '{' || c == '[' || c == '(') {
			    st.push(c);
		    } else {
			    return false;
		    }
	    }
	    if (st.size() == 0) return true;
	   
	    return false;
    }
    
    // solution from other user on HR
    private static boolean isBalanced2(String s) {
    	
    	// Stack is deprecated data structure
    	final ArrayDeque<Character> stack = new ArrayDeque<> ();
    	final char[] chars = s.toCharArray ();
    	
    	// using charAt rather than toCharArray saves time and memory
    	for (int i = 0; i < s.length(); i++) {
    		
    		char c = s.charAt(i);
    	    // Matching character, . means not initialized
    	    char mc = '.';

    	    switch (c) {
    	    case '(':
    	    case '{':
    	    case '[':
    	        stack.addFirst (c);
    	        break;
    	    case ')':
    	        mc = '(';
    	    case '}':
    	        if (mc == '.') mc = '{';
    	    case ']':
    	        if (mc == '.') mc = '[';
    	        if (stack.isEmpty () ||  stack.removeFirst () != mc) {
    	            return false;
    	        }
    	        break;
    	    default:
    	    // Any other character is bad input data
    	        return false;
    	    }
    	}
     	return stack.isEmpty ();
    }
}
