import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Evgeny Davidenko
 * @version 17.03.2023
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(getValidBrackets(")(((())"));

        System.out.println(getValidBrackets(")(()()()(()()))))((())"));
        System.out.println(getValidBrackets(")"));

        System.out.println(getValidBrackets(""));
    }

    public static String getValidBrackets(String s) {
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < result.length(); i++) {
            char current = result.charAt(i);
            if (current == '(') {
                deque.push(i);
            } else if (!deque.isEmpty() && result.charAt(deque.peek()) == '(') {
                deque.pop();
                count += 2;
            } else {
                deque.push(i);
            }
        }
        while (!deque.isEmpty()) {
            int index = deque.pop();
            result.deleteCharAt(index);
        }
        return count > 0 ? result.insert(0, (count) + " - ").toString() : "0";
    }
}