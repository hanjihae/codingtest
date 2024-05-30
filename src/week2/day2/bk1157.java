package week2.day2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class bk1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase(); // 모두 대소문자로 변환
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); // 단어 개수 세기
        }
        boolean duplicateMaxValue = false;
        int maxValue = 0;
        char maxKey = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) { // 단어의 개수끼리 비교
                maxValue = entry.getValue();
                maxKey = entry.getKey();
                duplicateMaxValue = false;
            } else if (entry.getValue() == maxValue) {
                duplicateMaxValue = true; // max값 중복시 true
            }
        }
        if (duplicateMaxValue) {
            System.out.println("?");
        } else {
            System.out.println(maxKey);
        }
    }
}
