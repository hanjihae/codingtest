package Day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bk2480 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int money = 0;
        int num = 0;
        if ( a == b && b == c && a == c) {
            money = 10000 + a*1000;
        } else if ( a == b  || b == c || a == c) {
            num = b == c ? b : a;
            money = 1000 + num*100;
        } else {
            num = Math.max(a, Math.max(b, c));
            money = num*100;
        }
        System.out.println(money);

    }
}
