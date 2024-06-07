import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 필요한 시간의 최솟값 순서
        int sum = 0;    // 필요한 시간의 합
        int waiting = 0;    // 인당 기다려야하는 시간
        for (int i = 0; i < N; i++) {
            waiting += arr[i];
            sum += waiting;
        }
        System.out.println(sum);
    }
}