package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk24313 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        // f(n) = a1*n + a0 <= c*g(n) ? 1 : 0
        // f(n) = 7n + 7 , 8g(n) = 8n 일 때, 7n+7 <= 8n 이므로 a1 <= c
        if ((a1 * n) + a0 <= c * n && a1 <= c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
