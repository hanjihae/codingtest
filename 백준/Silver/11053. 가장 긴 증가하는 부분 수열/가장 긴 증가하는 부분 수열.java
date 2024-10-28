import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];  // 위치에 따른 부분 수열 길이 저장
        int max = 0;
        for(int i=0; i < n; i++) {  // arr[i] : 현재 수열 위치
            dp[i] = 1;
            for(int j=0; j < i; j++) {
                if(arr[j] < arr[i]) {   // arr[0] ~ arr[i-1] 중 arr[i]보다 큰 값이 없다면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 이전 가장 큰 부분수열 길이와 비교해 더 큰 값 저장
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);    // 가장 긴 증가하는 부분 수열 길이 출력
    }
}
