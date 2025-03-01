import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        Map<Character, Character> equalPairs = new HashMap<>();
        equalPairs.put(')', '(');
        equalPairs.put(']', '[');
        equalPairs.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else {
                if (stack.isEmpty() || stack.removeLast() != equalPairs.get(ch)) {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) {
        String[] testCases = {"{[()]}", "{[(])}", "{{[[(())]]}}"};
        for (String testCase : testCases) {
            System.out.println(isBalanced(testCase));
        }
    }
}
