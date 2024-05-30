package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bk2908 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // reverse()로 숫자 뒤집 > String으로 변환 > int로 변환
        int a = Integer.parseInt(new StringBuilder(input[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(input[1]).reverse().toString());
        int ans = a > b ? a : b; // 수 비교
        System.out.println(ans);
    }
}
