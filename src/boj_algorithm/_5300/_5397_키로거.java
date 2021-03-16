package boj_algorithm._5300;

import java.io.*;
import java.util.Stack;

public class _5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            System.out.println(solve(br.readLine()));
        }
    }
    private static String solve(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] password = input.toCharArray();

        for (char ch : password) {
            switch (ch) {
                case '<':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case '>':
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case '-':
                    if (!left.isEmpty()) left.pop();
                    break;
                default:
                    left.push(ch);
            }
        }
        // 왼쪽 스택의 값 저장
        for (Character character : left) {
            result.append(character);
        }
        // 오른쪽 스택의 값 저장
        while(!right.isEmpty())
            result.append(right.pop());

        return result.toString();
    }
}
