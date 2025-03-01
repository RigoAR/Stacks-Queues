import java.util.LinkedList;

public class DecodeString {

    public static void main(String[] args) {
        // Test cases
        System.out.println(decodeString("3[a]2[bc]"));       // aaabcbc
        System.out.println(decodeString("3[a2[c]]"));        // accaccacc
        System.out.println(decodeString("2[abc]3[cd]ef"));   // abcabccdcdcdef
    }

    public static String decodeString(String s)
    {
        LinkedList<Integer> countStack = new LinkedList<>();
        LinkedList<StringBuilder> stringStack = new LinkedList<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray())
        {
            if (Character.isDigit(ch))
            {
                k = k * 10 + (ch - '0');
            }
            else if (ch == '[')
            {
                countStack.add(k);
                stringStack.add(currentString);
                k = 0;
                currentString = new StringBuilder();
            }
            else if (ch == ']')
            {
                int count = countStack.removeLast();
                StringBuilder temp = currentString;
                currentString = stringStack.removeLast();
                for (int i = 0; i < count; i++)
                {
                    currentString.append(temp);
                }
            }
            else
            {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }


}
