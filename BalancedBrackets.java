import java.util.LinkedList;

public class BalancedBrackets
{

    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced("{[()]}"));       // YES
        System.out.println(isBalanced("{[(])}"));       // NO
        System.out.println(isBalanced("{{[[(())]]}}"));  // YES
    }

    public static String isBalanced(String s)
    {
        if (s == null || s.isEmpty()) {
            return "YES";
        }

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.add(current);
            }
            else {
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.peek();

                if ((current == ')' && top == '(') || (current == ']' && top == '[') || (current == '}' && top == '{'))
                {
                    stack.remove(); // Remove the  opening bracket if they matc
                } else
                {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }


}