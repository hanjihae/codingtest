import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 노래를 들으려면 모두 다운로드 된 상태여야
// 다운로드 시작한지 몇 초후에 들어야 끊김없이 노래를 들을 수 있는지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] songs = new int[n + 1][2];
        for (int i=1; i <= n; i++) {    // 누적해서 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            songs[i][0] = Integer.parseInt(st.nextToken()) + songs[i-1][0]; // 노래
            songs[i][1] = Integer.parseInt(st.nextToken()) + songs[i-1][1]; // 다운로드
        }
        int ans = 0;
        for (int i=n; i > 0; i--) {
            // 현재 노래 다운로드 완료 시간 - 이전 노래 길이 == 현재 노래 다운로드 완료 후 재생 가능한 시점
            ans = Math.max(ans, songs[i][1] - songs[i-1][0]);
        }
        System.out.println(ans);
    }
}
