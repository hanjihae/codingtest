import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 왼쪽에 자기보다 큰 사람 몇 명이었는지만 기억한다면 줄 어떻게 서야하는지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        for (int i=1; i <= n; i++) {
            int cnt = heights[i];   // 내 왼편에 나보다 키 큰 사람 수
            int idx = 1;    // 자리 번호
            // 내 왼편에 나보다 키 큰 사람이 없을 때까지 다음자리로 이동
            while(cnt > 0 || ans[idx] != -1) {
                if (ans[idx] == -1) {    // 빈자리(-1)면 cnt 감소
                    cnt--;
                }
                idx++;  // 다음자리로 이동
            }
            ans[idx] = i;   // 더 이상 내 왼편으로 나보다 키 큰 사람이 없다면 거기가 내 자리
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
