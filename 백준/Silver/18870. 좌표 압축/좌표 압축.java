import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // N개의 좌표
        int[] sorted = new int[N];  // 를 오름차순 정렬
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);    // 정렬된 arr
        int rank = 0;
        for (int value : sorted) {
            if (!map.containsKey(value)) {  // map에 좌표가 포함되지 않은 경우
                map.put(value, rank);   // 좌표, 순위 map에 저장   
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(map.get(value)).append(' ');  // map에서 좌표 == value 검색해 rank 출력
        }
        System.out.println(sb);
    }
}