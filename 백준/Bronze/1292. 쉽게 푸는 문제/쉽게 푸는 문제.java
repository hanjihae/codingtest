import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 0;    // 반복 횟수 체크
        int ans = 0;    // 범위 내 합
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= i; j++) {
                cnt++;
                // 반복 횟수가 a - b 사이 일 때의 i의 누적합
                if (a <= cnt && cnt <= b) ans += i;
                if (cnt > b) break;
            }
        }
        System.out.println(ans);
    }
}