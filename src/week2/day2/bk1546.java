package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bk1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] grades = br.readLine().split(" ");
        int max = 0;
        double sum = 0;
        int[] grades2 = new int[grades.length];
        for (int i=0; i < grades.length; i++) {
            grades2[i] = Integer.parseInt(grades[i]);
            if (grades2[i] > max) max = grades2[i];
            sum += grades2[i];
        }
        System.out.println(((sum/max)*100)/num);
    }
}
