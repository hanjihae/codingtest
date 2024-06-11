import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();   // 의상 종류
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int ans = 1;
            for (int val : map.values()) {  // 각 종류 의상 수를 이용해 총 가짓수 계산
                ans *= val + 1; // 각 종류별로 의상을 선택 or not 경우의 수 곱셈
            }
            System.out.println(ans-1);  // 아무것도 고르지 않은 경우 빼고 출력
        }
    }
}