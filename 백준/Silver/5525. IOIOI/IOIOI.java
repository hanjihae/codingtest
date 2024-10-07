import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // 패턴의 길이는 2n + 1입니다.
        int patternLength = 2 * n + 1;
        int count = 0;
        int result = 0;

        for (int i = 0; i < m - 2; i++) {
            // 'IOI' 패턴이 발견되면
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                count++;
                // 패턴이 'Pn'에 도달한 경우
                if (count == n) {
                    result++;
                    count--; // 중첩된 패턴을 고려하기 위해 count를 1 줄인다.
                }
                i++; // 'OI'를 건너뛰기 위해 i를 1 증가시킨다.
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}
