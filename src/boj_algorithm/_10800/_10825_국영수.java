package boj_algorithm._10800;

import java.util.Arrays;
import java.util.Scanner;

public class _10825_국영수 {
    static class Student {
        String name;
        int kor, en, math;
        Student(String name, int kor, int en, int math) {
            this.name = name;
            this.kor = kor;
            this.en = en;
            this.math = math;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Student[] arr = new Student[N];
        for(int i = 0; i < N; i++)
            arr[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        Arrays.sort(arr, (s1, s2) -> {
            if(s1.kor == s2.kor) {
                if(s1.en == s2.en) {
                    if(s1.math == s2.math)
                        return s1.name.compareTo(s2.name);
                    return s2.math - s1.math;
                }
                return s1.en - s2.en;
            }
            return s2.kor - s1.kor;
        });
        for(Student s : arr)
            System.out.println(s.name);
    }
}
