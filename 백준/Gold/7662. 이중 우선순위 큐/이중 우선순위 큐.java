import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            // 최소힙
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            // 최대힙
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j=0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (str.equals("I")) {  // 삽입
                    minQueue.add(num);
                    maxQueue.add(num);
                    // map에 숫자 빈도 업데이트
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {    // 삭제
                    // 빈도가 기록된 숫자가 없다면 넘어가기
                    if (map.isEmpty()) continue;
                    if (num == 1) { // + 최댓값 삭제
                        removeElement(maxQueue, map);
                    } else {    // - 최솟값 삭제
                        removeElement(minQueue, map);
                    }
                }
            }
            if (map.isEmpty()) {    // 맵이 비어있으면 EMPTY 출력
                sb.append("EMPTY\n");
            } else {
                // 큐에서 제거된 요소를 동기화
                while (!maxQueue.isEmpty() && map.getOrDefault(maxQueue.peek(), 0) == 0) {
                    maxQueue.poll();
                }
                while (!minQueue.isEmpty() && map.getOrDefault(minQueue.peek(), 0) == 0) {
                    minQueue.poll();
                }
                int max = maxQueue.peek();
                int min = minQueue.peek();
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int removeElement(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
        while(!queue.isEmpty()) {
            int element = queue.poll();
            // 해당 숫자의 빈도수 조회
            int cnt = map.getOrDefault(element, 0);
            if (cnt == 0) continue; // 빈도가 0이면 무시
            if (cnt == 1) { // 빈도가 1이면 맵에서 제거
                map.remove(element);
            } else {    // 빈도가 1 이상이면 빈도를 1 감소
                map.put(element, cnt - 1);
            }
            return element;
        }
        return 0;   // 큐가 비어있는 경우
    }
}
