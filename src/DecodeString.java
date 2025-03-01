import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int C = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                C = C * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(C);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                C = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedSegment = stringStack.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    decodedSegment.append(currentString);
                }
                currentString = decodedSegment;
                } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
