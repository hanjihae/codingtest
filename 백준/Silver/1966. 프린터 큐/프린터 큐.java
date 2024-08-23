import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Doc {
    int index;  // 문서 인덱스
    int priority;   // 문서 중요도
    public Doc(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Doc> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(new Doc(j, num));
            }
            int order = 0;  // 인쇄 순서
            while (!queue.isEmpty()) {
                Doc cur = queue.poll();
                boolean hasHigherPriority = false;
                for (Doc d : queue) {
                    // 문서 중 현재 문서의 중요도보다 높은 게 있는지 확인
                    if (d.priority > cur.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }
                // 현재 문서보다 중요도 높은 게 있다면 큐에 현재 문서 넣기
                if (hasHigherPriority) {
                    queue.add(cur);
                } else {    // 현재 문서가 가장 높은 중요도를 가진다면
                    order++;    // 순서 카운트
                    if (cur.index == m) {   // 현재 문서의 인덱스가 m과 같다면 order 출력
                        System.out.println(order);
                        break;
                    }
                }
            }
        }
    }
}
