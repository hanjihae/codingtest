package week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bk20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i < N; i++) {
            String[] str = br.readLine().split("\\.");
            String addr = str[1]; // 확장자만 분리
            map.put(addr, map.getOrDefault(addr, 0) + 1); // 확장자 개수 세기
        }
        String[] list = new String[map.size()];
        int num = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String ans = entry.getKey() + " " + entry.getValue(); // 확장자 + 개수 문자열 생성
            list[num++] = ans;
        }
        Arrays.sort(list); // 오름차순 정렬
        for(String s : list) { // 배열 for문 돌려서 하나씩 출력
            System.out.println(s);
        }
    }
}
