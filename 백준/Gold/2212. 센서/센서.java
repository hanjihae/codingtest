import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 센서 개수
        int k = Integer.parseInt(br.readLine());    // 집중국 개수
        if (n <= k) {   // 집중국이 센서보다 많거나 같다면 0 출력
            System.out.println(0);
            return;
        }
        // 센서 위치
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 센서 위치 오름차순 정렬
        Arrays.sort(arr);
        
        int sum = 0;
        // 센서 간의 거리 차이 배열
        Integer[] dif = new Integer[n-1];
        for (int i = 0; i < n-1; i++) {
            dif[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(dif, Collections.reverseOrder());
        // 최솟값을 구하기 위해 내림차순 배열로 k-1개 제외하고 나머지 합산
        for (int i=k-1; i < n-1; i++) {
            sum += dif[i];
        }
        System.out.println(sum);
    }
}