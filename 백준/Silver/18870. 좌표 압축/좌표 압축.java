import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int order = 0;
        for (int value : sorted) {
            if (!map.containsKey(value)) {  // 해당 숫자를 갖고 있지 않을 때
                map.put(value, order++);    // 랭크 저장
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            // 원래 배열에 저장되어 있는 순서대로 map에 저장된 랭크 호출
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
