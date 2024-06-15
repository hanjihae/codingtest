import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String mix = "";
        for (int i = 0; i < a.length(); i++) {  // 핸드폰 번호 믹스
            mix += a.charAt(i);
            mix += b.charAt(i);
        }
        while (mix.length() > 2) {  // 궁합 문자열 길이가 2가 될 때까지
            String ans = "";
            for (int i = 1; i < mix.length(); i++) {
                int sum = (mix.charAt(i-1)-'0') + (mix.charAt(i)-'0');  // i-1, i번째 숫자 추출해서 더하기
                ans += String.valueOf(sum % 10);    // 1의 자릿수만 넣기
            }
            mix = ans;  // 새로 만들어진 문자열을 while문 돌릴 문자열에 저장
        }
        System.out.println(mix);
    }
}