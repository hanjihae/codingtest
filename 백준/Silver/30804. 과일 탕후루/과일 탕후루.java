import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[n];
        for (int i=0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right=0; right < fruits.length; right++) { // 오른쪽 포인터
            // 현재 과일을 맵에 추가하고 개수 증가
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2) { // 과일이 2개 이상일 때 과일 빼기
                map.put(fruits[left], map.get(fruits[left]) - 1);
                // 과일 개수가 0이 되면 맵에서 제거
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++; // 왼쪽 포인터 이동
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
