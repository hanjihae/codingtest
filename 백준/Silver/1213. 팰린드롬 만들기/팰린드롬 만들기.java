import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 임한수의 영어 이름
        int[] alpha = new int[26];  // 알파벳 빈도 수 저장 배열
        // 입력된 이름의 각 알파벳 빈도수 저장
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }
        int isOdd = 0;  // 홀수 빈도의 알파벳 개수 카운트
        int num = 0;    // 홀수 빈도의 알파벳 인덱스를 저장
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1) {    // 빈도수가 홀수인 경우
                isOdd++;
                num = i;
            }
            // 홀수 빈도의 알파벳이 2개 이상이면 팰린드롬 생성 불가능
            if (isOdd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 각 알파벳 빈도의 절반을 결과 문자열에 추가
        for (int i = 0; i < alpha.length; i++) {
            int len = alpha[i]/2;
            for (int j = 0; j < len; j++) {
                sb.append((char)(i+'A'));
            }
        }
        String ans = sb.toString();
        if (isOdd == 1) {   // 홀수 빈도의 알파벳이 존재하면 가운데에 추가
            ans += (char)(num+'A');
        }
        // 절반의 문자열 뒤집어서 더함
        ans += sb.reverse().toString();
        System.out.println(ans);
    }
}