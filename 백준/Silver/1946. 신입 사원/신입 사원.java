import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());    // 지원자 수
            int[] rank = new int[n+1];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken()); // 서류 등수
                int itv = Integer.parseInt(st.nextToken()); // 면접 등수
                rank[doc] = itv;    // 서류 등수에 따른 면접 등수를 확인할 수 있음
            }
            int ans = 1;    // 채용 가능한 지원자 수 (1등은 무조건 채용되므로 1)
            int standard = rank[1]; // 1등의 면접 등수를 기준으로
            for (int k=2; k <= n; k++) {
                if (rank[k] < standard) {   // 현재 지원자보다 면접 등수가 기준보다 높으면
                    ans++;  // 채용 가능한 지원자 수 증가
                    standard = rank[k]; // 기준 면접 등수를 현재 지원자 면접 등수로 변경
                }
            }
            System.out.println(ans);
        }
    }
}