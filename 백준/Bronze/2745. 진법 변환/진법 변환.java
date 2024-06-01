import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        String N = st.nextToken();  // B진법 수 N
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < N.length(); i++) {
            char n = N.charAt(i);
            int value = 0;
            if ('A' <= n && n <= 'Z') {
                value = 10 + (n -'A');
                // 예를 들어 n이 0이면 n-'A' = 0, A:10, ... Z:35 이기 때문에 +10
            } else {
                value = n - '0';
            }
            ans = ans * B + value;  // ans = ans * 자릿수(0, 10, 100...) + n에 매핑된 수
        }
        System.out.println(ans);
    }
}