import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n + 1];
        for (int i=1; i <= n; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rank);  // 불만도의 합을 최소화하기 위해 오름차순 정렬
        long cnt = 0;
        for (int i=1; i <= n; i++) {
            cnt += Math.abs(rank[i] - i);   // 예상 등수와 실제 등수 차
        }
        System.out.println(cnt);
    }
}
