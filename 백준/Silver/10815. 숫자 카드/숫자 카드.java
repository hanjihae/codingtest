import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   // 상근이가 이미 가지고 있는 카드
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        int[] ans = new int[M];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st1.nextToken());
            if (set.contains(m)) {
                ans[i] = 1;
            }
        }
        for (int a : ans) {
            System.out.print(a+ " ");
        }
    }
}