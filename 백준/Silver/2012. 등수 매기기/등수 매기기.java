import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(br.readLine());  // 각 사람의 예상등수
        }
        Arrays.sort(rank);  // 불만도의 합을 최소화하기 위해 예상등수 오름차순 정렬
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(rank[i] - (i+1));
        }
        System.out.println(ans);
    }
}