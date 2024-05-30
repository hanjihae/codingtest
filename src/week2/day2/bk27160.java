package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bk27160 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> hg = new HashMap<>();
        for (int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String fruit = input[0];
            int num = Integer.parseInt(input[1]);
            hg.put(fruit, hg.getOrDefault(fruit, 0) + num); // 과일 이름이 동일할 때 num값 더하기
        }
        String ans = "NO";
        for (int value : hg.values()) {
            if (value == 5) {
                ans = "YES";
                break;
            }
        }
        System.out.println(ans);
    }
}
