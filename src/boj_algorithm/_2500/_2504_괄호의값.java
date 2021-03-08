package boj_algorithm._2500;

import java.io.*;
import java.util.Stack;

public class _2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<String> s = new Stack<>();

        boolean check = true;
        int sum = 0;
        int temp = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push("(");
                temp *= 2;
            } else if (str.charAt(i) == '[') {
                s.push("[");
                temp *= 3;
            } else if (!s.empty() && str.charAt(i) == ')') {
                if(str.charAt(i -1 ) == '(') {
                    sum += temp;
                }
                if (s.peek().equals("(")) {
                    s.pop();
                } else {
                    check = false;
                    break;
                }
                temp /= 2;
            } else if (!s.empty() && str.charAt(i) == ']') {
                if(str.charAt(i -1 ) == '[') {
                    sum += temp;
                }
                if (s.peek().equals("[")) {
                    s.pop();
                } else {
                    check = false;
                    break;
                }
                temp /=3;
            } else {
                check = false;
            }

        }
        if (check && s.empty()) {
            bw.write(String.valueOf(sum));
        } else {
            bw.write("0");
        }

        bw.close();
    }
}