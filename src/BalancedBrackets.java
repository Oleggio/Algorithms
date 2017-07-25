import java.util.Stack;

/**
 * Created by oleggio on 7/23/17.
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        //input here
        String in = "{[(])}";
        System.out.println(isBalanced(in) ? "YES" : "NO");

    }

    static boolean isBalanced(String in) {

        String opBrackets = "{([";

        Stack<Character> stack = new Stack();
        char currentTop;
        for (char currentIn : in.toCharArray()) {

            if(opBrackets.indexOf(currentIn) >= 0) {
                stack.push(currentIn);
            }
            else if(!stack.empty())
            {
                currentTop = stack.pop();
                if(     (currentIn == ')' && currentTop != '(') ||
                        (currentIn == '}' && currentTop != '{') ||
                        (currentIn == ']' && currentTop != '['))
                return false;
            }
            else return true;
        }

        return stack.isEmpty();

    }
}
