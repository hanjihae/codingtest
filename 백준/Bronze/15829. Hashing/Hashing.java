import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        int r = 31;
        int m = 1234567891;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());   // 문자열 길이
        String[] str = br.readLine().split("");
        long pow = (long)Math.pow(r, 0);    // 거듭제곱 값
        long sum = 0;   // 해시 누적합
        for (int i = 0; i < length; i++) {
            int index = (int)str[i].charAt(0)-96;
            sum += (index * pow) % m;   // 문자열의 해시값 누적합
            pow = (pow * r) % m;    // 다음 거듭제곱 값 계산
        }
        sum = sum % m;  // 해시값을 m으로 나눈 나머지 계산
        System.out.println(sum);
    }
}