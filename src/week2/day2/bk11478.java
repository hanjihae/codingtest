package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bk11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashSet<String> set = new HashSet<>();
        // 중복x 부분 문자열 생성
        for (int i=0; i < input.length(); i++) {
            for (int j=i+1; j <= input.length(); j++) {
                set.add(input.substring(i, j));
            }
        }
        int ans = set.size();
        System.out.println(ans);
    }
}
