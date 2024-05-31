package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk15650 {

    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1,0);
        System.out.println(sb.toString());
    }

    public static void dfs (int start, int depth) { // start : 어디서부터 시작하는지
        if (depth == M) { // depth == M일 때, 수열 공백으로 구분해서 sb.append
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=start; i <= N; i++) {
            arr[depth] = i; // 현재 위치의 수열에 숫자 추가
            dfs(i+1, depth+1);
            // 다음 숫자로 넘어갈 때 현재 숫자보다 큰 숫자로 이동하므로 사전순 정렬 따로 X - 백트래킹
        }
    }
}
