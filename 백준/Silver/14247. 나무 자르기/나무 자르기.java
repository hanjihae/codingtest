import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] trees = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) { // 나무 높이
            trees[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) { // 나무 성장 속도
            trees[i][1] = Integer.parseInt(st.nextToken());
        }
        // 성장 속도 기준 오름차순 정렬
        Arrays.sort(trees, (a, b) -> Integer.compare(a[1], b[1]));
        long ans = 0;
        for(int i=0; i < n; i++) {
            ans += (long) trees[i][0] + (long) trees[i][1] * i;
        }
        System.out.println(ans);
    }
}