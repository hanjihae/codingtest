import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // 테스트케이스 수
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 문서의 개수
            int m = Integer.parseInt(st.nextToken());   // 몇번째로 인쇄되었는지 궁금한 문서의 개수
            LinkedList<int[]> queue = new LinkedList<>();   // 문서의 위치와 중요도 저장 큐
            StringTokenizer doc = new StringTokenizer(br.readLine());
            // 각 문서를 큐에 위치와 중요도를 배열로 저장
            for (int j = 0; j < n; j++) {
                queue.offer(new int[] {j, Integer.parseInt(doc.nextToken())});
            }
            int cnt = 0;    // 인쇄 순서
            while(!queue.isEmpty()) {
                int[] first = queue.poll(); // 첫번째 문서 꺼내기
                boolean max = true; // 현재 문서의 중요도가 가장 높은지
                for (int j = 0; j < queue.size(); j++) {
                    if (first[1] < queue.get(j)[1]) {   // 현재 문서보다 중요도가 높은 문서가 있는 경우
                        queue.offer(first); // 현재 문서를 큐의 마지막에 추가
                        // 현재 문서보다 중요도가 높은 문서를 순서대로 앞에 오도록
                        for (int k = 0; k < j; k++) {
                            queue.offer(queue.poll());
                        }
                        max = false;    // 현재 문서는 가장 중요한 문서가 아님
                        break;  // 비교 종료
                    }
                }
                if (!max) continue; // 현재 문서가 가장 중요한 문서가 아닌 경우 다시 반복
                // 현재 문서가 가장 중요한 문서인 경우
                cnt++;  // 인쇄 순서
                if(first[0] == m) break;    // 현재 문서가 궁금한 문서인 경우 종료
            }
            System.out.println(cnt);
        }
    }
}