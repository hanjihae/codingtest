import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ns = new StringTokenizer(br.readLine());
        n = Integer.parseInt(ns.nextToken());
        s = Integer.parseInt(ns.nextToken());   // 수열의 원소를 다 더한 값
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        // s가 0인 경우 공집합 제외를 위해 -1해서 출력
        System.out.println(s == 0 ? cnt-1 : cnt);
    }
    public static void dfs (int index, int sum) {
        // 모든 원소를 탐색한 경우
        if (index == n) {
            // 현재 부분 수열의 합이 s인 경우 카운트
            if (sum == s) {
                cnt++;
            }
            return;
        }
        // 현재 원소를 포함하는 경우
        dfs(index + 1, sum + arr[index]);
        // 현재 원소를 포함하지 않는 경우
        dfs(index + 1, sum);
    }
}