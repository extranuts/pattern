package leetcode.brackets;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ** 1.(()) -true  ()) false
 * 2. add more brackets {[]}//
 * solution with Stack
 */

public class SolutionOne {

    public static boolean checkBrackets(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {

            Character closedBracket = str.charAt(i);
            Character openBracket = map.get(closedBracket);
            if (openBracket == null) {
                deque.add(closedBracket);
            } else {
                if (deque.size() == 0 || deque.pollLast() != openBracket) {
                    return false;
                }
            }

        }
        return deque.size() == 0;

    }

    public static void main(String[] args) {


        boolean result = checkBrackets("({}}}{{[])");
        System.out.println(result);

    }
}
