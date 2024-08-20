import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            // 각 정수의 출현횟수 기록
            map.put(num, map.getOrDefault(num, 0 ) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        int [] ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            long num2 = Long.parseLong(st.nextToken());
            // num2가 map에 존재하면 value 없으면 0 출력
            ans[i] = map.getOrDefault(num2, 0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}
